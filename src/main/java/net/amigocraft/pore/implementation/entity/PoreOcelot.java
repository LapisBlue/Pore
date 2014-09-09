package net.amigocraft.pore.implementation.entity;

import org.bukkit.entity.Ocelot;

public class PoreOcelot extends PoreTameableAnimal implements Ocelot {
    // TODO: Bridge
    @Override
    public Type getCatType() {
        return null;
    }

    @Override
    public void setCatType(Type type) {

    }

    @Override
    public boolean isSitting() {
        return false;
    }

    @Override
    public void setSitting(boolean sitting) {

    }
}
