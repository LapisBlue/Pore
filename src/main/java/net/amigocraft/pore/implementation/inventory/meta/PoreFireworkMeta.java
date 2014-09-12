package net.amigocraft.pore.implementation.inventory.meta;

import org.apache.commons.lang.NotImplementedException;
import org.bukkit.FireworkEffect;
import org.bukkit.inventory.meta.FireworkMeta;

import java.util.List;

// TODO: bridge

// TODO: bridge

public class PoreFireworkMeta extends PoreItemMeta implements FireworkMeta {

	@Override
	public void addEffect(FireworkEffect effect) throws IllegalArgumentException {
		throw new NotImplementedException();
	}

	@Override
	public void addEffects(FireworkEffect... effects) throws IllegalArgumentException {
		throw new NotImplementedException();
	}

	@Override
	public void addEffects(Iterable<FireworkEffect> effects) throws IllegalArgumentException {
		throw new NotImplementedException();
	}

	@Override
	public List<FireworkEffect> getEffects() {
		throw new NotImplementedException();
	}

	@Override
	public int getEffectsSize() {
		return 0;
	}

	@Override
	public void removeEffect(int index) throws IndexOutOfBoundsException {
		throw new NotImplementedException();
	}

	@Override
	public void clearEffects() {
		throw new NotImplementedException();
	}

	@Override
	public boolean hasEffects() {
		return false;
	}

	@Override
	public int getPower() {
		return 0;
	}

	@Override
	public void setPower(int power) throws IllegalArgumentException {
		throw new NotImplementedException();
	}

	@Override
	public FireworkMeta clone() {
		throw new NotImplementedException();
	}

}