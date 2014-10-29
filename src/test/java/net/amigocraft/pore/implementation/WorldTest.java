package net.amigocraft.pore.implementation;

import net.amigocraft.pore.implementation.entity.PoreEntity;
import org.junit.Before;
import org.junit.Test;
import org.spongepowered.api.world.World;

import static org.mockito.Mockito.mock;

public class WorldTest {

	@Before
	public void initConverters() {
		PoreEntity.getConverter();
	}

	@Test
	public void testEntitiesByClass() {
		// Prepare a mocked Sponge world
		World sponge = mock(World.class);
		prepareEntities(sponge);

	}

	private void prepareEntities(World world) {

	}
}
