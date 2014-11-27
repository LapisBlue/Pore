package net.amigocraft.pore.implementation.entity.minecart;

import net.amigocraft.pore.util.converter.TypeConverter;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.minecart.SpawnerMinecart;
import org.spongepowered.api.entity.vehicle.minecart.MinecartMobSpawner;

public class PoreSpawnerMinecart extends PoreMinecart implements SpawnerMinecart {

	private static TypeConverter<MinecartMobSpawner, PoreSpawnerMinecart> converter;

	@SuppressWarnings("unchecked")
	public static TypeConverter<MinecartMobSpawner, PoreSpawnerMinecart> getSpawnerMinecartConverter() {
		if (converter == null) {
			converter = new TypeConverter<MinecartMobSpawner, PoreSpawnerMinecart>(){
				@Override
				protected PoreSpawnerMinecart convert(MinecartMobSpawner handle) {
					return new PoreSpawnerMinecart(handle);
				}
			};
		}
		return converter;
	}

	protected PoreSpawnerMinecart(MinecartMobSpawner handle) {
		super(handle);
	}

	@Override
	public MinecartMobSpawner getHandle() {
		return (MinecartMobSpawner)super.getHandle();
	}

	/**
	 * Returns a Pore wrapper for the given handle.
	 * If one exists, it will be retrieved; otherwise, a new wrapper instance will be created.
	 * @param handle The Sponge object to wrap.
	 * @return A Pore wrapper for the given Sponge object.
	 */
	public static PoreSpawnerMinecart of(MinecartMobSpawner handle) {
		return converter.apply(handle);
	}

	@Override
	public EntityType getType(){
		return EntityType.MINECART_MOB_SPAWNER;
	}

}
