package blue.lapis.pore.impl.event.entity;

import static com.google.common.base.Preconditions.checkNotNull;

import org.apache.commons.lang.NotImplementedException;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.event.entity.EntityCombustByBlockEvent;
import org.spongepowered.api.event.entity.EntityIgniteEvent;

public class PoreEntityCombustByBlockEvent extends EntityCombustByBlockEvent {

    private final EntityIgniteEvent handle;

    public PoreEntityCombustByBlockEvent(EntityIgniteEvent handle) {
        super(null, null, -1);
        this.handle = checkNotNull(handle, "handle");
    }

    public EntityIgniteEvent getHandle() {
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
    public Block getCombuster() {
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
    public int getDuration() {
        throw new NotImplementedException();
    }

    @Override
    public void setDuration(int duration) {
        throw new NotImplementedException();
    }
}
