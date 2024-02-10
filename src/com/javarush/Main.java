package com.javarush;
import com.javarush.Map.Cell;
import com.javarush.Map.Field;
import com.javarush.OrganismFactory.GeneralOrganismFactory;
import com.javarush.organism.Eat;
import com.javarush.organism.PopulationStatistics;

import java.io.FileNotFoundException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        try {
            // Статична ініціалізація видів (якщо потрібно, інакше забезпечити завантаження видів перед використанням)
            // Це може бути виконано в іншому місці програми, де забезпечується ініціалізація даних

            // Ініціалізація поля (острова) з заданими розмірами
            Field island = new Field(100, 20);

            // Ініціалізація статистики
            GeneralOrganismFactory organismFactory = new GeneralOrganismFactory();
            PopulationStatistics statistics = new PopulationStatistics(island, organismFactory);

            // Показати статистику популяції до дій
            //System.out.println("Статистика популяції перед діями:");
            statistics.collectInitialStatistics();
            statistics.collectStatisticsAfterFeeding();
            statistics.collectStatisticsAfterReproduction();

            // Виконання дій (наприклад, харчування і розмноження)
            //performActions(island);

            // Показати статистику популяції після дій
            //System.out.println("Статистика популяції після дій:");
            //statistics.printIslandPopulationStatistics(island);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}