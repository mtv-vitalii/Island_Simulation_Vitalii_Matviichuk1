package com.javarush.Statistics;

import com.javarush.Map.Cell;
import com.javarush.Map.Field;
import com.javarush.OrganismFactory.GeneralOrganismFactory;
import com.javarush.Eat;
import com.javarush.Reproducing;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class PopulationStatistics {
    private Field field;
    private GeneralOrganismFactory organismFactory;

    public PopulationStatistics(Field field, GeneralOrganismFactory organismFactory) {
        this.organismFactory = organismFactory;
        this.field = field;
    }

    public void startLifeCycle() throws FileNotFoundException {
        collectInitialStatistics(); // Збір початкової статистики

        for (int i = 0; i < 5; i++) {
            executeFeeding();
            executeReproduction();
            System.out.println();
            collectStatistics("Після циклу " + (i + 1));
        }
    }

    private void collectStatistics(String message) {
        Map<String, Integer> populationStatistics = countOrganisms(field.getIslandField());
        System.out.println(message);
        printStatistics(populationStatistics);
    }

    private void executeFeeding() {
        field.getIslandField().parallelStream().flatMap(List::stream).forEach(cell -> new Eat().execute(cell));
    }

    private void executeReproduction() {
        field.getIslandField().parallelStream().flatMap(List::stream).forEach(cell -> {
            try {
                new Reproducing(organismFactory).execute(cell);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        });
    }

    public void collectInitialStatistics() {
        Map<String, Integer> initialPopulation = countOrganisms(field.getIslandField());
        System.out.println("Початкова популяція на острові:");
        printStatistics(initialPopulation);
    }

    private Map<String, Integer> countOrganisms(List<List<Cell>> islandField) {
        Map<String, Integer> statistics = new ConcurrentHashMap<>();
        islandField.parallelStream().flatMap(List::stream).forEach(cell -> {
            cell.getOrganism().forEach(organism -> {
                statistics.compute(organism.getTypeResidents(), (name, count) -> count == null ? 1 : count + 1);
            });
        });
        return statistics;
    }

    private void printStatistics(Map<String, Integer> statistics) {
        statistics.forEach((name, count) -> System.out.println(name + ": " + count));
    }
}