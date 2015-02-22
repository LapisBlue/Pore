package blue.lapis.pore.impl.event.entity;

import static com.google.common.base.Preconditions.checkNotNull;

import org.apache.commons.lang.NotImplementedException;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.event.entity.EntityChangeBlockEvent;

public class PoreEntityChangeBlockEvent extends EntityChangeBlockEvent {

    private final org.spongepowered.api.event.entity.EntityChangeBlockEvent handle;

    public PoreEntityChangeBlockEvent(org.spongepowered.api.event.entity.EntityChangeBlockEvent handle) {
        super(null, null, null);
        this.handle = checkNotNull(handle, "handle");
    }

    public org.spongepowered.api.event.entity.EntityChangeBlockEvent getHandle() {
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
