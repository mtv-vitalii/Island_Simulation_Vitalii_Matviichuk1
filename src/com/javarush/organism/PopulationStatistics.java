package com.javarush.organism;

import com.javarush.Map.Cell;
import com.javarush.Map.Field;
import com.javarush.OrganismFactory.GeneralOrganismFactory;
import com.javarush.organism.Eat;
import com.javarush.organism.Organism;
import com.javarush.organism.Reproducing;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import com.javarush.OrganismFactory.OrganismFactory;

//import static com.javarush.organism.Reproducing;

public class PopulationStatistics {
    private Field field;
    private OrganismFactory organismFactory;
    //Reproducing reproducing=new Reproducing();


    public PopulationStatistics(Field field, OrganismFactory organismFactory) throws FileNotFoundException {
        this.organismFactory =organismFactory;
        this.field = field;
    }

    public void collectInitialStatistics() {
        Map<String, Integer> initialPopulation = countOrganisms(field.getIslandField());
        System.out.println("Початкова популяція на острові:");
        printStatistics(initialPopulation);
    }

    public void collectStatisticsAfterFeeding() {
        executeFeeding();
        Map<String, Integer> populationAfterFeeding = countOrganisms(field.getIslandField());
        System.out.println("Популяція на острові після харчування:");
        printStatistics(populationAfterFeeding);
    }

    public void collectStatisticsAfterReproduction() {
        executeReproduction();
        Map<String, Integer> populationAfterReproduction = countOrganisms(field.getIslandField());
        System.out.println("Популяція на острові після розмноження:");
        printStatistics(populationAfterReproduction);
    }

    private void executeFeeding() {
        ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        for (List<Cell> row : field.getIslandField()) {
            for (Cell cell : row) {
                executor.submit(() -> {
                    new Eat().execute(cell);
                });
            }
        }
        executor.shutdown();
        while (!executor.isTerminated()) {}
    }

    private void executeReproduction(){
        ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        for (List<Cell> row : field.getIslandField()) {
            for (Cell cell : row) {
                executor.submit(() -> {
                    try {
                        new Reproducing((GeneralOrganismFactory) organismFactory).execute(cell);
                    } catch (FileNotFoundException e) {
                        throw new RuntimeException(e);
                    }
                });
            }
        }
        executor.shutdown();
        while (!executor.isTerminated()) {}
    }

    private Map<String, Integer> countOrganisms(List<List<Cell>> islandField) {
        Map<String, Integer> statistics = new HashMap<>();
        for (List<Cell> row : islandField) {
            for (Cell cell : row) {
                for (Organism organism : cell.getOrganism()) {
                    String organismName = organism.getTypeResidents();
                    statistics.put(organismName, statistics.getOrDefault(organismName, 0) + 1);
                }
            }
        }
        return statistics;
    }

    private void printStatistics(Map<String, Integer> statistics) {
        statistics.forEach((name, count) -> System.out.println(name + ": " + count));
    }
}