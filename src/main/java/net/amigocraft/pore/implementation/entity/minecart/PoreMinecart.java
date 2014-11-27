package net.amigocraft.pore.implementation.entity.minecart;

import com.google.common.collect.ImmutableMap;
import net.amigocraft.pore.implementation.entity.PoreVehicle;
import net.amigocraft.pore.util.converter.TypeConverter;
import org.apache.commons.lang.NotImplementedException;
import org.bukkit.entity.EntityType;
import org.bukkit.util.Vector;
import org.spongepowered.api.entity.vehicle.minecart.*;

public class PoreMinecart extends PoreVehicle implements org.bukkit.entity.Minecart {

	private static TypeConverter<Minecart, PoreMinecart> converter;

	@SuppressWarnings("unchecked")
	public static TypeConverter<Minecart, PoreMinecart> getMinecartConverter() {
		if (converter == null) {
			converter = new TypeConverter<Minecart, PoreMinecart>(
					(ImmutableMap)ImmutableMap.builder()
							.put(MinecartCommandBlock.class, PoreCommandMinecart.getCommandMinecartConverter())
							.put(MinecartTNT.class, PoreExplosiveMinecart.getExplosiveMinecartConverter())
							.put(MinecartHopper.class, PoreHopperMinecart.getHopperMinecartConverter())
							.put(MinecartFurnace.class, PorePoweredMinecart.getPoweredMinecartConverter())
							.put(MinecartRideable.class, PoreRideableMinecart.getRideableMinecartConverter())
							.put(MinecartMobSpawner.class, PoreRideableMinecart.getRideableMinecartConverter())
							.put(MinecartChest.class, PoreStorageMinecart.getStorageMinecartConverter())
							.build()
			){
				@Override
				protected PoreMinecart convert(Minecart handle) {
					return new PoreMinecart(handle);
				}
			};
		}
		return converter;
	}

	protected PoreMinecart(Minecart handle) {
		super(handle);
	}

	@Override
	public Minecart getHandle() {
		return (Minecart)super.getHandle();
	}

	/**
	 * Returns a Pore wrapper for the given handle.
	 * If one exists, it will be retrieved; otherwise, a new wrapper instance will be created.
	 * @param handle The Sponge object to wrap.
	 * @return A Pore wrapper for the given Sponge object.
	 */
	public static PoreMinecart of(Minecart handle) {
		return converter.apply(handle);
	}

	//TODO: bridge

	@Override
	public EntityType getType(){
		return EntityType.MINECART;
	}

	@Override
	public void _INVALID_setDamage(int damage) {
		throw new NotImplementedException();
	}

	@Override
	public void setDamage(double damage) {
		throw new NotImplementedException();
	}

	@Override
	public int _INVALID_getDamage() {
		throw new NotImplementedException();
	}

	@Override
	public double getDamage() {
		throw new NotImplementedException();
	}

	@Override
	public double getMaxSpeed() {
		throw new NotImplementedException();
	}

	@Override
	public void setMaxSpeed(double speed) {
		throw new NotImplementedException();
	}

	@Override
	public boolean isSlowWhenEmpty() {
		throw new NotImplementedException();
	}

	@Override
	public void setSlowWhenEmpty(boolean slow) {
		throw new NotImplementedException();
	}

	@Override
	public Vector getFlyingVelocityMod() {
		throw new NotImplementedException();
	}

	@Override
	public void setFlyingVelocityMod(Vector flying) {
		throw new NotImplementedException();
	}

	@Override
	public Vector getDerailedVelocityMod() {
		throw new NotImplementedException();
	}

	@Override
	public void setDerailedVelocityMod(Vector derailed) {
		throw new NotImplementedException();
	}
}
