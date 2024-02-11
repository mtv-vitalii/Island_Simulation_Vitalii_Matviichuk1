package com.javarush.Map;

import com.javarush.OrganismFactory.GeneralOrganismFactory;
import com.javarush.organism.Organism;
import com.javarush.OrganismsParameters.AnimalSpecies;
import com.javarush.OrganismsParameters.AnimalsParameterReader;
import com.javarush.organism.plant.Grass;

import java.io.FileNotFoundException;
import java.util.*;

public class Cell {

    private List<Organism> residents;
    private GeneralOrganismFactory generalFactory;

    public Cell() throws FileNotFoundException {
        residents = new ArrayList<>();
        generalFactory = new GeneralOrganismFactory(); // Ініціалізуємо фабрику
        populateCell();
    }

    public void populateCell() throws FileNotFoundException {
        AnimalsParameterReader animalsParameterReader = new AnimalsParameterReader();
        List<AnimalSpecies> speciesNames = animalsParameterReader.readSpeciesFromFile();
        for (AnimalSpecies species : speciesNames) {
            int count = getRandomCount(species.getMaxCount());
            for (int i = 0; i < count; i++) {
                Organism organism = generalFactory.createOrganism(species.getName());
                if (organism != null) {
                    residents.add(organism);
                }
            }
        }
    }

    private int getRandomCount(int maxCount) {
        // Генеруємо випадкову кількість тварин для клітинки
        return (int) (Math.random() * (maxCount + 1));
    }

    public void addOrganism(Organism organism) {
        residents.add(organism);
    }

    public void removeOrganism(Organism organism) {
        residents.remove(organism);
    }

    public void removeGrass() {
        // Шукаємо екземпляр трави серед організмів
        Iterator<Organism> iterator = this.residents.iterator();
        while (iterator.hasNext()) {
            Organism organism = iterator.next();
            if (organism instanceof Grass) {
                iterator.remove(); // Видаляємо траву
                break;
            }
        }
    }

    public List<Organism> getOrganism() {
        return residents;
    }

    public boolean hasGrass() {
        for (Organism organism : residents) {
            if (organism instanceof Grass) {
                return true; // Знайдено траву, повертаємо true
            }
        }
        return false; // Траву не знайдено, повертаємо false
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cell cell = (Cell) o;
        return Objects.equals(residents, cell.residents);
    }

    @Override
    public int hashCode() {
        return Objects.hash(residents);
    }

    @Override
    public String toString() {
        return "Cell{" +
                "residents=" + residents +
                '}';
    }
}