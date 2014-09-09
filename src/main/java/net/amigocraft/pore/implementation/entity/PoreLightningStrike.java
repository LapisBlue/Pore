package net.amigocraft.pore.implementation.entity;

import org.bukkit.entity.LightningStrike;

public class PoreLightningStrike extends PoreEntity implements LightningStrike {
    // TODO: Bridge
    @Override
    public boolean isEffect() {
        return false;
    }
}
