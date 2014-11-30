package net.amigocraft.pore.impl.inventory.meta;

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
		throw new NotImplementedException();
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
		throw new NotImplementedException();
	}

	@Override
	public int getPower() {
		throw new NotImplementedException();
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