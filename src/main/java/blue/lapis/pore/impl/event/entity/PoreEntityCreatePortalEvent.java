package blue.lapis.pore.impl.event.entity;

import static com.google.common.base.Preconditions.checkNotNull;

import org.apache.commons.lang.NotImplementedException;
import org.bukkit.PortalType;
import org.bukkit.block.BlockState;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.entity.EntityCreatePortalEvent;
import org.bukkit.event.entity.EntityEvent;

import java.util.List;

public class PoreEntityCreatePortalEvent extends EntityCreatePortalEvent {

    private final EntityEvent handle;

    public PoreEntityCreatePortalEvent(EntityEvent handle) {
        super(null, null, null);
        this.handle = checkNotNull(handle, "handle");
    }

    public EntityEvent getHandle() {
        return this.handle;
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
    public List<BlockState> getBlocks() {
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
    public PortalType getPortalType() {
        throw new NotImplementedException();
    }
}