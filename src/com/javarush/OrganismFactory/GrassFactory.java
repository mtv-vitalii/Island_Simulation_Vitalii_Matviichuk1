package com.javarush.OrganismFactory;

import com.javarush.organism.Organism;
import com.javarush.organism.plant.Grass;

import java.util.UUID;

public class GrassFactory implements OrganismFactory {
        private String name;
        private int maxAmount;

        public GrassFactory() {
        }

        @Override
        public Organism createOrganism() {
            return new Grass(UUID.randomUUID().toString());
        }

    @Override
    public Organism createOrganism(String type)  {
        return new Grass(UUID.randomUUID().toString());
    }
}

