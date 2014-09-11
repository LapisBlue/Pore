package net.amigocraft.pore.implementation.entity;

import org.bukkit.entity.AnimalTamer;
import org.bukkit.entity.Horse;
import org.bukkit.inventory.HorseInventory;

public class PoreHorse extends PoreAnimals implements Horse {

	public PoreHorse(org.spongepowered.api.entity.LivingEntity handle) { //TODO: accept most specfific type
		super(handle);
	}

    // TODO: Bridge
    @Override
    public Variant getVariant() {
        return null;
    }

    @Override
    public void setVariant(Variant variant) {

    }

    @Override
    public Color getColor() {
        return null;
    }

    @Override
    public void setColor(Color color) {

    }

    @Override
    public Style getStyle() {
        return null;
    }

    @Override
    public void setStyle(Style style) {

    }

    @Override
    public boolean isCarryingChest() {
        return false;
    }

    @Override
    public void setCarryingChest(boolean chest) {

    }

    @Override
    public int getDomestication() {
        return 0;
    }

    @Override
    public void setDomestication(int level) {

    }

    @Override
    public int getMaxDomestication() {
        return 0;
    }

    @Override
    public void setMaxDomestication(int level) {

    }

    @Override
    public double getJumpStrength() {
        return 0;
    }

    @Override
    public void setJumpStrength(double strength) {

    }

    @Override
    public HorseInventory getInventory() {
        return null;
    }

    @Override
    public boolean isTamed() {
        return false;
    }

    @Override
    public void setTamed(boolean tame) {

    }

    @Override
    public AnimalTamer getOwner() {
        return null;
    }

    @Override
    public void setOwner(AnimalTamer tamer) {

    }
}
