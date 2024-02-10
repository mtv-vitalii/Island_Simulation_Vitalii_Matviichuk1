package com.javarush.OrganismFactory;

import com.javarush.organism.Organism;

public interface OrganismFactory {
    Organism createOrganism();
    Organism createOrganism(String type);
}
