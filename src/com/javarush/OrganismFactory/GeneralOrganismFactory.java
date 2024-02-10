package com.javarush.OrganismFactory;

import com.javarush.organism.Organism;
import com.javarush.organism.animal.Predators.Wolf;
import com.javarush.organism.animal.herbivores.Goat;
import com.javarush.organism.animal.herbivores.Horse;
import com.javarush.organism.animal.herbivores.Rabbit;
import com.javarush.organism.plant.Grass;

import java.util.UUID;

public class GeneralOrganismFactory implements OrganismFactory {

    public Organism createOrganism(String type) {
        switch (type) {
            case "Goat":
                return new Goat(UUID.randomUUID().toString(), 60);
            case "Wolf":
                return new Wolf(UUID.randomUUID().toString());
            case "Horse":
                return new Horse(UUID.randomUUID().toString());
            case "Rabbit":
                return new Rabbit(UUID.randomUUID().toString());
            case "Grass":
                return new Grass(UUID.randomUUID().toString());
            default:
                throw new IllegalArgumentException("Unknown organism type: " + type);
        }
    }

    @Override
    public Organism createOrganism() {
        return null;
    }

    @Override
    public String toString() {
        return "GeneralOrganismFactory{}";
    }
}
