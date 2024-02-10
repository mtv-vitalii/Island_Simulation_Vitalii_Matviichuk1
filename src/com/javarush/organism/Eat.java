package com.javarush.organism;

import com.javarush.Map.Cell;
import com.javarush.Map.Field;
import com.javarush.organism.animal.Predators.Predator;
import com.javarush.organism.animal.herbivores.Herbivores;
import com.javarush.organism.plant.Grass;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Eat {
    public void execute(Cell cell) {
        List<Organism> newResidents = new ArrayList<>(cell.getOrganism());
        Collections.shuffle(newResidents); // Рандомізуємо для реалізму

        List<Organism> deadOrganisms = new ArrayList<>();

        for (Organism organism : newResidents) {
            if (organism instanceof Predator) {
                handlePredator(cell, organism, deadOrganisms);
            } else if (organism instanceof Herbivores) {
                handleHerbivore(cell, organism, deadOrganisms);
            }
        }

        // Видаляємо всіх організмів, що померли
        for (Organism deadOrganism : deadOrganisms) {
            cell.removeOrganism(deadOrganism);
        }
    }

    private void handlePredator(Cell cell, Organism predator, List<Organism> deadOrganisms) {
        boolean hasEaten = false;
        for (Organism potentialPrey : new ArrayList<>(cell.getOrganism())) {
            if (predator != potentialPrey && potentialPrey instanceof Herbivores) {
                int attackProbability = predator.getAttack(potentialPrey.getTypeResidents());
                int randomChance = (int) (Math.random() * 100);
                if (randomChance < attackProbability) {
                    cell.removeOrganism(potentialPrey); // Хижак їсть травоїдного
                    hasEaten = true;
                    break;
                }
            }
        }
        if (!hasEaten) {
            deadOrganisms.add(predator);// помирає хижак
        }
    }

    private void handleHerbivore(Cell cell, Organism herbivore, List<Organism> deadOrganisms) {
        if (!cell.hasGrass()) {
            deadOrganisms.add(herbivore);
        } else {
            cell.removeGrass(); // видалення трави
        }
    }
}


