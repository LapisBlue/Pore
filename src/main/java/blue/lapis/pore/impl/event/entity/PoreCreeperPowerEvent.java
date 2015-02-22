package blue.lapis.pore.impl.event.entity;

import static com.google.common.base.Preconditions.checkNotNull;

import org.apache.commons.lang.NotImplementedException;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LightningStrike;
import org.bukkit.event.entity.CreeperPowerEvent;
import org.bukkit.event.entity.EntityEvent;

public class PoreCreeperPowerEvent extends CreeperPowerEvent {

    private final EntityEvent handle;

    public PoreCreeperPowerEvent(EntityEvent handle) {
        super(null, null);
        this.handle = checkNotNull(handle, "handle");
    }

    public EntityEvent getHandle() {
        return this.handle;
    }

    @Override
    public Creeper getEntity() {
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
    public LightningStrike getLightning() {
        throw new NotImplementedException();
    }

    @Override
    public PowerCause getCause() {
        throw new NotImplementedException();
    }
}
