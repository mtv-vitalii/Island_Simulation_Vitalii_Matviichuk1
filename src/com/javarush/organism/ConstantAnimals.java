package com.javarush.organism;

import com.javarush.organism.animal.Predators.Wolf;
import com.javarush.organism.animal.herbivores.Horse;
import com.javarush.organism.animal.herbivores.Rabbit;
import com.javarush.organism.plant.Grass;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ConstantAnimals{
    public static final int attachHerbivores=100;

/*
    // Створюємо екземпляри класів тварин
    Organism wolf = new Carnivore("Wolf", 40, 5);
    Organism horse = new Herbivore("Horse", 500, 10);
    Organism rabbit = new Herbivore("Rabbit", 2, 1);
    Organism grass = new Plant("Grass", 0.1, 0);

    // Додаємо їх до мапи, використовуючи ключі за допомогою методу getClass()
    map.put(wolf.getClass(), wolf);
    map.put(horse.getClass(), horse);
    map.put(rabbit.getClass(), rabbit);
    map.put(grass.getClass(), grass);

    // Виводимо вміст мапи на екран
    for (Map.Entry<Class<?>, Organism> entry : map.entrySet()) {
        System.out.println(entry.getKey().getSimpleName() + " -> " + entry.getValue().getName());
    }
}

}

// Результат виводу: Carnivore -> Wolf Herbivore -> Rabbit Plant -> Grass Herbivore -> Horse
*/


}
