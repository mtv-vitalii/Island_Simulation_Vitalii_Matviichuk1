package com.javarush.organism.animal.herbivores;

import com.javarush.Map.Cell;
import com.javarush.organism.Organism;

import java.util.Objects;

public class Deer extends Herbivores{
    int maxFood;
    boolean isAlive;
    int weight;
    int health;
    int maxAmount;
    int maxSpeed;
    String id;
    String name;
    public Cell cell;


    public Deer(String id, Integer weight) {
        super(id);
        this.weight = 300;
        this.id = id;
    }

    @Override
    public Cell getCell() {
        return super.getCell();
    }

    @Override
    public String getName() {
        return "Deer";
    }

    @Override
    public String toString() {
        return "Deer{" +
                "maxFood=" + maxFood +
                ", isAlive=" + isAlive +
                ", weight=" + weight +
                ", health=" + health +
                ", maxAmount=" + maxAmount +
                ", maxSpeed=" + maxSpeed +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Deer deer = (Deer) o;
        return maxFood == deer.maxFood && isAlive == deer.isAlive && weight == deer.weight && health == deer.health && maxAmount == deer.maxAmount && maxSpeed == deer.maxSpeed && Objects.equals(id, deer.id) && Objects.equals(name, deer.name) && Objects.equals(cell, deer.cell);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), maxFood, isAlive, weight, health, maxAmount, maxSpeed, id, name, cell);
    }

    @Override
    public int getMaxFood() {
        return maxFood=10;
    }

    @Override
    public void setMaxFood(int maxFood) {
        this.maxFood = maxFood;
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
    public int getWeight() {
        return weight;
    }

    @Override
    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public int getHealth() {
        return health;
    }

    @Override
    public void setHealth(int health) {
        this.health = health;
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
    public int getMaxSpeed() {
        return maxSpeed;
    }

    @Override
    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    @Override
    public String getTypeResidents() {
        return "Deer";
    }

    @Override
    public int getAttack(String organisms) {
        return switch (organisms) {
            case "Grass" -> 100;
            default -> 0;
        };
    }

    @Override
    public int Moving() {
        return super.Moving();
    }

    @Override
    public void Reproducing() {
        super.Reproducing();
    }

    @Override
    public Organism createOrganism() {
        return null;
    }

    @Override
    public Organism createOrganism(String type) {
        return new Deer(getName(), getWeight());
    }

}
