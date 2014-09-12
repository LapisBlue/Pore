package net.amigocraft.pore.implementation.entity.minecart;

import net.amigocraft.pore.implementation.entity.PoreVehicle;
import org.apache.commons.lang.NotImplementedException;
import org.bukkit.entity.Minecart;
import org.bukkit.util.Vector;

public class PoreMinecart extends PoreVehicle implements Minecart {

	//TODO: Bridge

	public PoreMinecart(org.spongepowered.api.entity.Entity handle) { //TODO: accept most specfific type
		super(handle);
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
