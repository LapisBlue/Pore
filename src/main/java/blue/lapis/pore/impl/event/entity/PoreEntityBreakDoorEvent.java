package blue.lapis.pore.impl.event.entity;

import static com.google.common.base.Preconditions.checkNotNull;

import org.apache.commons.lang.NotImplementedException;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.entity.EntityBreakDoorEvent;
import org.spongepowered.api.event.entity.EntityEvent;

public class PoreEntityBreakDoorEvent extends EntityBreakDoorEvent {

    private final EntityEvent handle;

    public PoreEntityBreakDoorEvent(EntityEvent handle) {
        super(null, null);
        this.handle = checkNotNull(handle, "handle");
    }

    public EntityEvent getHandle() {
        return handle;
    }

    @Override
    public LivingEntity getEntity() {
        throw new NotImplementedException();
    }

    @Override
    public EntityType getEntityType() {
        throw new NotImplementedException();
    }

    @Override
    public Block getBlock() {
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
    public Material getTo() {
        throw new NotImplementedException();
    }

    @Override
    public byte getData() {
        throw new NotImplementedException();
    }
}
