package net.amigocraft.pore.implementation.block;

import org.apache.commons.lang.NotImplementedException;
import org.bukkit.block.CreatureSpawner;
import org.bukkit.entity.CreatureType;
import org.bukkit.entity.EntityType;
import org.spongepowered.api.block.BlockLoc;

//TODO: skeleton implementation

public class PoreCreatureSpawner extends PoreBlockState implements CreatureSpawner {
	public PoreCreatureSpawner(BlockLoc spongeBlock) {
		super(spongeBlock);
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
