package com.javarush.organism;

import com.javarush.Map.Cell;
import com.javarush.OrganismFactory.*;
import com.javarush.organism.animal.AnimalSpecies;
import com.javarush.organism.animal.AnimalsParameterReader;
import com.javarush.organism.Organism;
import com.javarush.organism.plant.Grass;

import java.io.FileNotFoundException;
import java.util.*;

public class Reproducing {
    private final Map<String, Integer> maxCountsCache = new HashMap<>();
    private Map<String, OrganismFactory> factoryMap = new HashMap<>();

    /*public Reproducing() throws FileNotFoundException {
        initializeMaxCounts();
        initializeFactoryMap();
    }*/

    public Reproducing(GeneralOrganismFactory generalOrganismFactory) throws FileNotFoundException {
        initializeMaxCounts();
        initializeFactoryMap();
    }

    private void initializeMaxCounts() throws FileNotFoundException {
        AnimalsParameterReader animalsParameterReader = new AnimalsParameterReader();
        List<AnimalSpecies> speciesNames = animalsParameterReader.readSpeciesFromFile();
        for (AnimalSpecies species : speciesNames) {
            maxCountsCache.put(species.getName(), species.getMaxCount());
        }
    }

    private void initializeFactoryMap() {
        factoryMap.put("Wolf", new WolfFactory());
        factoryMap.put("Horse", new HorseFactory());
        factoryMap.put("Goat", new GoatFactory());
        factoryMap.put("Rabbit", new RabbitFactory());
        factoryMap.put("Grass", new GrassFactory());// Продовжуйте додавати інші фабрики тут
    }

    public void execute(Cell cell) {
        Map<String, Integer> organismCounts = new HashMap<>();
        // Підрахунок кількості кожного типу організмів у клітинці
        cell.getOrganism().forEach(organism ->
                organismCounts.merge(organism.getTypeResidents(), 1, Integer::sum));

        organismCounts.forEach((speciesName, count) -> {
            OrganismFactory factory = factoryMap.get(speciesName);
            if (factory != null) {
                if (speciesName.equals("Grass")) {
                    // Для трави просто додаємо ще один екземпляр без обмежень
                    cell.addOrganism(factory.createOrganism());
                } else {
                    // Для інших організмів перевіряємо умови розмноження
                    int maxCount = getMaxCountForSpecies(speciesName);
                    if (count >= 2 && count < maxCount) {
                        // Якщо умови дозволяють, додаємо ще один екземпляр організму
                        cell.addOrganism(factory.createOrganism());
                    }
                }
            }
        });
    }

    private int getMaxCountForSpecies(String speciesName) {
        return maxCountsCache.getOrDefault(speciesName, Integer.MAX_VALUE);
    }

    @Override
    public String toString() {
        return "Reproducing{" +
                "maxCountsCache=" + maxCountsCache +
                ", factoryMap=" + factoryMap +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reproducing that = (Reproducing) o;
        return Objects.equals(maxCountsCache, that.maxCountsCache) && Objects.equals(factoryMap, that.factoryMap);
    }

    @Override
    public int hashCode() {
        return Objects.hash(maxCountsCache, factoryMap);
    }
}