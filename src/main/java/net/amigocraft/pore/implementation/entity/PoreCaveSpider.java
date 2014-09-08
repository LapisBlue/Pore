package net.amigocraft.pore.implementation.entity;

import org.bukkit.entity.CaveSpider;
import org.bukkit.entity.LivingEntity;

/**
 * Created by russjr08 on 9/8/14.
 */
public class PoreCaveSpider extends PoreLivingEntity implements CaveSpider {

    // TODO: Bridge

    // Overrided from Creature


    @Override
    public void setTarget(LivingEntity target) {

    }

    @Override
    public LivingEntity getTarget() {
        return null;
    }

    // Overrided from LivingEntity


}
