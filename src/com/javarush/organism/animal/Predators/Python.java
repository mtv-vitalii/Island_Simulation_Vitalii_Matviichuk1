package com.javarush.organism.animal.Predators;


import com.javarush.Map.Cell;
import com.javarush.organism.Organism;

import java.util.Objects;


public class Python extends Predator {


    int maxFood;
    boolean isAlive;
    int weight;
    int health;
    int maxAmount;
    int maxSpeed;
    String id;
    String name;
    public Cell cell;

    public Python(String id,Integer weight) {
        super(id);
        this.weight = 15;
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
        Python python = (Python) o;
        return maxFood == python.maxFood && isAlive == python.isAlive && weight == python.weight && health == python.health && maxAmount == python.maxAmount && maxSpeed == python.maxSpeed && Objects.equals(id, python.id) && Objects.equals(name, python.name) && Objects.equals(cell, python.cell);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), maxFood, isAlive, weight, health, maxAmount, maxSpeed, id, name, cell);
    }

    @Override
    public String toString() {
        return "Python{" +
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
        return "Python";
    }

    @Override
    public int getMaxFood() {
        return maxFood;
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
        return "Python";
    }
    @Override
    public int getAttack(String organisms) {
        return switch (organisms) {
            case "Duck"->10;
            case "Fox" -> 15;
            case "Rabbit" -> 20;
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







