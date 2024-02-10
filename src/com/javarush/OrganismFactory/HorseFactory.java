package com.javarush.OrganismFactory;

import com.javarush.organism.Organism;
import com.javarush.organism.animal.Predators.Wolf;
import com.javarush.organism.animal.herbivores.Horse;

import java.util.UUID;

public class HorseFactory implements OrganismFactory{


    private String name;
    private int weight;

    public HorseFactory() {
    }

    @Override
    public Organism createOrganism() {
        return new Horse(UUID.randomUUID().toString());
    }

    @Override
    public Organism createOrganism(String type) {
        return new Horse(UUID.randomUUID().toString());}
}
