package net.amigocraft.pore.implementation.entity.minecart;

import net.amigocraft.pore.implementation.entity.PoreVehicle;
import org.apache.commons.lang.NotImplementedException;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Minecart;
import org.bukkit.util.Vector;

public class PoreMinecart extends PoreVehicle implements Minecart {

	//TODO: Bridge

	//TODO: make constructor as specific as possible
	protected PoreMinecart(org.spongepowered.api.entity.LivingEntity handle){
		super(handle);
	}

	public static PoreMinecart of(org.spongepowered.api.entity.Entity handle){
		return (PoreMinecart)PoreVehicle.of(handle);
	}

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
		return 0;
	}

	@Override
	public double getDamage() {
		return 0;
	}

	@Override
	public double getMaxSpeed() {
		return 0;
	}

	@Override
	public void setMaxSpeed(double speed) {
		throw new NotImplementedException();
	}

	@Override
	public boolean isSlowWhenEmpty() {
		return false;
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
