package net.amigocraft.pore.implementation.entity;

import org.bukkit.Art;
import org.bukkit.entity.Painting;

public class PorePainting extends PoreHanging implements Painting {
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
