package com.javarush.organism.animal;

public class AnimalSpecies {
    private String name;
    private double weight;
    private int maxCount;
    private int speed;
    private double fullness;
    public AnimalSpecies(){}

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

    public void setMaxCount(int maxCount) {
        this.maxCount = maxCount;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public double getFullness() {
        return fullness;
    }

    public void setFullness(double fullness) {
        this.fullness = fullness;
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
