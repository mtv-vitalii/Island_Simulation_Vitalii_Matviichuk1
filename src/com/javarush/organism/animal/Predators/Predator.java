package com.javarush.organism.animal.Predators;

import com.javarush.organism.animal.Animal;

public abstract class Predator extends Animal {
    public Predator(String id) {
        super(id);
    }

    @Override
    public String getType() {
        return "Predator";
    }

    @Override
    public String getTypeResidents() {
        return null;
    }

    @Override
    public int Moving() {
        return 0;
    }

    @Override
    public void Reproducing() {

    }

    public abstract String getName();

    @Override
    public int getMaxFood() {
        return super.getMaxFood();
    }

    @Override
    public void setMaxFood(int maxFood) {
        super.setMaxFood(maxFood);
    }

    @Override
    public boolean isAlive() {
        return super.isAlive();
    }

    @Override
    public void setAlive(boolean alive) {
        super.setAlive(alive);
    }

    @Override
    public int getWeight() {
        return super.getWeight();
    }

    @Override
    public void setWeight(int weight) {
        super.setWeight(weight);
    }

    @Override
    public int getHealth() {
        return super.getHealth();
    }

    @Override
    public void setHealth(int health) {
        super.setHealth(health);
    }

    @Override
    public int getMaxAmount() {
        return super.getMaxAmount();
    }

    @Override
    public void setMaxAmount(int maxAmount) {
        super.setMaxAmount(maxAmount);
    }

    @Override
    public int getMaxSpeed() {
        return super.getMaxSpeed();
    }

    @Override
    public void setMaxSpeed(int maxSpeed) {
        super.setMaxSpeed(maxSpeed);
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    public abstract void Eating();
}
