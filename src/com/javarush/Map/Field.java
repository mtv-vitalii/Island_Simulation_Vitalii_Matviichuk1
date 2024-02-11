package com.javarush.Map;

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


    public List<List<Cell>> getIslandField() {
        return islandField;
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
