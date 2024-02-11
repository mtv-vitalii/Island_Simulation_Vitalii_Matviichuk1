package com.javarush.OrganismsParameters;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AnimalsParameterReader {

    public List<AnimalSpecies> readSpeciesFromFile() throws FileNotFoundException {
        List<AnimalSpecies> species = new ArrayList<>();
        Scanner scanner = new Scanner(new File("C:\\Users\\matvv\\IdeaProjects\\Island_Simulation_Vitalii_Matviichuk\\src\\com\\javarush\\OrganismsParameters\\OrganismSpecies"));

        if (scanner.hasNextLine()) {
            scanner.nextLine();//перший рядок пропускаємо
        }

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] data = line.split(",");

            String name = data[0];
            double weight = Double.parseDouble(data[1]);
            int maxCount = Integer.parseInt(data[2]);
            int speed = Integer.parseInt(data[3]);
            double fullness = Double.parseDouble(data[4]);

            species.add(new AnimalSpecies(name, weight, maxCount, speed, fullness));
        }

        scanner.close();
        return species;
    }


    @Override
    public String toString() {
        return "AnimalsParameterReader{}";
    }
}

