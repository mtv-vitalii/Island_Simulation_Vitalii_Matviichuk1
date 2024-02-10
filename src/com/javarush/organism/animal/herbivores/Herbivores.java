package com.javarush.organism.animal.herbivores;

import com.javarush.organism.Organism;
import com.javarush.organism.Residents;
import com.javarush.organism.animal.Animal;

public abstract class Herbivores extends Animal {
    public Herbivores(String id) {
        super(id);
    }

    @Override
    public String getType() {
        return "Herbivore";
    }

    public int getAttack(Organism organism) {
        return 0;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    public abstract String getName();

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int Moving() {
        return 0;
    }

    @Override
    public void Reproducing() {

    }
}
