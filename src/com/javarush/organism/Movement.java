package com.javarush.organism;

import com.javarush.Map.Cell;
import com.javarush.Map.Field;
import com.javarush.organism.animal.Animal;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Movement {

    private Field field;
    private Map<Animal, Integer> movedAnimals = new HashMap<>();
    private Map<Animal, Integer> stayedAnimals = new HashMap<>();
    private Random random = new Random();

    public Movement(Field field) {
        this.field = field;
    }

    public void executeMovement() {
        for (int y = 0; y < field.getHeight(); y++) {
            for (int x = 0; x < field.getWidth(); x++) {
                Cell cell = field.getCell(x, y);
                for (Organism organism : cell.getOrganism()) {
                    if (organism instanceof Animal) {
                        Animal animal = (Animal) organism;
                        Directions direction = Directions.values()[random.nextInt(Directions.values().length)];
                        int steps = animal.getMoveSteps(); // Припускаємо, що є такий метод
                        if (canMove(animal, direction, steps)) {
                            animal.move(steps, direction);
                            movedAnimals.merge(animal, 1, Integer::sum);
                        } else {
                            stayedAnimals.merge(animal, 1, Integer::sum);
                        }
                    }
                }
            }
        }
        printStatistics();
    }

    public boolean canMove(Animal animal, Directions direction, int steps) {
        Cell currentCell = animal.getCell(); // Припускаємо, що є метод getCell() для тварини
        int fieldSize = field.getSize();
        int newX = currentCell.getX();
        int newY = currentCell.getY();

        switch (direction) {
            case NORTH:
                newY -= steps;
                break;
            case EAST:
                newX += steps;
                break;
            case SOUTH:
                newY += steps;
                break;
            case WEST:
                newX -= steps;
                break;
        }

        // Обробка виходу за межі поля
        if (newX < 0) newX = fieldSize + newX; // Якщо виходимо за межі зліва, переміщаємось справа
        else if (newX >= fieldSize) newX = newX - fieldSize; // Якщо виходимо за межі справа, переміщаємось зліва

        if (newY < 0) newY = fieldSize + newY; // Якщо виходимо за межі зверху, переміщаємось знизу
        else if (newY >= fieldSize) newY = newY - fieldSize; // Якщо виходимо за межі знизу, переміщаємось зверху

        // Перевірка на наявність простору для переміщення в нову клітинку
        // Для спрощення, вважаємо, що переміщення завжди можливе
        // У реальній програмі тут може бути логіка перевірки на максимальну кількість тварин в клітинці

        return true; // Тварина може переміститися
    }

    private void printStatistics() {
        System.out.println("Moved animals: " + movedAnimals.size());
        System.out.println("Stayed animals: " + stayedAnimals.size());
    }
}
