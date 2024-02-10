package com.javarush.organism.plant;

import com.javarush.organism.Organism;
import com.javarush.organism.Reproducible;

import java.util.Objects;

public abstract class Plant extends Organism implements Reproducible{
    boolean isAlive;
    int maxAmount;
    String id;
    String name;

    public Plant(String id) {
        super(id);
        this.id = id;
    }

    @Override
    public String getType() {
        return "Plant";
    }

    @Override
    public boolean isAlive() {
        return isAlive;
    }

    @Override
    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    @Override
    public int getMaxAmount() {
        return maxAmount;
    }

    @Override
    public void setMaxAmount(int maxAmount) {
        this.maxAmount = maxAmount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Plant plant = (Plant) o;
        return isAlive == plant.isAlive && maxAmount == plant.maxAmount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(isAlive, maxAmount);
    }

    public abstract String getName();

    @Override
    public String toString() {
        return "Plant{" +
                "isAlive=" + isAlive +
                ", maxAmount=" + maxAmount +
                '}';
    }
}
