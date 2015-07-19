package blue.lapis.pore.impl.event.entity;

import static com.google.common.base.Preconditions.checkNotNull;

import blue.lapis.pore.event.RegisterEvent;
import blue.lapis.pore.impl.entity.PoreItem;

import org.bukkit.entity.Item;
import org.bukkit.event.entity.ItemMergeEvent;

@RegisterEvent
public class PoreItemMergeEvent extends ItemMergeEvent {

    private final org.spongepowered.api.event.inventory.ItemMergeEvent handle;

    public PoreItemMergeEvent(org.spongepowered.api.event.inventory.ItemMergeEvent handle) {
        super(null, null);
        this.handle = checkNotNull(handle, "handle");
    }

    public org.spongepowered.api.event.inventory.ItemMergeEvent getHandle() {
        return handle;
    }

    @Override
    public Item getEntity() {
        return PoreItem.of(getHandle().getItem());
    }

    @Override
    public Item getTarget() {
        return PoreItem.of(getHandle().getItemToMerge());
    }

    @Override
    public boolean isCancelled() {
        return getHandle().isCancelled();
    }

    @Override
    public void setCancelled(boolean cancelled) {
        getHandle().setCancelled(cancelled);
    }

}
