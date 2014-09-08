package net.amigocraft.pore.implementation.entity;


import org.bukkit.entity.Bat;



public class PoreBat extends PoreAmbient implements Bat {
    // TODO: Bridge

    // Overrided from Bat

    @Override
    public boolean isAwake() {
        return false;
    }

    @Override
    public void setAwake(boolean state) {

    }




}
