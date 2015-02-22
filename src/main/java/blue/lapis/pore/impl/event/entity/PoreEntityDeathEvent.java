package blue.lapis.pore.impl.event.entity;

import static com.google.common.base.Preconditions.checkNotNull;

import org.apache.commons.lang.NotImplementedException;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public class PoreEntityDeathEvent extends EntityDeathEvent {

    private final EntityDeathEvent handle;

    public PoreEntityDeathEvent(EntityDeathEvent handle) {
        super(null, null);
        this.handle = checkNotNull(handle, "handle");
    }

    public EntityDeathEvent getHandle() {
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
    public int getDroppedExp() {
        throw new NotImplementedException();
    }

    @Override
    public void setDroppedExp(int exp) {
        throw new NotImplementedException();
    }

    @Override
    public List<ItemStack> getDrops() {
        throw new NotImplementedException();
    }
}
