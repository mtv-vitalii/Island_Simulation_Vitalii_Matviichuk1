package com.javarush.organism.animal.Predators;


import com.javarush.Map.Cell;
import com.javarush.organism.Organism;


public class Wolf extends Predator {


    int maxFood;
    boolean isAlive;
    int weight;
    int health;
    int maxAmount;
    int maxSpeed;
    String id;
    String name;
    public Cell cell;

    public Wolf(String id) {
        super(id);
        this.weight = weight;
        this.id = id;
    }

    @Override
    public Cell getCell() {
        return super.getCell();
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Wolf{" +
                "maxFood=" + maxFood +
                ", isAlive=" + isAlive +
                ", weight=" + weight +
                ", health=" + health +
                ", maxAmount=" + maxAmount +
                ", maxSpeed=" + maxSpeed +
                '}';
    }

    @Override
    public String getName() {
        return "Wolf";
    }

    @Override
    public int getMaxFood() {
        return maxFood=8;
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
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public int Moving() {
        return super.Moving();
    }

    @Override
    public void Eating() {

    }
    @Override
    public String getTypeResidents() {
        return "Wolf";
    }
    @Override
    public int getAttack(String organisms) {
        return switch (organisms) {
            case "Horse" -> 10;
            case "Rabbit", "Goat" -> 60;
            default ->0;
        };
    }

    @Override
    public Organism createOrganism() {
        return null;
    }

    @Override
    public Organism createOrganism(String type) {
        return null;
    }
}







