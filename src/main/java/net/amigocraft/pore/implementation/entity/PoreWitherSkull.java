package net.amigocraft.pore.implementation.entity;

import org.bukkit.entity.WitherSkull;

public class PoreWitherSkull extends PoreFireball implements WitherSkull {
    // TODO: Bridge
    @Override
    public void setCharged(boolean charged) {

    }

    @Override
    public boolean isCharged() {
        return false;
    }
}
