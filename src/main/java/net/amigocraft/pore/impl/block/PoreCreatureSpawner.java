package net.amigocraft.pore.impl.block;

import net.amigocraft.pore.util.converter.TypeConverter;
import org.apache.commons.lang.NotImplementedException;
import org.bukkit.block.CreatureSpawner;
import org.bukkit.entity.CreatureType;
import org.bukkit.entity.EntityType;
import org.spongepowered.api.block.BlockState;

public class PoreCreatureSpawner extends PoreBlockState implements CreatureSpawner {

	private static TypeConverter<BlockState, PoreCreatureSpawner> converter;

	static TypeConverter<org.spongepowered.api.block.BlockState, PoreCreatureSpawner> getCreatureSpawnerConverter() {
		if (converter == null) {
			converter = new TypeConverter<org.spongepowered.api.block.BlockState, PoreCreatureSpawner>() {
				@Override
				protected PoreCreatureSpawner convert(org.spongepowered.api.block.BlockState handle) {
					return new PoreCreatureSpawner(handle);
				}
			};
		}

		return converter;
	}

	/**
	 * Returns a Pore wrapper for the given handle.
	 * If one exists, it will be retrieved; otherwise, a new wrapper instance will be created.
	 * @param handle The Sponge object to wrap.
	 * @return A Pore wrapper for the given Sponge object.
	 */
	public static PoreCreatureSpawner of(org.spongepowered.api.block.BlockState handle) {
		return converter.apply(handle);
	}

	protected PoreCreatureSpawner(org.spongepowered.api.block.BlockState handle) {
		super(handle);
	}

	@Override
	public CreatureType getCreatureType() {
		throw new NotImplementedException();
	}

	@Override
	public EntityType getSpawnedType() {
		throw new NotImplementedException();
	}

	@Override
	public void setSpawnedType(EntityType creatureType) {
		throw new NotImplementedException();
	}

	@Override
	public void setCreatureType(CreatureType creatureType) {
		throw new NotImplementedException();
	}

	@Override
	public String getCreatureTypeId() {
		throw new NotImplementedException();
	}

	@Override
	public void setCreatureTypeByName(String creatureType) {
		throw new NotImplementedException();
	}

	@Override
	public String getCreatureTypeName() {
		throw new NotImplementedException();
	}

	@Override
	public void setCreatureTypeId(String creatureType) {
		throw new NotImplementedException();
	}

	@Override
	public int getDelay() {
		throw new NotImplementedException();
	}

	@Override
	public void setDelay(int delay) {
		throw new NotImplementedException();
	}
}
