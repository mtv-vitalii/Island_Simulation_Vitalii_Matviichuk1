package com.javarush.OrganismFactory;

import com.javarush.organism.Organism;
import com.javarush.organism.animal.Predators.*;
import com.javarush.organism.animal.herbivores.*;
import com.javarush.organism.plant.Grass;

import java.util.UUID;

public class GeneralOrganismFactory implements OrganismFactory {

    public Organism createOrganism(String type) {
        switch (type) {
            case "Goat":
                return new Goat(UUID.randomUUID().toString(), 60);
            case "Wolf":
                return new Wolf(UUID.randomUUID().toString(),50);
            case "Horse":
                return new Horse(UUID.randomUUID().toString(),400);
            case "Rabbit":
                return new Rabbit(UUID.randomUUID().toString(),2);
            case "Boar":
                return new Boar(UUID.randomUUID().toString(), 400);
            case "Buffalo":
                return new Buffalo(UUID.randomUUID().toString(),700);
            case "Deer":
                return new Deer(UUID.randomUUID().toString(),300);
            case "Duck":
                return new Duck(UUID.randomUUID().toString(),1);
            case "Sheep":
                return new Sheep(UUID.randomUUID().toString(),70);
            case "Bear":
                return new Bear(UUID.randomUUID().toString(),500);
            case "Eagle":
                return new Eagle(UUID.randomUUID().toString(),6);
            case "Fox":
                return new Fox(UUID.randomUUID().toString(),8);
            case "Python":
                return new Python(UUID.randomUUID().toString(),15);
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
