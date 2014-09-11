package net.amigocraft.pore.implementation.entity;

import org.bukkit.entity.Slime;

public class PoreSlime extends PoreLivingEntity implements Slime {

    // TODO: Bridge

	public PoreSlime(org.spongepowered.api.entity.LivingEntity handle) { //TODO: accept most specfific type
		super(handle);
	}

    @Override
    public int getSize() {
        return 0;
    }

    @Override
    public void setSize(int sz) {

    }
}
