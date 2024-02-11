package com.javarush;
import com.javarush.Map.Field;
import com.javarush.OrganismFactory.GeneralOrganismFactory;
import com.javarush.Statistics.PopulationStatistics;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) {
        try {
            Field field = new Field(100, 20);
            GeneralOrganismFactory organismFactory = new GeneralOrganismFactory(); // Ініціалізація фабрики організмів

            PopulationStatistics populationStatistics = new PopulationStatistics(field,organismFactory);
            populationStatistics.startLifeCycle(); // виклик життєвого циклу
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


}