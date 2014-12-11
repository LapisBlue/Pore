/*
 * Pore
 * Copyright (c) 2014, Maxim Roncacé <http://bitbucket.org/mproncace>
 * Copyright (c) 2014, Lapis <https://github.com/LapisBlue>
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

import net.amigocraft.pore.impl.PoreWorld;
import net.amigocraft.pore.impl.block.PoreBlock;
import net.amigocraft.pore.impl.entity.PoreItem;
import net.amigocraft.pore.impl.entity.PorePlayer;
import net.amigocraft.pore.util.converter.ActionConverter;
import net.amigocraft.pore.util.converter.GameModeConverter;
import net.amigocraft.pore.util.converter.ItemStackConverter;
import net.amigocraft.pore.util.converter.vector.LocationConverter;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerChangedWorldEvent;
import org.bukkit.event.player.PlayerGameModeChangeEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.inventory.ItemStack;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.event.player.PlayerChangeGameModeEvent;
import org.spongepowered.api.event.player.PlayerChangeWorldEvent;
import org.spongepowered.api.event.player.PlayerChatEvent;
import org.spongepowered.api.event.player.PlayerDeathEvent;
import org.spongepowered.api.event.player.PlayerDropItemEvent;
import org.spongepowered.api.event.player.PlayerInteractEvent;
import org.spongepowered.api.event.player.PlayerJoinEvent;
import org.spongepowered.api.event.player.PlayerMoveEvent;
import org.spongepowered.api.event.player.PlayerPickUpItemEvent;
import org.spongepowered.api.event.player.PlayerQuitEvent;
import org.spongepowered.api.util.event.Subscribe;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class PlayerEventRelay {

    @Subscribe
    public void onPlayerChangeGamemode(final PlayerChangeGameModeEvent event) {
        Bukkit.getPluginManager().callEvent(
                new PlayerGameModeChangeEvent(
                        PorePlayer.of(event.getPlayer()),
                        GameModeConverter.of(event.getNewGameMode())
                )
        );
    }

    @Subscribe
    public void onPlayerChangeWorld(final PlayerChangeWorldEvent event) {
        Bukkit.getPluginManager().callEvent(
                new PlayerChangedWorldEvent(
                        PorePlayer.of(event.getPlayer()),
                        PoreWorld.of(event.getFromWorld())
                )
        );
    }

    @Subscribe
    public void onPlayerChat(final PlayerChatEvent event) {
        Set<Player> players = new HashSet<Player>(PoreWorld.of(event.getPlayer().getWorld()).getPlayers());
        Bukkit.getPluginManager().callEvent(
                new org.bukkit.event.player.AsyncPlayerChatEvent(
                        false, //TODO: determine if this needs to be changed
                        PorePlayer.of(event.getPlayer()),
                        event.getMessage(),
                        players //TODO: players should only include recipients
                ) {
                    @Override
                    public void setCancelled(boolean cancelled) {
                        super.setCancelled(cancelled);
                        //TODO: find a way to cancel the event in Sponge
                    }
                }
        );
        //TODO: possibly call PlayerChatEvent as well (not sure if Bukkit handles that itself)
    }

    @Subscribe
    public void onPlayerDeath(final PlayerDeathEvent event) {
        Bukkit.getPluginManager().callEvent(
                new org.bukkit.event.entity.PlayerDeathEvent(
                        PorePlayer.of(event.getPlayer()),
                        new ArrayList<ItemStack>(), //TODO: item drops
                        0, //TODO: exp drop
                        0, //TODO: new player xp
                        0, //TODO: new total player xp
                        0, //TODO: new player level
                        event.getDeathMessage()
                )
        );
    }

    @Subscribe
    public void onPlayerDropItem(final PlayerDropItemEvent event) {
        Bukkit.getPluginManager().callEvent(
                new org.bukkit.event.player.PlayerDropItemEvent(
                        PorePlayer.of(event.getPlayer()),
                        null
                        //TODO: Sponge returns a Collection<ItemStack> but Bukkit accepts an Item entity O.o
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
    public void onPlayerInteractEvent(final PlayerInteractEvent event) {
        Bukkit.getPluginManager().callEvent(
                new org.bukkit.event.player.PlayerInteractEvent(
                        PorePlayer.of(event.getPlayer()),
                        ActionConverter.of(event.getInteractionType(), event.getBlock()),
                        ItemStackConverter.of(event.getPlayer().getItemInHand().get()),
                        PoreBlock.of(event.getBlock()),
                        null //TODO: clicked face
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
    public void onPlayerJoin(final PlayerJoinEvent event) {
        Bukkit.getPluginManager().callEvent(
                new org.bukkit.event.player.PlayerJoinEvent(
                        PorePlayer.of(event.getPlayer()),
                        event.getJoinMessage()
                )
        );
    }

    @Subscribe
    public void onPlayerMove(final PlayerMoveEvent event) {
        Bukkit.getPluginManager().callEvent(
                new org.bukkit.event.player.PlayerMoveEvent(
                        PorePlayer.of(event.getPlayer()),
                        LocationConverter.of(event.getOldLocation()),
                        LocationConverter.of(event.getNewLocation())
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
    public void onPlayerPickUpItem(final PlayerPickUpItemEvent event) {
        for (Entity drop : event
                .getItems()) { //TODO: possibly rewrite depending on how Sponge implements the event
            if (drop instanceof org.spongepowered.api.entity.Item) {
                Bukkit.getPluginManager().callEvent(
                        new PlayerPickupItemEvent(
                                PorePlayer.of(event.getPlayer()),
                                PoreItem.of((org.spongepowered.api.entity.Item) drop),
                                0 //TODO: remaining item count
                        ) {
                            @Override
                            public void setCancelled(boolean cancelled) {
                                super.setCancelled(cancelled);
                                event.setCancelled(cancelled);
                            }
                        }
                );
            } else {
                //TODO: maybe something, not sure what though
            }
        }
    }

    @Subscribe
    public void onPlayerQuit(final PlayerQuitEvent event) {
        Bukkit.getPluginManager().callEvent(
                new org.bukkit.event.player.PlayerQuitEvent(
                        PorePlayer.of(event.getPlayer()),
                        event.getQuitMessage()
                )
        );
    }

}
