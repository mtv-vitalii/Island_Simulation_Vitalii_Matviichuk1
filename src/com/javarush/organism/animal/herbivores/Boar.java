package com.javarush.organism.animal.herbivores;

import com.javarush.Map.Cell;
import com.javarush.organism.Organism;

import java.util.Objects;

public class Boar extends Herbivores{
    int maxFood;
    boolean isAlive;
    int weight;
    int health;
    int maxAmount;
    int maxSpeed;
    String id;
    String name;
    public Cell cell;


    public Boar(String id, Integer weight) {
        super(id);
        this.weight = 400;
        this.id = id;
    }

    @Override
    public Cell getCell() {
        return super.getCell();
    }

    @Override
    public String getName() {
        return "Boar";
    }

    @Override
    public String toString() {
        return "Boar{" +
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
        Boar boar = (Boar) o;
        return maxFood == boar.maxFood && isAlive == boar.isAlive && weight == boar.weight && health == boar.health && maxAmount == boar.maxAmount && maxSpeed == boar.maxSpeed && Objects.equals(id, boar.id) && Objects.equals(name, boar.name) && Objects.equals(cell, boar.cell);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), maxFood, isAlive, weight, health, maxAmount, maxSpeed, id, name, cell);
    }

    @Override
    public int getMaxFood() {
        return maxFood;
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
        return "Boar";
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
        return new Boar(getName(), getWeight());
    }

}
