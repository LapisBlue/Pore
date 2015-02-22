package blue.lapis.pore.impl.event.entity;

import static com.google.common.base.Preconditions.checkNotNull;

import org.apache.commons.lang.NotImplementedException;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.spongepowered.api.event.entity.EntityExplosionEvent;

import java.util.List;

public class PoreEntityExplodeEvent extends EntityExplodeEvent {

    private final EntityExplosionEvent handle;

    public PoreEntityExplodeEvent(EntityExplosionEvent handle) {
        super(null, null, null, -1);
        this.handle = checkNotNull(handle, "handle");
    }

    public EntityExplosionEvent getHandle() {
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
    public boolean isCancelled() {
        throw new NotImplementedException();
    }

    @Override
    public void setCancelled(boolean cancel) {
        throw new NotImplementedException();
    }

    @Override
    public List<Block> blockList() {
        throw new NotImplementedException();
    }

    @Override
    public Location getLocation() {
        throw new NotImplementedException();
    }

    @Override
    public float getYield() {
        throw new NotImplementedException();
    }

    @Override
    public void setYield(float yield) {
        throw new NotImplementedException();
    }
}
