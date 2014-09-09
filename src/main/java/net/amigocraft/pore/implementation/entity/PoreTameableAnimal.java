package net.amigocraft.pore.implementation.entity;

import org.bukkit.entity.AnimalTamer;
import org.bukkit.entity.Creature;
import org.bukkit.entity.Tameable;

public class PoreTameableAnimal extends PoreAnimals implements Tameable, Creature {
    // TODO: Bridge
    @Override
    public boolean isTamed() {
        return false;
    }

    @Override
    public void setTamed(boolean tame) {

    }

    @Override
    public AnimalTamer getOwner() {
        return null;
    }

    @Override
    public void setOwner(AnimalTamer tamer) {

    }
}
