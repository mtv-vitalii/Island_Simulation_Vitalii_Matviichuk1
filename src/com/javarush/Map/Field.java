package com.javarush.Map;

import com.javarush.OrganismFactory.*;
import com.javarush.OrganismManager.OrganismManager;
import com.javarush.organism.Organism;
import com.javarush.organism.animal.AnimalSpecies;
import com.javarush.organism.animal.AnimalsParameterReader;

import java.io.FileNotFoundException;
import java.util.*;

public class Field {
    private int width;
    private int height;
    private List<List<Cell>> islandField;

    public Field(int width, int height) throws FileNotFoundException {
        this.width = width;
        this.height = height;
        initializeField();
    }

    private void initializeField() throws FileNotFoundException {
        islandField = new ArrayList<>();
        for (int i = 0; i < width; i++) {
            List<Cell> row = new ArrayList<>();
            for (int j = 0; j < height; j++) {
                row.add(new Cell());
            }
            islandField.add(row);
        }
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public List<List<Cell>> getIslandField() {
        return islandField;
    }
    public List<Organism> getAllOrganisms() {
        List<Organism> allOrganisms = new ArrayList<>();
        for (List<Cell> row : islandField) {
            for (Cell cell : row) {
                allOrganisms.addAll(cell.getOrganism()); // Припускаємо, що getAnimals() повертає список організмів в клітині
            }
        }
        return allOrganisms;
    }
    public Cell getCell(int x, int y) {
        // Коригуємо координати, щоб вони "згорталися" навколо країв поля
        int correctedX = (x + width) % width;
        int correctedY = (y + height) % height;

        // Повертаємо клітину за скоригованими координатами
        return islandField.get(correctedY).get(correctedX);
    }
    public Integer getX(int x) {
        int correctedX = (x + width) % width;
        return correctedX;
    }
    public Integer getY(int y) {
        int correctedY = (y + height) % height;
        return correctedY;
    }


    public void setIslandField(List<List<Cell>> islandField) {
        this.islandField = islandField;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Field field = (Field) o;
        return width == field.width && height == field.height && Objects.equals(islandField, field.islandField);
    }

    @Override
    public int hashCode() {
        return Objects.hash(width, height, islandField);
    }


}
