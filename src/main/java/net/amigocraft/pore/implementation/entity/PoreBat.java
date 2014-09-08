package net.amigocraft.pore.implementation.entity;


import org.bukkit.entity.Bat;

/**
 * Created by russjr08 on 9/8/14.
 */
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
