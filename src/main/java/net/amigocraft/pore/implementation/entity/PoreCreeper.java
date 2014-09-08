package net.amigocraft.pore.implementation.entity;

import org.bukkit.entity.Creeper;

/**
 * Created by russjr08 on 9/8/14.
 */
public class PoreCreeper extends PoreMonster implements Creeper {
    @Override
    public boolean isPowered() {
        return false;
    }

    @Override
    public void setPowered(boolean value) {

    }
}
