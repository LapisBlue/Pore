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
package net.amigocraft.pore.event;

import net.amigocraft.pore.impl.block.PoreBlock;
import net.amigocraft.pore.impl.entity.PoreAnimalTamer;
import net.amigocraft.pore.impl.entity.PoreBoat;
import net.amigocraft.pore.impl.entity.PoreCreature;
import net.amigocraft.pore.impl.entity.PoreEntity;
import net.amigocraft.pore.impl.entity.PoreLivingEntity;
import net.amigocraft.pore.impl.entity.PoreVehicle;
import net.amigocraft.pore.impl.entity.minecart.PoreMinecart;
import net.amigocraft.pore.util.converter.MaterialConverter;
import net.amigocraft.pore.util.converter.vector.LocationConverter;
import org.bukkit.Bukkit;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityRegainHealthEvent;
import org.bukkit.event.vehicle.VehicleEntityCollisionEvent;
import org.bukkit.inventory.ItemStack;
import org.spongepowered.api.entity.living.Agent;
import org.spongepowered.api.entity.living.Living;
import org.spongepowered.api.entity.living.Tameable;
import org.spongepowered.api.entity.vehicle.Boat;
import org.spongepowered.api.entity.vehicle.minecart.Minecart;
import org.spongepowered.api.event.entity.EntityChangeBlockEvent;
import org.spongepowered.api.event.entity.EntityChangeHealthEvent;
import org.spongepowered.api.event.entity.EntityCollisionWithEntityEvent;
import org.spongepowered.api.event.entity.EntityDeathEvent;
import org.spongepowered.api.event.entity.EntitySpawnEvent;
import org.spongepowered.api.event.entity.EntityTameEvent;
import org.spongepowered.api.event.entity.EntityTeleportEvent;
import org.spongepowered.api.event.entity.ProjectileLaunchEvent;
import org.spongepowered.api.util.event.Subscribe;

import java.util.ArrayList;

public class EntityEventRelay {

    @Subscribe
    public void onEntityChangeBlock(final EntityChangeBlockEvent event) {
        Bukkit.getPluginManager().callEvent(
                new org.bukkit.event.entity.EntityChangeBlockEvent(
                        PoreEntity.of(event.getEntity()),
                        PoreBlock.of(event.getBlock()),
                        MaterialConverter.toBukkitMaterial(event.getReplacementBlock().getState().getType()),
                        event.getReplacementBlock().getState().getDataValue()
                ) {
                    @Override
                    public void setCancelled(boolean cancelled) {
                        super.setCancelled(cancelled);
                        //TODO: find a way to cancel the event in Sponge
                    }
                }
        );
    }

    @Subscribe
    public void onEntityChangeHealth(final EntityChangeHealthEvent event) {
        if (event.getNewHealth() > event.getOldHealth()) { // entity has gained health
            Bukkit.getPluginManager().callEvent(
                    new EntityRegainHealthEvent(
                            PoreEntity.of(event.getEntity()),
                            event.getNewHealth() - event.getOldHealth(),
                            null //TODO: reason
                    ) {
                        @Override
                        public void setCancelled(boolean cancelled) {
                            super.setCancelled(cancelled);
                            event.setCancelled(cancelled);
                        }
                    }
            );
        } else { // entity has been damaged (lost health)
            //TODO: check if cause is entity or block
            //TODO: CB passes the raw damage but Sponge has no way to access it, so plugins may behave unexpectedly
            Bukkit.getPluginManager().callEvent(
                    new EntityDamageEvent(
                            PoreEntity.of(event.getEntity()),
                            EntityDamageEvent.DamageCause.CUSTOM, //TODO: reason
                            event.getOldHealth() - event.getNewHealth()
                    ) {
                        @Override
                        public void setCancelled(boolean cancelled) {
                            super.setCancelled(cancelled);
                            event.setCancelled(cancelled);
                        }
                    }
            );
        }
    }

    @Subscribe
    public void onEntityCollisionWithEntity(final EntityCollisionWithEntityEvent event) {
        // Bukkit only has an event for vehicle collisions against other entities
        PoreVehicle vehicle = null;
        if (event.getEntity() instanceof Minecart) {
            vehicle = PoreMinecart.of((Minecart) event.getEntity());
        } else if (event.getEntity() instanceof Boat) {
            vehicle = PoreBoat.of((Boat) event.getEntity());
        }

        if (vehicle != null) {
            Bukkit.getPluginManager().callEvent(
                    new VehicleEntityCollisionEvent(
                            vehicle,
                            PoreEntity.of(event.getCollided())
                    ) {
                        @Override
                        public void setCancelled(boolean cancelled) {
                            super.setCancelled(cancelled);
                            event.setCancelled(cancelled);
                        }
                    }
            );
        }
    }

    @Subscribe
    public void onEntityDeath(final EntityDeathEvent event) {
        Bukkit.getPluginManager().callEvent(
                new org.bukkit.event.entity.EntityDeathEvent(
                        PoreLivingEntity.of((Living) event.getEntity()),
                        new ArrayList<ItemStack>(), //TODO: drops
                        0 //TODO: dropped exp
                )
        );
    }

    @Subscribe
    public void onEntitySpawn(final EntitySpawnEvent event) {
        if (event.getEntity() instanceof Agent)
            Bukkit.getPluginManager().callEvent(
                    new CreatureSpawnEvent(
                            PoreCreature.of((Agent) event.getEntity()),
                            CreatureSpawnEvent.SpawnReason.DEFAULT //TODO: reason
                    ) {
                        @Override
                        public void setCancelled(boolean cancelled) {
                            super.setCancelled(cancelled);
                            event.setCancelled(cancelled);
                        }
                    }
            );
    }

    @Subscribe
    public void onEntityTame(final EntityTameEvent event) {
        if (event.getEntity() instanceof Tameable && ((Tameable) event.getEntity()).getOwner().isPresent()) {
            Bukkit.getPluginManager().callEvent(
                    new org.bukkit.event.entity.EntityTameEvent(
                            PoreLivingEntity.of((Living) event.getEntity()),
                            PoreAnimalTamer.of(((Tameable) event.getEntity()).getOwner().get())
                    ) {
                        @Override
                        public void setCancelled(boolean cancelled) {
                            super.setCancelled(cancelled);
                            event.setCancelled(cancelled);
                        }
                    }
            );
        }
    }

    @Subscribe
    public void onEntityTeleport(final EntityTeleportEvent event) {
        Bukkit.getPluginManager().callEvent(
                new org.bukkit.event.entity.EntityTeleportEvent(
                        PoreEntity.of(event.getEntity()),
                        LocationConverter.of(event.getOldLocation()),
                        LocationConverter.of(event.getNewLocation())
                )
        );
    }

    @Subscribe
    public void onProjectileLaunch(final ProjectileLaunchEvent event) {
        Bukkit.getPluginManager().callEvent(
                new org.bukkit.event.entity.ProjectileLaunchEvent(
                        PoreEntity.of(event.getEntity())
                )
        );
    }

}
