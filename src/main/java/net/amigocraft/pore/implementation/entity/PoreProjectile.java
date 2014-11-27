package net.amigocraft.pore.implementation.entity;

import com.google.common.collect.ImmutableMap;
import net.amigocraft.pore.implementation.projectiles.PoreBlockProjectileSource;
import net.amigocraft.pore.util.converter.TypeConverter;
import org.apache.commons.lang.NotImplementedException;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.LivingEntity;
import org.bukkit.projectiles.ProjectileSource;
import org.spongepowered.api.entity.living.Living;
import org.spongepowered.api.entity.projectile.*;
import org.spongepowered.api.entity.projectile.source.BlockProjectileSource;

public class PoreProjectile extends PoreEntity implements org.bukkit.entity.Projectile {

	private static TypeConverter<Projectile, PoreProjectile> converter;

	@SuppressWarnings("unchecked")
	static TypeConverter<Projectile, PoreProjectile> getProjectileConverter() {
		if (converter == null) {
			converter = new TypeConverter<Projectile, PoreProjectile>(
					(ImmutableMap)ImmutableMap.builder()
							.put(Arrow.class, PoreArrow.getArrowConverter())
							.put(Egg.class, PoreEgg.getEggConverter())
							.put(EnderPearl.class, PoreEnderPearl.getEnderPearlConverter())
							.put(Fireball.class, PoreFireball.getFireballConverter())
							.put(FishHook.class, PoreFish.getFishConverter())
							.put(Snowball.class, PoreSnowball.getSnowballConverter())
							.put(ThrownExpBottle.class, PoreThrownExpBottle.getThrownExpBottleConverter())
							.put(ThrownPotion.class, PoreThrownPotion.getThrownPotionConverter())
							.build()
			){
				@Override
				protected PoreProjectile convert(Projectile handle) {
					return new PoreProjectile(handle);
				}
			};
		}

		return converter;
	}

	protected PoreProjectile(Projectile handle) {
		super(handle);
	}

	@Override
	public Projectile getHandle() {
		return (Projectile)super.getHandle();
	}

	/**
	 * Returns a Pore wrapper for the given handle.
	 * If one exists, it will be retrieved; otherwise, a new wrapper instance will be created.
	 * @param handle The Sponge object to wrap.
	 * @return A Pore wrapper for the given Sponge object.
	 */
	public static PoreProjectile of(Projectile handle) {
		return converter.apply(handle);
	}

	@Override
	public LivingEntity _INVALID_getShooter() {
		ProjectileSource shooter = getShooter();
		if (shooter instanceof LivingEntity) {
			return PoreLivingEntity.of((Living)shooter);
		}
		throw new UnsupportedOperationException();
	}

	@Override
	public ProjectileSource getShooter() {
		org.spongepowered.api.entity.projectile.source.ProjectileSource source = getHandle().getShooter();
		if (source instanceof BlockProjectileSource){
			return PoreBlockProjectileSource.of((BlockProjectileSource)source);
		}
		else if (source instanceof Living){
			return PoreLivingEntity.of((Living)source);
		}
		throw new UnsupportedOperationException();
	}

	@Override
	public void _INVALID_setShooter(LivingEntity shooter) {
		Living spongeShooter = ((PoreLivingEntity)shooter).getHandle();
		if (spongeShooter instanceof org.spongepowered.api.entity.projectile.source.ProjectileSource) {
			getHandle().setShooter((org.spongepowered.api.entity.projectile.source.ProjectileSource)spongeShooter);
		}
		else {
			throw new UnsupportedOperationException();
		}
	}

	@Override
	public void setShooter(ProjectileSource source) {
		if (source instanceof org.bukkit.projectiles.BlockProjectileSource){
			getHandle().setShooter(((PoreBlockProjectileSource)source).getHandle());
		}
		else if (source instanceof LivingEntity){
			Living spongeSource = ((PoreLivingEntity)source).getHandle();
			if (spongeSource instanceof org.spongepowered.api.entity.projectile.source.ProjectileSource){
				getHandle().setShooter((org.spongepowered.api.entity.projectile.source.ProjectileSource)spongeSource);
			}
		}
		else {
			throw new UnsupportedOperationException();
		}
	}

	@Override
	public boolean doesBounce() {
		throw new NotImplementedException(); //TODO
	}

	@Override
	public void setBounce(boolean doesBounce) {
		throw new NotImplementedException(); //TODO
	}
}
