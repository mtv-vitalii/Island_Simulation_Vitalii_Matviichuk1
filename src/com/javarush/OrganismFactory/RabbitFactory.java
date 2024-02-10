package com.javarush.OrganismFactory;

import com.javarush.organism.Organism;
import com.javarush.organism.animal.herbivores.Goat;
import com.javarush.organism.animal.herbivores.Rabbit;

import java.util.UUID;

public class RabbitFactory implements OrganismFactory {
        private String name;
        private String id;

        private int weight;

        public RabbitFactory() {
        }

        @Override
        public Organism createOrganism() {
            return new Rabbit(UUID.randomUUID().toString());
        }

    @Override
    public Organism createOrganism(String type)  {
        return new Rabbit(UUID.randomUUID().toString());
    }

}

