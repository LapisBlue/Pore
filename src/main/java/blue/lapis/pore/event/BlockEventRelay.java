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
package blue.lapis.pore.event;

import blue.lapis.pore.converter.ItemStackConverter;
import blue.lapis.pore.converter.vector.VectorConverter;
import blue.lapis.pore.impl.block.PoreBlock;
import blue.lapis.pore.impl.block.PoreBlockState;
import blue.lapis.pore.impl.entity.PoreEntity;
import blue.lapis.pore.impl.entity.PorePlayer;
import org.bukkit.Bukkit;
import org.bukkit.event.block.BlockFadeEvent;
import org.bukkit.event.block.BlockGrowEvent;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.event.block.BlockBurnEvent;
import org.spongepowered.api.event.block.BlockChangeEvent;
import org.spongepowered.api.event.block.BlockDispenseEvent;
import org.spongepowered.api.event.block.BlockIgniteEvent;
import org.spongepowered.api.event.block.BlockMoveEvent;
import org.spongepowered.api.event.block.FloraGrowEvent;
import org.spongepowered.api.event.block.LeafDecayEvent;
import org.spongepowered.api.event.entity.living.player.PlayerBreakBlockEvent;
import org.spongepowered.api.event.entity.living.player.PlayerPlaceBlockEvent;
import org.spongepowered.api.util.event.Subscribe;

public class BlockEventRelay {

    @Subscribe
    public void onPlayerPlaceBlock(final PlayerPlaceBlockEvent event) {
        Bukkit.getPluginManager().callEvent(
                new org.bukkit.event.block.BlockPlaceEvent(
                        PoreBlock.of(event.getBlock()),
                        null, //TODO: find way to convert osa.BlockSnapshot to obc.BlockState
                        null, //TODO: face block was placed against
                        ItemStackConverter.of(event.getPlayer().getItemInHand().get()),
                        PorePlayer.of(event.getPlayer()),
                        true // TODO: canBuild
                ) {
                    @Override
                    public void setCancelled(boolean cancelled) {
                        super.setCancelled(cancelled);
                        event.setCancelled(cancelled);
                    }
                }
        );
    }

    //TODO: does CraftBukkit call an event when an entity such as an enderman breaks or places a block?

    @Subscribe
    public void onPlayerBreakBlock(final PlayerBreakBlockEvent event) {
        Bukkit.getPluginManager().callEvent(
                new org.bukkit.event.block.BlockBreakEvent(
                        PoreBlock.of(event.getBlock()),
                        PorePlayer.of(event.getPlayer())
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
    public void onBlockBurn(final BlockBurnEvent event) {
        Bukkit.getPluginManager().callEvent(
                new org.bukkit.event.block.BlockBurnEvent(
                        PoreBlock.of(event.getBlock())
                ) {
                    @Override
                    public void setCancelled(boolean cancelled) {
                        super.setCancelled(true);
                        //TODO: find a way to cancel the event in Sponge
                    }
                }
        );
    }

    @Subscribe
    public void onBlockChange(final BlockChangeEvent event) {
        //TODO: umbrella event covering most types of block transformations, can't implement until Causes are
        // ready
    }

    @Subscribe
    public void onBlockDispense(final BlockDispenseEvent event) {
        Bukkit.getPluginManager().callEvent(
                new org.bukkit.event.block.BlockDispenseEvent(
                        PoreBlock.of(event.getBlock()),
                        ItemStackConverter.of(event.getDispensedItem()),
                        VectorConverter.createBukkitVector(event.getVelocity())
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
    public void onBlockIgnite(final BlockIgniteEvent event) {
        Bukkit.getPluginManager().callEvent(
                new org.bukkit.event.block.BlockIgniteEvent(
                        PoreBlock.of(event.getBlock()),
                        null, //TODO: cause (reason); not sure if this can be implemented at the moment
                        event.getCause().isPresent() ? // check if there's a cause (presumably always true)
                                event.getCause() instanceof Entity ? // check if the cause was an entity
                                        PoreEntity.of((Entity) event.getCause().get())
                                        // get a wrapper for the entity
                                        : null // cause is not an entity
                                : null // no cause (not sure if this is possible)
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
    public void onBlockMove(final BlockMoveEvent event) {
        //TODO: covers piston and physics, cannot be implemented until Causes are ready
    }

    @Subscribe
    public void onFloraGrow(final FloraGrowEvent event) {
        Bukkit.getPluginManager().callEvent(
                new BlockGrowEvent(
                        PoreBlock.of(event.getBlock()),
                        PoreBlockState.of(event.getReplacementBlock().getState())
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
    public void onLeafDecay(final LeafDecayEvent event) {
        Bukkit.getPluginManager().callEvent(
                new BlockFadeEvent(
                        PoreBlock.of(event.getBlock()),
                        PoreBlockState.of(event.getReplacementBlock().getState())
                ) {
                    @Override
                    public void setCancelled(boolean cancelled) {
                        super.setCancelled(cancelled);
                        //TODO: find a way to cancel the event in Sponge
                    }
                }
        );
    }

}
