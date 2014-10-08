package net.amigocraft.pore.implementation.entity;

import org.apache.commons.lang.NotImplementedException;
import org.bukkit.entity.AnimalTamer;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Horse;
import org.bukkit.inventory.HorseInventory;

public class PoreHorse extends PoreAnimals implements Horse {

	// TODO: Bridge

	//TODO: make constructor as specific as possible
	protected PoreHorse(org.spongepowered.api.entity.LivingEntity handle){
		super(handle);
	}

	public static PoreHorse of(org.spongepowered.api.entity.Entity handle){
		return (PoreHorse)PoreAnimals.of(handle);
	}

	@Override
	public EntityType getType(){
		return EntityType.HORSE;
	}

	@Override
	public Variant getVariant() {
		throw new NotImplementedException();
	}

	@Override
	public void setVariant(Variant variant) {
		throw new NotImplementedException();
	}

	@Override
	public Color getColor() {
		throw new NotImplementedException();
	}

	@Override
	public void setColor(Color color) {
		throw new NotImplementedException();
	}

	@Override
	public Style getStyle() {
		throw new NotImplementedException();
	}

	@Override
	public void setStyle(Style style) {
		throw new NotImplementedException();
	}

	@Override
	public boolean isCarryingChest() {
		return false;
	}

	@Override
	public void setCarryingChest(boolean chest) {
		throw new NotImplementedException();
	}

	@Override
	public int getDomestication() {
		return 0;
	}

	@Override
	public void setDomestication(int level) {
		throw new NotImplementedException();
	}

	@Override
	public int getMaxDomestication() {
		return 0;
	}

	@Override
	public void setMaxDomestication(int level) {
		throw new NotImplementedException();
	}

	@Override
	public double getJumpStrength() {
		return 0;
	}

	@Override
	public void setJumpStrength(double strength) {
		throw new NotImplementedException();
	}

	@Override
	public HorseInventory getInventory() {
		throw new NotImplementedException();
	}

	@Override
	public boolean isTamed() {
		return false;
	}

	@Override
	public void setTamed(boolean tame) {
		throw new NotImplementedException();
	}

	@Override
	public AnimalTamer getOwner() {
		throw new NotImplementedException();
	}

	@Override
	public void setOwner(AnimalTamer tamer) {
		throw new NotImplementedException();
	}
}
