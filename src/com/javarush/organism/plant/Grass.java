package com.javarush.organism.plant;

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
