package net.amigocraft.pore.implementation;

import com.google.common.collect.ImmutableList;
import net.amigocraft.pore.implementation.entity.PoreEntity;
import org.bukkit.entity.*;
import org.junit.Before;
import org.junit.Test;
import org.spongepowered.api.world.World;

import java.util.Collection;
import java.util.List;

import static com.google.common.base.Predicates.instanceOf;
import static com.google.common.collect.Collections2.filter;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class WorldEntitiesTest {
	private PoreWorld world;

	@Before
	public void initTest() {
		// Initialize converter
		PoreEntity.getConverter();

		// Initialize world
		world = PoreWorld.of(mock(World.class));
		when(world.getHandle().getEntities()).thenReturn(ImmutableList.of(
				mock(org.spongepowered.api.entity.player.Player.class),
				mock(org.spongepowered.api.entity.Entity.class),
				mock(org.spongepowered.api.entity.living.Human.class),
				mock(org.spongepowered.api.entity.player.Player.class),
				mock(org.spongepowered.api.entity.living.Living.class),
				mock(org.spongepowered.api.entity.player.Player.class),
				mock(org.spongepowered.api.entity.player.Player.class),
				mock(org.spongepowered.api.entity.living.Living.class),
				mock(org.spongepowered.api.entity.living.Living.class),
				mock(org.spongepowered.api.entity.Entity.class),
				mock(org.spongepowered.api.entity.living.Human.class),
				mock(org.spongepowered.api.entity.player.Player.class),
				mock(org.spongepowered.api.entity.living.animal.Cow.class),
				mock(org.spongepowered.api.entity.living.animal.Pig.class)
		));
	}

	@Test
	public void checkEntities() {
		List<Entity> entities = world.getEntities();

		// All of the entities should be an instance of Entity
		assertEquals(14, filter(entities, instanceOf(Entity.class)).size());
		assertEquals(12, filter(entities, instanceOf(LivingEntity.class)).size());
		assertEquals(7, filter(entities, instanceOf(HumanEntity.class)).size());
		assertEquals(5, filter(entities, instanceOf(Player.class)).size());
		assertEquals(2, filter(entities, instanceOf(Animals.class)).size());
	}

	@Test
	public void checkEntitiesByClassCounts() {
		// This is the same as above actually
		assertEquals(14, world.getEntitiesByClass(Entity.class).size());
		assertEquals(12, world.getEntitiesByClass(LivingEntity.class).size());
		Collection list = world.getEntitiesByClass(Entity.class);
		assertEquals(7, world.getEntitiesByClass(HumanEntity.class).size());
		assertEquals(5, world.getEntitiesByClass(Player.class).size());
		assertEquals(2, world.getEntitiesByClass(Animals.class).size());
	}

	@Test
	public void checkEntitiesByClassesCounts() {
		// This should still return all entities
		assertEquals(14, world.getEntitiesByClasses(Entity.class, LivingEntity.class).size());
		// TODO: Add more tests, not possible right now
	}

	@Test
	public void checkEntitiesByClassType() {
		// Test result types
		checkEntityTypes(world.getEntitiesByClass(Entity.class), Entity.class);
		checkEntityTypes(world.getEntitiesByClass(LivingEntity.class), LivingEntity.class);
		checkEntityTypes(world.getEntitiesByClass(HumanEntity.class), HumanEntity.class);
		checkEntityTypes(world.getEntitiesByClass(Player.class), Player.class);
		checkEntityTypes(world.getEntitiesByClass(Animals.class), Animals.class);
	}

	@Test
	public void checkEntitiesByClassesType() {
		// This should still return all entities
		checkEntityTypes(world.getEntitiesByClasses(Entity.class, LivingEntity.class), Entity.class);
		// TODO: Add more tests, not possible right now
	}

	private static <T> void checkEntityTypes(Collection<T> entities, Class<T> type) {
		for (T entity : entities) {
			assertTrue(type.isInstance(entity));
		}
	}
}
