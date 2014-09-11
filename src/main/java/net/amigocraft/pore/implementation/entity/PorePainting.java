package net.amigocraft.pore.implementation.entity;

import org.bukkit.Art;
import org.bukkit.entity.Painting;

public class PorePainting extends PoreHanging implements Painting {

    // TODO: Bridge

	public PorePainting(org.spongepowered.api.entity.Entity handle) { //TODO: accept most specfific type
		super(handle);
	}

    @Override
    public Art getArt() {
        return null;
    }

    @Override
    public boolean setArt(Art art) {
        return false;
    }

    @Override
    public boolean setArt(Art art, boolean force) {
        return false;
    }
}
