package net.amigocraft.pore.implementation.inventory.meta;

import org.bukkit.inventory.meta.SkullMeta;

// TODO: bridge

public class PoreSkullMeta extends PoreItemMeta implements SkullMeta {

    @Override
    public String getOwner() {
        return null;
    }

    @Override
    public boolean hasOwner() {
        return false;
    }

    @Override
    public boolean setOwner(String owner) {
        return false;
    }

    @Override
    public SkullMeta clone() {
        return null;
    }

}