package net.amigocraft.pore.implementation.block;

import org.bukkit.block.CreatureSpawner;
import org.bukkit.entity.CreatureType;
import org.bukkit.entity.EntityType;

//TODO: skeleton implementation

public class PoreCreatureSpawner extends PoreBlockState implements CreatureSpawner {
	public PoreCreatureSpawner(org.spongepowered.api.block.Block spongeBlock) {
		super(spongeBlock);
	}

	@Override
	public CreatureType getCreatureType() {
		return null;
	}

	@Override
	public EntityType getSpawnedType() {
		return null;
	}

	@Override
	public void setSpawnedType(EntityType creatureType) {

	}

	@Override
	public void setCreatureType(CreatureType creatureType) {

	}

	@Override
	public String getCreatureTypeId() {
		return null;
	}

	@Override
	public void setCreatureTypeByName(String creatureType) {

	}

	@Override
	public String getCreatureTypeName() {
		return null;
	}

	@Override
	public void setCreatureTypeId(String creatureType) {

	}

	@Override
	public int getDelay() {
		return 0;
	}

	@Override
	public void setDelay(int delay) {

	}
}
