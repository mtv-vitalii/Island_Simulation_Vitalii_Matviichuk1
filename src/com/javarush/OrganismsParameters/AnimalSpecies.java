package com.javarush.OrganismsParameters;

public class AnimalSpecies {
    private String name;
    private double weight;
    private int maxCount;
    private int speed;
    private double fullness;

    public AnimalSpecies(String name, double weight, int maxCount, int speed, double fullness) {
        this.name = name;
        this.weight = weight;
        this.maxCount = maxCount;
        this.speed = speed;
        this.fullness = fullness;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getMaxCount() {
        return maxCount;
    }


    @Override
    public String toString() {
        return "AnimalSpecies{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                ", maxCount=" + maxCount +
                ", speed=" + speed +
                ", fullness=" + fullness +
                '}';
    }
}
