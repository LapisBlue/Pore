package net.amigocraft.pore.implementation.entity;

import org.bukkit.entity.Creature;
import org.bukkit.entity.LivingEntity;

/**
 * Created by russjr08 on 9/8/14.
 */
public class PoreCreature extends PoreLivingEntity implements Creature {

    // Implemented from Creature

    @Override
    public void setTarget(LivingEntity target) {

    }

    @Override
    public LivingEntity getTarget() {
        return null;
    }
}
