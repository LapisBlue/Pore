package net.amigocraft.pore.implementation.entity;

import org.bukkit.entity.Enderman;
import org.bukkit.material.MaterialData;

/**
 * Created by russjr08 on 9/8/14.
 */
public class PoreEnderman extends PoreMonster implements Enderman {
    @Override
    public MaterialData getCarriedMaterial() {
        return null;
    }

    @Override
    public void setCarriedMaterial(MaterialData material) {

    }
}
