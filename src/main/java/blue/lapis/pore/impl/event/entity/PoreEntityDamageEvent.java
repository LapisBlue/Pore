package blue.lapis.pore.impl.event.entity;

import static com.google.common.base.Preconditions.checkNotNull;

import org.apache.commons.lang.NotImplementedException;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.event.entity.EntityDamageEvent;
import org.spongepowered.api.event.entity.EntityChangeHealthEvent;

public class PoreEntityDamageEvent extends EntityDamageEvent {

    private final EntityChangeHealthEvent handle;

    public PoreEntityDamageEvent(EntityChangeHealthEvent handle) {
        super(null, null, null, null);
        this.handle = checkNotNull(handle, "handle");
    }

    public EntityChangeHealthEvent getHandle() {
        return this.handle;
    }

    @Override
    public Entity getEntity() {
        throw new NotImplementedException();
    }

    @Override
    public EntityType getEntityType() {
        throw new NotImplementedException();
    }

    @Override
    public boolean isCancelled() {
        throw new NotImplementedException();
    }

    @Override
    public void setCancelled(boolean cancel) {
        throw new NotImplementedException();
    }

    @Override
    public double getOriginalDamage(DamageModifier type) throws IllegalArgumentException {
        throw new NotImplementedException();
    }

    @Override
    public void setDamage(DamageModifier type, double damage) throws IllegalArgumentException, UnsupportedOperationException {
        throw new NotImplementedException();
    }

    @Override
    public double getDamage(DamageModifier type) throws IllegalArgumentException {
        throw new NotImplementedException();
    }

    @Override
    public boolean isApplicable(DamageModifier type) throws IllegalArgumentException {
        throw new NotImplementedException();
    }

    @Override
    public double getDamage() {
        throw new NotImplementedException();
    }

    @Override
    public double getFinalDamage() {
        throw new NotImplementedException();
    }

    @Override
    public int _INVALID_getDamage() {
        throw new NotImplementedException();
    }

    @Override
    public void setDamage(double damage) {
        throw new NotImplementedException();
    }

    @Override
    public void _INVALID_setDamage(int damage) {
        throw new NotImplementedException();
    }

    @Override
    public DamageCause getCause() {
        throw new NotImplementedException();
    }
}
