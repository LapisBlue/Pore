package net.amigocraft.pore.util.converter;

import org.spongepowered.api.item.ItemType;
import org.spongepowered.api.item.ItemTypes;
import org.spongepowered.api.item.inventory.ItemStackBuilder;

public class ItemStackConverter {

	public static org.bukkit.inventory.ItemStack of(org.spongepowered.api.item.inventory.ItemStack stack){
		return new org.bukkit.inventory.ItemStack(
				MaterialConverter.toBukkitMaterial(stack.getItem()),
				stack.getQuantity(),
				stack.getDamage()
		);
	}

	public static org.spongepowered.api.item.inventory.ItemStack of(org.bukkit.inventory.ItemStack stack){
		ItemType type = MaterialConverter.toItemType(stack.getType());
		if (type == null)
			throw new UnsupportedOperationException();
		// IntelliJ doesn't recognize the above check and thinks withItemType() may throw an NPE
		//noinspection ConstantConditions
		return ItemTypes.getItemBuilder()
				.withItemType(type)
				.withQuantity(stack.getAmount())
				.withDamage(stack.getDurability())
				.withMaxQuantity(stack.getType().getMaxStackSize())
				.build();
	}

}
