package net.amigocraft.pore.implementation.projectiles;

import net.amigocraft.pore.implementation.entity.PoreProjectile;
import net.amigocraft.pore.util.PoreWrapper;
import net.amigocraft.pore.util.converter.TypeConverter;
import org.apache.commons.lang.NotImplementedException;
import org.bukkit.block.Block;
import org.bukkit.entity.Projectile;
import org.bukkit.util.Vector;
import org.spongepowered.api.entity.projectile.source.BlockProjectileSource;
import org.spongepowered.api.entity.projectile.source.ProjectileSource;

// TODO: Bridge

// TODO: Bridge

public class PoreBlockProjectileSource
		extends PoreWrapper<BlockProjectileSource> implements org.bukkit.projectiles.BlockProjectileSource {

	private static TypeConverter<BlockProjectileSource, PoreBlockProjectileSource> converter;

	@SuppressWarnings("unchecked")
	static TypeConverter<BlockProjectileSource, PoreBlockProjectileSource> getBlockProjectileSourceConverter() {
		if (converter == null) {
			converter = new TypeConverter<BlockProjectileSource, PoreBlockProjectileSource>(){
				@Override
				protected PoreBlockProjectileSource convert(BlockProjectileSource handle) {
					return new PoreBlockProjectileSource(handle);
				}
			};
		}

		return converter;
	}

	//TODO: bridge

	protected PoreBlockProjectileSource(BlockProjectileSource handle) {
		super(handle);
	}

	@Override
	public BlockProjectileSource getHandle() {
		return (BlockProjectileSource)super.getHandle();
	}

	/**
	 * Returns a Pore wrapper for the given handle.
	 * If one exists, it will be retrieved; otherwise, a new wrapper instance will be created.
	 * @param handle The Sponge object to wrap.
	 * @return A Pore wrapper for the given Sponge object.
	 */
	public static PoreBlockProjectileSource of(BlockProjectileSource handle) {
		return converter.apply(handle);
	}

	@Override
	public <T extends Projectile> T launchProjectile(Class<? extends T> projectile) {
		throw new NotImplementedException();
	}

	@Override
	public <T extends Projectile> T launchProjectile(Class<? extends T> projectile, Vector velocity) {
		throw new NotImplementedException();
	}

	@Override
	public Block getBlock() {
		throw new NotImplementedException();
	}
}
