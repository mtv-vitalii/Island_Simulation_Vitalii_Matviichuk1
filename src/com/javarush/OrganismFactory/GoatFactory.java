package com.javarush.OrganismFactory;

import com.javarush.organism.Organism;
import com.javarush.organism.animal.herbivores.Goat;

import java.util.UUID;

public class GoatFactory implements OrganismFactory {
    private String name;
    private int weight;

    public GoatFactory() {
    }

    @Override
    public Organism createOrganism() {
        return new Goat(getName(), getWeight());
    }

    @Override
    public Organism createOrganism(String type) {
        return new Goat(getName(), getWeight());
    }

    public String getName() {
        return "Goat";
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}

