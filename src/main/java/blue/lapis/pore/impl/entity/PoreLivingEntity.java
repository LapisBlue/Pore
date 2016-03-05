/*
 * Pore
 * Copyright (c) 2014-2016, Lapis <https://github.com/LapisBlue>
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

import static org.spongepowered.api.data.manipulator.catalog.CatalogEntityData.POTION_EFFECT_DATA;

import blue.lapis.pore.converter.type.material.MaterialConverter;
import blue.lapis.pore.converter.type.material.PotionEffectConverter;
import blue.lapis.pore.converter.type.material.PotionEffectTypeConverter;
import blue.lapis.pore.converter.vector.LocationConverter;
import blue.lapis.pore.converter.wrapper.WrapperConverter;
import blue.lapis.pore.impl.block.PoreBlock;
import blue.lapis.pore.util.ProjectileUtil;

import com.google.common.collect.Collections2;
import com.google.common.collect.ImmutableList;
import org.apache.commons.lang3.NotImplementedException;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Egg;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.entity.Snowball;
import org.bukkit.inventory.EntityEquipment;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;
import org.spongepowered.api.data.DataTransactionResult;
import org.spongepowered.api.data.key.Keys;
import org.spongepowered.api.data.property.entity.EyeHeightProperty;
import org.spongepowered.api.data.property.entity.EyeLocationProperty;
import org.spongepowered.api.entity.living.Living;
import org.spongepowered.api.entity.projectile.source.ProjectileSource;
import org.spongepowered.api.event.cause.entity.damage.DamageTypes;
import org.spongepowered.api.event.cause.entity.damage.source.DamageSource;
import org.spongepowered.api.event.cause.entity.damage.source.EntityDamageSource;
import org.spongepowered.api.util.blockray.BlockRay;
import org.spongepowered.api.util.blockray.BlockRayHit;
import org.spongepowered.api.world.World;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

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
        return getHandle().getProperty(EyeHeightProperty.class).get().getValue();
    }

    @Override
    public double getEyeHeight(boolean ignoreSneaking) {
        return getEyeHeight(); // oddly enough, CraftBukkit does the exact same thing
    }

    @Override
    public Location getEyeLocation() {
        return LocationConverter.fromVector3d(getHandle().getWorld(),
                getHandle().getProperty(EyeLocationProperty.class).get().getValue(), getHandle().getRotation());
    }

    private static final class IncludeTargetFilter implements Predicate<BlockRayHit<World>> {

        private final Predicate<BlockRayHit<World>> matcher;
        private boolean done;

        private IncludeTargetFilter(Predicate<BlockRayHit<World>> matcher) {
            this.matcher = matcher;
        }

        @Override
        public boolean test(BlockRayHit<World> worldBlockRayHit) {
            if (this.done) {
                return false;
            }

            if (!this.matcher.test(worldBlockRayHit)) {
                done = true;
            }

            return true;
        }
    }

    private static Set<Material> toMaterial(Set<Byte> uglyBytes) {
        return uglyBytes != null ? uglyBytes.stream().map(Material::getMaterial).collect(Collectors.toSet()) : null;
    }

    private BlockRay.BlockRayBuilder<World> getBlockRay(Set<Material> transparent, int maxDistance) {
        Predicate<BlockRayHit<World>> filter;
        if (transparent == null) {
            filter = BlockRay.onlyAirFilter();
        } else {
            filter = hit -> transparent.contains(MaterialConverter.of(
                    hit.getExtent().getBlockType(hit.getBlockX(), hit.getBlockY(), hit.getBlockZ())));
        }

        return BlockRay.from(getHandle()).filter(new IncludeTargetFilter(filter)).blockLimit(maxDistance);
    }

    @SuppressWarnings("deprecation")
    @Override
    public List<Block> getLineOfSight(HashSet<Byte> transparent, int maxDistance) {
        return getLineOfSight(toMaterial(transparent), maxDistance);
    }

    @Override
    public List<Block> getLineOfSight(Set<Material> transparent, int maxDistance) {
        List<Block> blocks = new ArrayList<>();
        for (BlockRayHit<World> hit : getBlockRay(transparent, maxDistance)) {
            blocks.add(PoreBlock.of(hit.getLocation()));
        }
        return blocks;
    }

    @SuppressWarnings("deprecation")
    @Override
    public Block getTargetBlock(HashSet<Byte> transparent, int maxDistance) {
        return getTargetBlock(toMaterial(transparent), maxDistance);
    }

    @Override
    public Block getTargetBlock(Set<Material> transparent, int maxDistance) {
        return PoreBlock.of(getBlockRay(transparent, maxDistance).end().map(BlockRayHit::getLocation).orElse(null));
    }

    @SuppressWarnings("deprecation")
    @Override
    public List<Block> getLastTwoTargetBlocks(HashSet<Byte> transparent, int maxDistance) {
        return getLastTwoTargetBlocks(toMaterial(transparent), maxDistance);
    }

    @Override
    public List<Block> getLastTwoTargetBlocks(Set<Material> transparent, int maxDistance) {
        BlockRayHit<World> last = null;
        BlockRayHit<World> current = null;
        for (BlockRayHit<World> hit : getBlockRay(transparent, maxDistance)) {
            last = current;
            current = hit;
        }

        if (current == null) {
            return ImmutableList.of();
        } else if (last == null) {
            return ImmutableList.of(PoreBlock.of(current.getLocation()));
        } else {
            return ImmutableList.of(PoreBlock.of(last.getLocation()), PoreBlock.of(current.getLocation()));
        }
    }

    @SuppressWarnings("deprecation")
    @Override
    public Egg throwEgg() {
        if (getHandle() instanceof ProjectileSource) {
            return PoreEgg.of(
                    ((ProjectileSource) getHandle()).launchProjectile(
                            org.spongepowered.api.entity.projectile.Egg.class
                    ).orElse(null)
            );
        }
        // CB never returns null here so we shouldn't either
        // this will prevent ambiguity if something breaks (as opposed to if we let a plugin throw an NPE)
        throw new UnsupportedOperationException("Not a ProjectileSource");
    }

    @SuppressWarnings("deprecation")
    @Override
    public Snowball throwSnowball() {
        if (getHandle() instanceof ProjectileSource) {
            return PoreSnowball.of(
                    ((ProjectileSource) getHandle()).launchProjectile(
                            org.spongepowered.api.entity.projectile.Snowball.class
                    ).orElse(null)
            );
        }
        throw new UnsupportedOperationException("Not a ProjectileSource");
    }

    @SuppressWarnings("deprecation")
    @Override
    public Arrow shootArrow() {
        if (getHandle() instanceof ProjectileSource) {
            return PoreArrow.of(
                    ((ProjectileSource) getHandle()).launchProjectile(
                            org.spongepowered.api.entity.projectile.Arrow.class
                    ).orElse(null)
            );
        }
        throw new UnsupportedOperationException("Not a ProjectileSource");
    }

    @Override
    public int getRemainingAir() {
        return getHandle().get(Keys.REMAINING_AIR).get();
    }

    @Override
    public void setRemainingAir(int ticks) {
        getHandle().offer(Keys.REMAINING_AIR, ticks);
    }

    @Override
    public int getMaximumAir() {
        return getHandle().get(Keys.MAX_AIR).get();
    }

    @Override
    public void setMaximumAir(int ticks) {
        getHandle().offer(Keys.MAX_AIR, ticks);
    }

    @Override
    public int getMaximumNoDamageTicks() {
        return getHandle().getValue(Keys.INVULNERABILITY).get().getMaxValue();
    }

    @Override
    public void setMaximumNoDamageTicks(int ticks) {
        throw new NotImplementedException("TODO");
    }

    @Override
    public double getLastDamage() {
        return getHandle().get(Keys.LAST_DAMAGE).get().orElse(0.0);
    }

    @SuppressWarnings("deprecation")
    @Override
    public int _INVALID_getLastDamage() {
        return (int) this.getLastDamage();
    }

    @Override
    public void setLastDamage(double damage) {
        getHandle().offer(Keys.LAST_DAMAGE, Optional.of(damage));
    }

    @SuppressWarnings("deprecation")
    @Override
    public void _INVALID_setLastDamage(int damage) {
        this.setLastDamage(damage);
    }

    @Override
    public int getNoDamageTicks() {
        return getHandle().get(Keys.INVULNERABILITY).get();
    }

    @Override
    public void setNoDamageTicks(int ticks) {
        getHandle().offer(Keys.INVULNERABILITY, ticks);
    }

    @Override
    public Player getKiller() {
        throw new NotImplementedException("TODO");
    }

    @Override
    public boolean addPotionEffect(PotionEffect effect) {
        return addPotionEffect(effect, false);
    }

    @Override
    public boolean addPotionEffect(PotionEffect effect, boolean force) {
        return addPotionEffects(Collections.singletonList(effect));
    }

    @Override
    public boolean addPotionEffects(Collection<PotionEffect> effects) {
        List<org.spongepowered.api.effect.potion.PotionEffect> effectList
                = getHandle().getOrCreate(POTION_EFFECT_DATA).get().effects().get();
        effectList.addAll(Collections2.transform(effects,
                PotionEffectConverter::of
        ));
        return getHandle().offer(Keys.POTION_EFFECTS, effectList).getType()
                == DataTransactionResult.Type.SUCCESS;
    }

    @Override
    public boolean hasPotionEffect(PotionEffectType type) {
        org.spongepowered.api.effect.potion.PotionEffectType spongeType = PotionEffectTypeConverter.of(type);
        List<org.spongepowered.api.effect.potion.PotionEffect> effects =
                getHandle().get(Keys.POTION_EFFECTS).orElse(null);
        if (effects != null) {
            for (org.spongepowered.api.effect.potion.PotionEffect potionEffect : effects) {
                if (potionEffect.getType() == spongeType) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public void removePotionEffect(PotionEffectType type) {
        List<org.spongepowered.api.effect.potion.PotionEffect> effects =
                getHandle().get(Keys.POTION_EFFECTS).orElse(null);
        org.spongepowered.api.effect.potion.PotionEffectType spongeType = PotionEffectTypeConverter.of(type);
        if (effects != null) {
            Iterator<org.spongepowered.api.effect.potion.PotionEffect> it = effects.iterator();
            while (it.hasNext()) {
                if (it.next().getType() == spongeType) {
                    it.remove();
                }
            }
        }
    }

    @Override
    public Collection<PotionEffect> getActivePotionEffects() {
        List<org.spongepowered.api.effect.potion.PotionEffect> effects = getHandle().get(Keys.POTION_EFFECTS)
                .orElse(null);
        if (effects == null) {
            return ImmutableList.of();
        }

        return Collections2.transform(effects, PotionEffectConverter::of);
    }

    @Override
    public boolean hasLineOfSight(Entity other) {
        throw new NotImplementedException("TODO");
    }

    @Override
    public boolean getRemoveWhenFarAway() {
        throw new NotImplementedException("TODO");
    }

    @Override
    public void setRemoveWhenFarAway(boolean remove) {
        throw new NotImplementedException("TODO");
    }

    @Override
    public EntityEquipment getEquipment() {
        throw new NotImplementedException("TODO");
    }

    @Override
    public void setCanPickupItems(boolean pickup) {
        throw new NotImplementedException("TODO");
    }

    @Override
    public boolean getCanPickupItems() {
        throw new NotImplementedException("TODO");
    }

    @Override
    public boolean isLeashed() {
        return getHandle().get(Keys.LEASH_HOLDER).isPresent();
    }

    @Override
    public Entity getLeashHolder() throws IllegalStateException {
        if (isLeashed()) {
            return PoreEntity.of(getHandle().get(Keys.LEASH_HOLDER).get());
        } else {
            throw new IllegalStateException("Not leashed");
        }
    }

    @Override
    public boolean setLeashHolder(Entity holder) {
        return getHandle().offer(Keys.LEASH_HOLDER, ((PoreEntity) holder).getHandle().createSnapshot()).isSuccessful();
    }

    @Override
    public void damage(double amount) {
        damage(amount, null);
    }

    @Override
    public void damage(double amount, Entity source) {
        if (source != null) {
            getHandle().damage(amount, EntityDamageSource.builder()
                    .type(DamageTypes.GENERIC)
                    .entity(((PoreEntity) source).getHandle())
                    .build());
        } else {
            getHandle().damage(amount, DamageSource.builder().type(DamageTypes.GENERIC).build());
        }
    }

    @SuppressWarnings("deprecation")
    @Override
    public void _INVALID_damage(int amount) {
        damage((double) amount);
    }

    @SuppressWarnings("deprecation")
    @Override
    public void _INVALID_damage(int amount, Entity source) {
        damage((double) amount, source);
    }

    @Override
    public double getHealth() {
        return getHandle().get(Keys.HEALTH).orElse(0.0);
    }

    @SuppressWarnings("deprecation")
    @Override
    public int _INVALID_getHealth() {
        return (int) getHealth();
    }

    @Override
    public void setHealth(double health) {
        getHandle().offer(Keys.HEALTH, health);
    }

    @SuppressWarnings("deprecation")
    @Override
    public void _INVALID_setHealth(int health) {
        setHealth((double) health);
    }

    @Override
    public double getMaxHealth() {
        return getHandle().get(Keys.MAX_HEALTH).orElse(0.0);
    }

    @SuppressWarnings("deprecation")
    @Override
    public int _INVALID_getMaxHealth() {
        return (int) getMaxHealth();
    }

    @Override
    public void setMaxHealth(double health) {
        getHandle().offer(Keys.MAX_HEALTH, health);
    }

    @SuppressWarnings("deprecation")
    @Override
    public void _INVALID_setMaxHealth(int health) {
        setMaxHealth((double) health);
    }

    @Override
    public void resetMaxHealth() {
        getHandle().offer(Keys.MAX_HEALTH, getHandle().getValue(Keys.MAX_HEALTH).get().getMaxValue());
    }

    @Override
    public <T extends Projectile> T launchProjectile(Class<? extends T> projectile) {
        return launchProjectile(projectile, null);
    }

    @Override
    public <T extends Projectile> T launchProjectile(Class<? extends T> projectile, Vector velocity) {
        if (getHandle() instanceof ProjectileSource) {
            return ProjectileUtil.launchProjectile((ProjectileSource) getHandle(), projectile, velocity).orNull();
        }
        throw new UnsupportedOperationException();
    }
}
