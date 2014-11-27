package net.amigocraft.pore.implementation.entity;

import com.google.common.collect.ImmutableMap;
import net.amigocraft.pore.util.converter.TypeConverter;
import org.apache.commons.lang.NotImplementedException;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Fireball;
import org.bukkit.util.Vector;
import org.spongepowered.api.entity.projectile.fireball.LargeFireball;
import org.spongepowered.api.entity.projectile.fireball.SmallFireball;
import org.spongepowered.api.entity.projectile.fireball.WitherSkull;

public class PoreFireball extends PoreProjectile implements Fireball {

	private static TypeConverter<org.spongepowered.api.entity.projectile.fireball.Fireball, PoreFireball> converter;

	@SuppressWarnings("unchecked")
	static TypeConverter<org.spongepowered.api.entity.projectile.fireball.Fireball, PoreFireball> getFireballConverter(){
		if (converter == null) {
			converter = new TypeConverter<org.spongepowered.api.entity.projectile.fireball.Fireball, PoreFireball>(
					(ImmutableMap)ImmutableMap.builder()
					.put(LargeFireball.class, PoreLargeFireball.getLargeFireballConverter())
					.put(SmallFireball.class, PoreSmallFireball.getSmallFireballConverter())
					.put(WitherSkull.class, PoreWitherSkull.getWitherSkullConverter())
					.build()
			){
				@Override
				protected PoreFireball convert(org.spongepowered.api.entity.projectile.fireball.Fireball handle) {
					return new PoreFireball(handle);
				}
			};
		}
		return converter;
	}

	protected PoreFireball(org.spongepowered.api.entity.projectile.fireball.Fireball handle) {
		super(handle);
	}

	@Override
	public org.spongepowered.api.entity.projectile.fireball.Fireball getHandle() {
		return (org.spongepowered.api.entity.projectile.fireball.Fireball)super.getHandle();
	}

	/**
	 * Returns a Pore wrapper for the given handle.
	 * If one exists, it will be retrieved; otherwise, a new wrapper instance will be created.
	 * @param handle The Sponge object to wrap.
	 * @return A Pore wrapper for the given Sponge object.
	 */
	public static PoreFireball of(org.spongepowered.api.entity.projectile.fireball.Fireball handle) {
		return converter.apply(handle);
	}

	//TODO: bridge

	@Override
	public EntityType getType(){
		return EntityType.FIREBALL;
	}

	@Override
	public void setDirection(Vector direction) {
		throw new NotImplementedException(); //TODO
	}

	@Override
	public Vector getDirection() {
		throw new NotImplementedException(); //TODO
	}

	@Override
	public void setYield(float yield) {
		throw new NotImplementedException();
	}

	@Override
	public float getYield() {
		throw new NotImplementedException();
	}

	@Override
	public void setIsIncendiary(boolean isIncendiary) {
		throw new NotImplementedException();
	}

	@Override
	public boolean isIncendiary() {
		throw new NotImplementedException();
	}
}
