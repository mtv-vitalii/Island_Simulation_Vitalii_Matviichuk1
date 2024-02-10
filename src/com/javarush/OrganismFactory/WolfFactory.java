package com.javarush.OrganismFactory;

import com.javarush.organism.Organism;
import com.javarush.organism.animal.Predators.Wolf;

import java.util.UUID;

public class WolfFactory implements OrganismFactory {
        private String name;
        private int weight;

        public WolfFactory() {
        }

        @Override
        public Organism createOrganism() {
            return new Wolf(UUID.randomUUID().toString());
        }

    @Override
    public Organism createOrganism(String type)  {
        return new Wolf(UUID.randomUUID().toString());
    }
}

