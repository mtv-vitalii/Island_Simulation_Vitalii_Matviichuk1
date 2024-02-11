package com.javarush.organism.plant;

import java.util.Objects;

public class Grass extends Plant{
    boolean isAlive;
    int maxAmount;
    String id;
    String name;

    public Grass(String id) {
        super(id);
        this.id = id;
    }

    @Override
    public String getName() {
        return "Grass";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Grass grass = (Grass) o;
        return isAlive == grass.isAlive && maxAmount == grass.maxAmount && Objects.equals(id, grass.id) && Objects.equals(name, grass.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), isAlive, maxAmount, id, name);
    }

    @Override
    public String toString() {
        return "Grass{" +
                "isAlive=" + isAlive +
                ", maxAmount=" + maxAmount +
                ", id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public int getMaxAmount() {
        return maxAmount;
    }

    @Override
    public void Reproducing() {

    }

    @Override
    public String getTypeResidents() {
        return "Grass";
    }

    @Override
    public int getAttack(String organisms) {
        return 0;
    }

}
