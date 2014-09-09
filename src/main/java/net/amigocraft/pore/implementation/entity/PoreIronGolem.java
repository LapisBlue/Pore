package net.amigocraft.pore.implementation.entity;

import org.bukkit.entity.IronGolem;

public class PoreIronGolem extends PoreGolem implements IronGolem {
    // TODO: Bridge
    @Override
    public boolean isPlayerCreated() {
        return false;
    }

    @Override
    public void setPlayerCreated(boolean playerCreated) {

    }
}
