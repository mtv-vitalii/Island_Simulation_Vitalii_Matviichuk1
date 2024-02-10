package com.javarush.organism.animal;

import com.javarush.Map.Cell;
import com.javarush.OrganismFactory.OrganismFactory;
import com.javarush.organism.Movable;
import com.javarush.organism.Organism;
import com.javarush.organism.Reproducible;

import java.util.Objects;

public abstract class Animal extends Organism implements Movable, Reproducible, OrganismFactory {
    int maxFood;
    boolean isAlive;
    int weight;
    int health;
    int maxAmount;
    int maxSpeed;
    String id;
    String name;
    public Cell cell;

    public Animal(String id) {
        super(id);
        this.weight = weight;
        this.id = id;
    }
    public Cell getCell() {
        return cell;
    }

    @Override
    public String getTypeResidents() {
        return null;
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
    public int Moving() {
        return 0;
    }

    @Override
    public int getAttack(String organism) {
        return super.getAttack(organism);
    }

    @Override
    public void Reproducing() {

    }

    @Override
    public String toString() {
        return "Animal{" +
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
        Animal animal = (Animal) o;
        return maxFood == animal.maxFood && isAlive == animal.isAlive && weight == animal.weight && health == animal.health && maxAmount == animal.maxAmount && maxSpeed == animal.maxSpeed;
    }

    @Override
    public int hashCode() {
        return Objects.hash(maxFood, isAlive, weight, health, maxAmount, maxSpeed);
    }
}
