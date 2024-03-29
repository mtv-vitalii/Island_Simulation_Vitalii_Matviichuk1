package com.javarush.organism.animal.Predators;


import com.javarush.Map.Cell;
import com.javarush.organism.Organism;

import java.util.Objects;


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

    public Wolf(String id,Integer weight) {
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Wolf wolf = (Wolf) o;
        return maxFood == wolf.maxFood && isAlive == wolf.isAlive && weight == wolf.weight && health == wolf.health && maxAmount == wolf.maxAmount && maxSpeed == wolf.maxSpeed && Objects.equals(id, wolf.id) && Objects.equals(name, wolf.name) && Objects.equals(cell, wolf.cell);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), maxFood, isAlive, weight, health, maxAmount, maxSpeed, id, name, cell);
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
            case "Horse","Buffalo" -> 10;
            case "Deer","Boar"->15;
            case "Duck"->40;
            case "Sheep"->70;
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







