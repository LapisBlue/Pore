package net.amigocraft.pore.implementation.entity;

import net.amigocraft.pore.util.converter.MaterialConverter;
import net.amigocraft.pore.util.converter.TypeConverter;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.FallingSand;
import org.spongepowered.api.entity.FallingBlock;

public class PoreFallingSand extends PoreEntity implements FallingSand {

	private static TypeConverter<FallingBlock, PoreFallingSand> converter;

	@SuppressWarnings("unchecked")
	static TypeConverter<FallingBlock, PoreFallingSand> getFallingSandConverter() {
		if (converter == null) {
			converter = new TypeConverter<FallingBlock, PoreFallingSand>(){
				@Override
				protected PoreFallingSand convert(FallingBlock handle) {
					return new PoreFallingSand(handle);
				}
			};
		}
		return converter;
	}

	protected PoreFallingSand(FallingBlock handle) {
		super(handle);
	}

	@Override
	public FallingBlock getHandle() {
		return (FallingBlock)super.getHandle();
	}

	/**
	 * Returns a Pore wrapper for the given handle.
	 * If one exists, it will be retrieved; otherwise, a new wrapper instance will be created.
	 * @param handle The Sponge object to wrap.
	 * @return A Pore wrapper for the given Sponge object.
	 */
	public static PoreFallingSand of(FallingBlock handle) {
		return converter.apply(handle);
	}

	//TODO: bridge

	@Override
	public EntityType getType(){
		return EntityType.FALLING_BLOCK;
	}

	@Override
	public Material getMaterial() {
		return MaterialConverter.toBukkitMaterial(getHandle().getBlockState().getType());
	}

	@Override
	public int getBlockId() {
		return MaterialConverter.toBukkitMaterial(getHandle().getBlockState().getType()).getId();
	}

	@Override
	public byte getBlockData() {
		return getHandle().getBlockState().getDataValue();
	}

	@Override
	public boolean getDropItem() {
		return getHandle().getCanDropAsItem();
	}

	@Override
	public void setDropItem(boolean drop) {
		getHandle().setCanDropAsItem(drop);
	}
}
