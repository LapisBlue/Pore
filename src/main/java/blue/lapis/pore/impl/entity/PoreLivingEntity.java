/*
 * Pore
 * Copyright (c) 2014-2015, Lapis <https://github.com/LapisBlue>
 *
 * The MIT License
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package blue.lapis.pore.impl.entity;

import blue.lapis.pore.converter.type.material.PotionEffectConverter;
import blue.lapis.pore.converter.type.material.PotionEffectTypeConverter;
import blue.lapis.pore.converter.vector.LocationConverter;
import blue.lapis.pore.converter.wrapper.WrapperConverter;
import blue.lapis.pore.util.ProjectileUtil;

import org.apache.commons.lang3.NotImplementedException;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Bat;
import org.bukkit.entity.Egg;
import org.bukkit.entity.EnderDragon;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.entity.Snowball;
import org.bukkit.entity.Witch;
import org.bukkit.entity.Wither;
import org.bukkit.inventory.EntityEquipment;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;
import org.spongepowered.api.data.manipulator.DisplayNameData;
import org.spongepowered.api.data.manipulator.PotionEffectData;
import org.spongepowered.api.data.manipulator.entity.BreathingData;
import org.spongepowered.api.data.manipulator.entity.DamageableData;
import org.spongepowered.api.data.manipulator.entity.EyeLocationData;
import org.spongepowered.api.data.manipulator.entity.HealthData;
import org.spongepowered.api.data.manipulator.entity.LeashData;
import org.spongepowered.api.entity.living.Agent;
import org.spongepowered.api.entity.living.Living;
import org.spongepowered.api.entity.projectile.source.ProjectileSource;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.Text.Literal;
import org.spongepowered.api.text.Texts;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PoreLivingEntity extends PoreEntity implements LivingEntity {

    public static PoreLivingEntity of(Living handle) {
        return WrapperConverter.of(PoreLivingEntity.class, handle);
    }

    protected PoreLivingEntity(Living handle) {
        super(handle);
    }

    @Override
    public Living getHandle() {
        return (Living) super.getHandle();
    }

    @Override
    public double getEyeHeight() {
        return get(EyeLocationData.class).getEyeHeight();
    }

    @Override
    public double getEyeHeight(boolean ignoreSneaking) {
        return getEyeHeight(); // oddly enough, CraftBukkit does the exact same thing
    }

    @Override
    public Location getEyeLocation() {
        return LocationConverter.fromVector3d(getHandle().getWorld(), get(EyeLocationData.class).getEyeLocation());
    }

    @Override
    public List<Block> getLineOfSight(HashSet<Byte> transparent, int maxDistance) {
        throw new NotImplementedException("TODO"); //TODO
    }

    @Override
    public List<Block> getLineOfSight(Set<Material> transparent, int maxDistance) {
        throw new NotImplementedException("TODO"); // TODO
    }

    @Override
    public Block getTargetBlock(HashSet<Byte> transparent, int maxDistance) {
        throw new NotImplementedException("TODO"); //TODO
    }

    @Override
    public Block getTargetBlock(Set<Material> transparent, int maxDistance) {
        throw new NotImplementedException("TODO"); // TODO
    }

    @Override
    public List<Block> getLastTwoTargetBlocks(HashSet<Byte> transparent, int maxDistance) {
        throw new NotImplementedException("TODO"); //TODO
    }

    @Override
    public List<Block> getLastTwoTargetBlocks(Set<Material> transparent, int maxDistance) {
        throw new NotImplementedException("TODO"); // TODO
    }

    @Override
    public Egg throwEgg() {
        if (getHandle() instanceof ProjectileSource) {
            return PoreEgg.of(
                    ((ProjectileSource) getHandle()).launchProjectile(
                            org.spongepowered.api.entity.projectile.Egg.class
                    )
            );
        }
        return null; //TODO: should an UnsupportedOperationException be thrown?
    }

    @Override
    public Snowball throwSnowball() {
        if (getHandle() instanceof ProjectileSource) {
            return PoreSnowball.of(
                    ((ProjectileSource) getHandle()).launchProjectile(
                            org.spongepowered.api.entity.projectile.Snowball.class
                    )
            );
        }
        return null; //TODO: should an UnsupportedOperationException be thrown?
    }

    @Override
    public Arrow shootArrow() {
        if (getHandle() instanceof ProjectileSource) {
            return PoreArrow.of(
                    ((ProjectileSource) getHandle()).launchProjectile(
                            org.spongepowered.api.entity.projectile.Arrow.class
                    )
            );
        }
        return null; //TODO: should an UnsupportedOperationException be thrown?
    }

    @Override
    public int getRemainingAir() {
        return get(BreathingData.class).getRemainingAir();
    }

    @Override
    public void setRemainingAir(int ticks) {
        get(BreathingData.class).setRemainingAir(ticks);
    }

    @Override
    public int getMaximumAir() {
        return get(BreathingData.class).getMaxAir();
    }

    @Override
    public void setMaximumAir(int ticks) {
        get(BreathingData.class).setMaxAir(ticks);
    }

    @Override
    public int getMaximumNoDamageTicks() {
        return get(DamageableData.class).getMaxInvulnerabilityTicks();
    }

    @Override
    public void setMaximumNoDamageTicks(int ticks) {
        get(DamageableData.class).setMaxInvulnerabilityTicks(ticks);
    }

    @Override
    public double getLastDamage() {
        return get(DamageableData.class).getLastDamage().get();
    }

    @Override
    public int _INVALID_getLastDamage() {
        return (int) this.getLastDamage();
    }

    @Override
    public void setLastDamage(double damage) {
        get(DamageableData.class).setLastDamage(damage);
    }

    @Override
    public void _INVALID_setLastDamage(int damage) {
        this.setLastDamage(damage);
    }

    @Override
    public int getNoDamageTicks() {
        return get(DamageableData.class).getInvulnerabilityTicks();
    }

    @Override
    public void setNoDamageTicks(int ticks) {
        get(DamageableData.class).setInvulnerabilityTicks(ticks);
    }

    @Override
    public Player getKiller() {
        throw new NotImplementedException("TODO"); //TODO
    }

    @Override
    public boolean addPotionEffect(PotionEffect effect) {
        return addPotionEffect(effect, false);
    }

    @Override
    public boolean addPotionEffect(PotionEffect effect, boolean force) {
        org.spongepowered.api.potion.PotionEffect eff = PotionEffectConverter.of(effect);
        get(PotionEffectData.class).addPotionEffect(eff, force);
        return get(PotionEffectData.class).hasPotionEffect(eff.getType());
    }

    @Override
    public boolean addPotionEffects(Collection<PotionEffect> effects) {
        boolean success = true;
        for (PotionEffect effect : effects) {
            this.addPotionEffect(effect);
            if (!this.hasPotionEffect(effect.getType())) {
                success = false;
            }
        }
        return success;
    }

    @Override
    public boolean hasPotionEffect(PotionEffectType type) {
        return get(PotionEffectData.class).hasPotionEffect(PotionEffectTypeConverter.of(type));
    }

    @Override
    public void removePotionEffect(PotionEffectType type) {
        get(PotionEffectData.class).removePotionEffect(PotionEffectTypeConverter.of(type));
    }

    @Override
    public Collection<PotionEffect> getActivePotionEffects() {
        List<PotionEffect> effects = new ArrayList<PotionEffect>();
        for (org.spongepowered.api.potion.PotionEffect effect : get(PotionEffectData.class).getPotionEffects()) {
            effects.add(PotionEffectConverter.of(effect));
        }
        return effects;
    }

    @Override
    public boolean hasLineOfSight(Entity other) {
        throw new NotImplementedException("TODO"); //TODO
    }

    @Override
    public boolean getRemoveWhenFarAway() {
        throw new NotImplementedException("TODO"); //TODO
    }

    @Override
    public void setRemoveWhenFarAway(boolean remove) {
        throw new NotImplementedException("TODO"); //TODO
    }

    @Override
    public EntityEquipment getEquipment() {
        throw new NotImplementedException("TODO"); //TODO
    }

    @Override
    public void setCanPickupItems(boolean pickup) {
        throw new NotImplementedException("TODO"); //TODO
    }

    @Override
    public boolean getCanPickupItems() {
        throw new NotImplementedException("TODO"); //TODO
    }

    @Override
    @SuppressWarnings("deprecation")
    public void setCustomName(String name) {
        get(DisplayNameData.class).setDisplayName(Texts.fromLegacy(name)); //TODO deprecated
    }

    @Override
    public String getCustomName() {
        Text.Literal text = (Literal) get(DisplayNameData.class).getDisplayName();//TODO Working?
        return text.getContent();
    }

    @Override
    public void setCustomNameVisible(boolean flag) {
        get(DisplayNameData.class).setCustomNameVisible(flag);
    }

    @Override
    public boolean isCustomNameVisible() {
        return get(DisplayNameData.class).isCustomNameVisible();
    }

    @Override
    public boolean isLeashed() {
        return getHandle() instanceof Agent && has(LeashData.class);
    }

    @Override
    public Entity getLeashHolder() throws IllegalStateException {
        if (getHandle() instanceof Agent) {
            return get(LeashData.class).getLeashHolder() != null 
                    ? PoreEntity.of(get(LeashData.class).getLeashHolder()) : null;
        }
        return null;
    }

    @Override
    public boolean setLeashHolder(Entity holder) {
        if (getHandle() instanceof Agent) {
            if (!(this instanceof Bat) && !(this instanceof EnderDragon)
                    && !(this instanceof Witch) && !(this instanceof Wither)) {

                getOrCreate(LeashData.class).setLeashHolder(((PoreEntity) holder).getHandle());
                return true;
            }
        }
        return false;
    }

    @Override
    public void damage(double amount) {
        get(HealthData.class).damage(amount);
    }

    @Override
    public void damage(double amount, Entity source) {
        damage(amount); //TODO
    }

    @Override
    public void _INVALID_damage(int amount) {
        get(HealthData.class).damage(amount);
    }

    @Override
    public void _INVALID_damage(int amount, Entity source) {
        damage(amount); //TODO
    }

    @Override
    public double getHealth() {
        return get(HealthData.class).getHealth();
    }

    @Override
    public int _INVALID_getHealth() {
        return (int) get(HealthData.class).getHealth();
    }

    @Override
    public void setHealth(double health) {
        getOrCreate(HealthData.class).setHealth(health);
    }

    @Override
    public void _INVALID_setHealth(int health) {
        getOrCreate(HealthData.class).setHealth(health);
    }

    @Override
    public double getMaxHealth() {
        return get(HealthData.class).getMaxHealth();
    }

    @Override
    public int _INVALID_getMaxHealth() {
        return (int) getMaxHealth();
    }

    @Override
    public void setMaxHealth(double health) {
        getOrCreate(HealthData.class).setMaxHealth(health);
    }

    @Override
    public void _INVALID_setMaxHealth(int health) {
        setMaxHealth(health);
    }

    @Override
    public void resetMaxHealth() {
        throw new NotImplementedException("TODO");
    }

    @Override
    public <T extends Projectile> T launchProjectile(Class<? extends T> projectile) {
        return launchProjectile(projectile, null);
    }

    @Override
    public <T extends Projectile> T launchProjectile(Class<? extends T> projectile, Vector velocity) {
        if (getHandle() instanceof ProjectileSource) {
            return ProjectileUtil.launchProjectile((ProjectileSource) getHandle(), projectile, velocity);
        }
        throw new UnsupportedOperationException();
    }
}
