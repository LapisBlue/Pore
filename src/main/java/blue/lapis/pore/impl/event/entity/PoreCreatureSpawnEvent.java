package blue.lapis.pore.impl.event.entity;

import static com.google.common.base.Preconditions.checkNotNull;

import org.apache.commons.lang.NotImplementedException;
import org.bukkit.Location;
import org.bukkit.entity.CreatureType;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.spongepowered.api.event.entity.EntitySpawnEvent;

public class PoreCreatureSpawnEvent extends CreatureSpawnEvent {

    private final EntitySpawnEvent handle;

    public PoreCreatureSpawnEvent(EntitySpawnEvent handle) {
        super(null, null);
        this.handle = checkNotNull(handle, "handle");
    }

    public EntitySpawnEvent getHandle() {
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
    public boolean isCancelled() {
        throw new NotImplementedException();
    }

    public void setCancelled(boolean cancel) {
        throw new NotImplementedException();
    }

    @Override
    public Location getLocation() {
        throw new NotImplementedException();
    }

    @Override
    public CreatureType getCreatureType() {
        throw new NotImplementedException();
    }

    @Override
    public SpawnReason getSpawnReason() {
        throw new NotImplementedException();
    }
}
