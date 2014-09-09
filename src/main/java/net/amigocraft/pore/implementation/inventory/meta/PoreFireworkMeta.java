package net.amigocraft.pore.implementation.inventory.meta;

import org.bukkit.FireworkEffect;
import org.bukkit.inventory.meta.FireworkMeta;

import java.util.List;

// TODO: bridge

public class PoreFireworkMeta extends PoreItemMeta implements FireworkMeta {

	@Override
	public void addEffect(FireworkEffect effect) throws IllegalArgumentException {

	}

	@Override
	public void addEffects(FireworkEffect... effects) throws IllegalArgumentException {

	}

	@Override
	public void addEffects(Iterable<FireworkEffect> effects) throws IllegalArgumentException {

	}

	@Override
	public List<FireworkEffect> getEffects() {
		return null;
	}

	@Override
	public int getEffectsSize() {
		return 0;
	}

	@Override
	public void removeEffect(int index) throws IndexOutOfBoundsException {

	}

	@Override
	public void clearEffects() {

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

	}

	@Override
	public FireworkMeta clone() {
		return null;
	}

}