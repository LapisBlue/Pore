package net.amigocraft.pore.util;

import net.amigocraft.pore.implementation.entity.PoreEntity;
import net.amigocraft.pore.implementation.entity.PoreLivingEntity;
import net.amigocraft.pore.implementation.entity.PorePlayer;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.entity.LivingEntity;
import org.spongepowered.api.entity.Player;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

public class ConverterTest {

	@Before
	public void initCaches() {
		// Initialize the caches
		PoreEntity.getConverter();
	}

	@Test
	public void resolveEntity() {
		Entity generic = mock(Entity.class);
		assertEquals(PoreEntity.of(generic).getClass(), PoreEntity.class);
	}

	@Test
	public void resolveLivingEntity() {
		Entity living = mock(LivingEntity.class);
		assertEquals(PoreEntity.of(living).getClass(), PoreLivingEntity.class);
	}

	@Test
	public void resolvePlayer() {
		Entity player = mock(Player.class);
		assertEquals(PoreEntity.of(player).getClass(), PorePlayer.class);
	}

	@Test
	public void resolveLivingEntityDirectly() {
		LivingEntity living = mock(LivingEntity.class);
		assertEquals(PoreLivingEntity.of(living).getClass(), PoreLivingEntity.class);
	}

	@Test
	public void resolvePlayerDirectly() {
		Player player = mock(Player.class);
		assertEquals(PorePlayer.of(player).getClass(), PorePlayer.class);
	}
}
