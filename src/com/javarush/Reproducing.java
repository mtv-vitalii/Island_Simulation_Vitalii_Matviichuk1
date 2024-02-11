package com.javarush;

import com.javarush.Map.Cell;
import com.javarush.OrganismFactory.GeneralOrganismFactory;
import com.javarush.OrganismsParameters.AnimalSpecies;
import com.javarush.OrganismsParameters.AnimalsParameterReader;

import java.io.FileNotFoundException;
import java.util.*;

public class Reproducing {
    private final Map<String, Integer> maxCountsCache = new HashMap<>();
    private final GeneralOrganismFactory generalOrganismFactory;

    public Reproducing(GeneralOrganismFactory generalOrganismFactory) throws FileNotFoundException {
        this.generalOrganismFactory = generalOrganismFactory;
        initializeMaxCounts();
    }

    private void initializeMaxCounts() throws FileNotFoundException {
        AnimalsParameterReader animalsParameterReader = new AnimalsParameterReader();
        List<AnimalSpecies> speciesNames = animalsParameterReader.readSpeciesFromFile();
        for (AnimalSpecies species : speciesNames) {
            maxCountsCache.put(species.getName(), species.getMaxCount());
        }
    }

    public void execute(Cell cell) {
        Map<String, Integer> organismCounts = new HashMap<>();
        // Підрахунок кількості кожного типу організмів у клітинці
        cell.getOrganism().forEach(organism ->
                organismCounts.merge(organism.getTypeResidents(), 1, Integer::sum));

        organismCounts.forEach((speciesName, count) -> {
                if (speciesName.equals("Grass")) {
                    // Для трави просто додаємо ще один екземпляр без обмежень
                    cell.addOrganism(generalOrganismFactory.createOrganism(speciesName));
                } else {
                    // Для інших організмів перевіряємо умови розмноження
                    int maxCount = getMaxCountForSpecies(speciesName);
                    if (count >= 2 && count < maxCount) {
                        // Якщо умови дозволяють, додаємо ще один екземпляр організму
                        cell.addOrganism(generalOrganismFactory.createOrganism(speciesName));
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
                ", generalOrganismFactory=" + generalOrganismFactory +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reproducing that = (Reproducing) o;
        return Objects.equals(maxCountsCache, that.maxCountsCache) &&
                Objects.equals(generalOrganismFactory, that.generalOrganismFactory);
    }

    @Override
    public int hashCode() {
        return Objects.hash(maxCountsCache, generalOrganismFactory);
    }
}