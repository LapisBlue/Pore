package net.amigocraft.pore.implementation.entity;

import com.google.common.collect.ImmutableMap;
import net.amigocraft.pore.util.converter.TypeConverter;
import org.bukkit.entity.EntityType;
import org.spongepowered.api.entity.living.golem.IronGolem;

public class PoreIronGolem extends PoreGolem implements org.bukkit.entity.IronGolem {

	private static TypeConverter<IronGolem, PoreIronGolem> converter;

	@SuppressWarnings("unchecked")
	static TypeConverter<IronGolem, PoreIronGolem> getIronGolemConverter() {
		if (converter == null) {
			converter = new TypeConverter<IronGolem, PoreIronGolem>(
					(ImmutableMap)ImmutableMap.builder() // generified for simplicity and readability
							.build()
			){
				@Override
				protected PoreIronGolem convert(IronGolem handle) {
					return new PoreIronGolem(handle);
				}
			};
		}
		return converter;
	}

	protected PoreIronGolem(IronGolem handle) {
		super(handle);
	}

	@Override
	public IronGolem getHandle() {
		return (IronGolem)super.getHandle();
	}

	/**
	 * Returns a Pore wrapper for the given handle.
	 * If one exists, it will be retrieved; otherwise, a new wrapper instance will be created.
	 * @param handle The Sponge object to wrap.
	 * @return A Pore wrapper for the given Sponge object.
	 */
	public static PoreIronGolem of(IronGolem handle) {
		return converter.apply(handle);
	}

	@Override
	public EntityType getType(){
		return EntityType.IRON_GOLEM;
	}

	@Override
	public boolean isPlayerCreated() {
		return getHandle().isPlayerCreated();
	}

	@Override
	public void setPlayerCreated(boolean playerCreated) {
		getHandle().setPlayerCreated(playerCreated);
	}
}
