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
package net.amigocraft.pore.util.converter;

import net.amigocraft.pore.impl.PoreChunk;
import net.amigocraft.pore.impl.PoreOfflinePlayer;
import net.amigocraft.pore.impl.PoreWorld;
import net.amigocraft.pore.impl.entity.PoreAgeable;
import net.amigocraft.pore.impl.entity.PoreAmbient;
import net.amigocraft.pore.impl.entity.PoreAnimalTamer;
import net.amigocraft.pore.impl.entity.PoreAnimals;
import net.amigocraft.pore.impl.entity.PoreArmorStand;
import net.amigocraft.pore.impl.entity.PoreArrow;
import net.amigocraft.pore.impl.entity.PoreBat;
import net.amigocraft.pore.impl.entity.PoreBlaze;
import net.amigocraft.pore.impl.entity.PoreBoat;
import net.amigocraft.pore.impl.entity.PoreCaveSpider;
import net.amigocraft.pore.impl.entity.PoreChicken;
import net.amigocraft.pore.impl.entity.PoreComplexEntityPart;
import net.amigocraft.pore.impl.entity.PoreComplexLivingEntity;
import net.amigocraft.pore.impl.entity.PoreCow;
import net.amigocraft.pore.impl.entity.PoreCreature;
import net.amigocraft.pore.impl.entity.PoreCreeper;
import net.amigocraft.pore.impl.entity.PoreEgg;
import net.amigocraft.pore.impl.entity.PoreEnderCrystal;
import net.amigocraft.pore.impl.entity.PoreEnderDragon;
import net.amigocraft.pore.impl.entity.PoreEnderDragonPart;
import net.amigocraft.pore.impl.entity.PoreEnderPearl;
import net.amigocraft.pore.impl.entity.PoreEnderSignal;
import net.amigocraft.pore.impl.entity.PoreEnderman;
import net.amigocraft.pore.impl.entity.PoreEndermite;
import net.amigocraft.pore.impl.entity.PoreEntity;
import net.amigocraft.pore.impl.entity.PoreExperienceOrb;
import net.amigocraft.pore.impl.entity.PoreFallingSand;
import net.amigocraft.pore.impl.entity.PoreFireball;
import net.amigocraft.pore.impl.entity.PoreFirework;
import net.amigocraft.pore.impl.entity.PoreFish;
import net.amigocraft.pore.impl.entity.PoreFlying;
import net.amigocraft.pore.impl.entity.PoreGhast;
import net.amigocraft.pore.impl.entity.PoreGiant;
import net.amigocraft.pore.impl.entity.PoreGolem;
import net.amigocraft.pore.impl.entity.PoreGuardian;
import net.amigocraft.pore.impl.entity.PoreHanging;
import net.amigocraft.pore.impl.entity.PoreHorse;
import net.amigocraft.pore.impl.entity.PoreHumanEntity;
import net.amigocraft.pore.impl.entity.PoreIronGolem;
import net.amigocraft.pore.impl.entity.PoreItem;
import net.amigocraft.pore.impl.entity.PoreItemFrame;
import net.amigocraft.pore.impl.entity.PoreLargeFireball;
import net.amigocraft.pore.impl.entity.PoreLeashHitch;
import net.amigocraft.pore.impl.entity.PoreLightningStrike;
import net.amigocraft.pore.impl.entity.PoreLivingEntity;
import net.amigocraft.pore.impl.entity.PoreMagmaCube;
import net.amigocraft.pore.impl.entity.PoreMonster;
import net.amigocraft.pore.impl.entity.PoreMushroomCow;
import net.amigocraft.pore.impl.entity.PoreOcelot;
import net.amigocraft.pore.impl.entity.PorePainting;
import net.amigocraft.pore.impl.entity.PorePig;
import net.amigocraft.pore.impl.entity.PorePigZombie;
import net.amigocraft.pore.impl.entity.PorePlayer;
import net.amigocraft.pore.impl.entity.PoreProjectile;
import net.amigocraft.pore.impl.entity.PoreRabbit;
import net.amigocraft.pore.impl.entity.PoreSheep;
import net.amigocraft.pore.impl.entity.PoreSilverfish;
import net.amigocraft.pore.impl.entity.PoreSkeleton;
import net.amigocraft.pore.impl.entity.PoreSlime;
import net.amigocraft.pore.impl.entity.PoreSmallFireball;
import net.amigocraft.pore.impl.entity.PoreSnowball;
import net.amigocraft.pore.impl.entity.PoreSnowman;
import net.amigocraft.pore.impl.entity.PoreSpider;
import net.amigocraft.pore.impl.entity.PoreSquid;
import net.amigocraft.pore.impl.entity.PoreTNTPrimed;
import net.amigocraft.pore.impl.entity.PoreTameable;
import net.amigocraft.pore.impl.entity.PoreThrownExpBottle;
import net.amigocraft.pore.impl.entity.PoreThrownPotion;
import net.amigocraft.pore.impl.entity.PoreVillager;
import net.amigocraft.pore.impl.entity.PoreWaterMob;
import net.amigocraft.pore.impl.entity.PoreWeather;
import net.amigocraft.pore.impl.entity.PoreWitch;
import net.amigocraft.pore.impl.entity.PoreWither;
import net.amigocraft.pore.impl.entity.PoreWitherSkull;
import net.amigocraft.pore.impl.entity.PoreWolf;
import net.amigocraft.pore.impl.entity.PoreZombie;
import net.amigocraft.pore.impl.entity.minecart.PoreCommandMinecart;
import net.amigocraft.pore.impl.entity.minecart.PoreExplosiveMinecart;
import net.amigocraft.pore.impl.entity.minecart.PoreHopperMinecart;
import net.amigocraft.pore.impl.entity.minecart.PoreMinecart;
import net.amigocraft.pore.impl.entity.minecart.PorePoweredMinecart;
import net.amigocraft.pore.impl.entity.minecart.PoreRideableMinecart;
import net.amigocraft.pore.impl.entity.minecart.PoreSpawnerMinecart;
import net.amigocraft.pore.impl.entity.minecart.PoreStorageMinecart;
import net.amigocraft.pore.util.PoreWrapper;
import org.spongepowered.api.entity.EnderCrystal;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.entity.ExperienceOrb;
import org.spongepowered.api.entity.FallingBlock;
import org.spongepowered.api.entity.Item;
import org.spongepowered.api.entity.Tamer;
import org.spongepowered.api.entity.explosive.PrimedTNT;
import org.spongepowered.api.entity.hanging.Hanging;
import org.spongepowered.api.entity.hanging.ItemFrame;
import org.spongepowered.api.entity.hanging.LeashHitch;
import org.spongepowered.api.entity.hanging.Painting;
import org.spongepowered.api.entity.living.Aerial;
import org.spongepowered.api.entity.living.Ageable;
import org.spongepowered.api.entity.living.Agent;
import org.spongepowered.api.entity.living.Ambient;
import org.spongepowered.api.entity.living.Aquatic;
import org.spongepowered.api.entity.living.ArmorStand;
import org.spongepowered.api.entity.living.Bat;
import org.spongepowered.api.entity.living.Human;
import org.spongepowered.api.entity.living.Living;
import org.spongepowered.api.entity.living.Tameable;
import org.spongepowered.api.entity.living.animal.Animal;
import org.spongepowered.api.entity.living.animal.Chicken;
import org.spongepowered.api.entity.living.animal.Cow;
import org.spongepowered.api.entity.living.animal.Horse;
import org.spongepowered.api.entity.living.animal.Mooshroom;
import org.spongepowered.api.entity.living.animal.Ocelot;
import org.spongepowered.api.entity.living.animal.Pig;
import org.spongepowered.api.entity.living.animal.Rabbit;
import org.spongepowered.api.entity.living.animal.Sheep;
import org.spongepowered.api.entity.living.animal.Squid;
import org.spongepowered.api.entity.living.animal.Wolf;
import org.spongepowered.api.entity.living.complex.ComplexLiving;
import org.spongepowered.api.entity.living.complex.ComplexLivingPart;
import org.spongepowered.api.entity.living.complex.EnderDragon;
import org.spongepowered.api.entity.living.complex.EnderDragonPart;
import org.spongepowered.api.entity.living.golem.Golem;
import org.spongepowered.api.entity.living.golem.IronGolem;
import org.spongepowered.api.entity.living.golem.SnowGolem;
import org.spongepowered.api.entity.living.monster.Blaze;
import org.spongepowered.api.entity.living.monster.CaveSpider;
import org.spongepowered.api.entity.living.monster.Creeper;
import org.spongepowered.api.entity.living.monster.Enderman;
import org.spongepowered.api.entity.living.monster.Endermite;
import org.spongepowered.api.entity.living.monster.Ghast;
import org.spongepowered.api.entity.living.monster.Giant;
import org.spongepowered.api.entity.living.monster.Guardian;
import org.spongepowered.api.entity.living.monster.MagmaCube;
import org.spongepowered.api.entity.living.monster.Monster;
import org.spongepowered.api.entity.living.monster.Silverfish;
import org.spongepowered.api.entity.living.monster.Skeleton;
import org.spongepowered.api.entity.living.monster.Slime;
import org.spongepowered.api.entity.living.monster.Spider;
import org.spongepowered.api.entity.living.monster.Witch;
import org.spongepowered.api.entity.living.monster.Wither;
import org.spongepowered.api.entity.living.monster.Zombie;
import org.spongepowered.api.entity.living.monster.ZombiePigman;
import org.spongepowered.api.entity.living.villager.Villager;
import org.spongepowered.api.entity.player.Player;
import org.spongepowered.api.entity.player.User;
import org.spongepowered.api.entity.projectile.Arrow;
import org.spongepowered.api.entity.projectile.Egg;
import org.spongepowered.api.entity.projectile.EnderPearl;
import org.spongepowered.api.entity.projectile.EyeOfEnder;
import org.spongepowered.api.entity.projectile.Firework;
import org.spongepowered.api.entity.projectile.FishHook;
import org.spongepowered.api.entity.projectile.Projectile;
import org.spongepowered.api.entity.projectile.Snowball;
import org.spongepowered.api.entity.projectile.ThrownExpBottle;
import org.spongepowered.api.entity.projectile.ThrownPotion;
import org.spongepowered.api.entity.projectile.fireball.Fireball;
import org.spongepowered.api.entity.projectile.fireball.LargeFireball;
import org.spongepowered.api.entity.projectile.fireball.SmallFireball;
import org.spongepowered.api.entity.projectile.fireball.WitherSkull;
import org.spongepowered.api.entity.vehicle.Boat;
import org.spongepowered.api.entity.vehicle.minecart.Minecart;
import org.spongepowered.api.entity.vehicle.minecart.MinecartChest;
import org.spongepowered.api.entity.vehicle.minecart.MinecartCommandBlock;
import org.spongepowered.api.entity.vehicle.minecart.MinecartFurnace;
import org.spongepowered.api.entity.vehicle.minecart.MinecartHopper;
import org.spongepowered.api.entity.vehicle.minecart.MinecartMobSpawner;
import org.spongepowered.api.entity.vehicle.minecart.MinecartRideable;
import org.spongepowered.api.entity.vehicle.minecart.MinecartTNT;
import org.spongepowered.api.entity.weather.Lightning;
import org.spongepowered.api.entity.weather.WeatherEffect;
import org.spongepowered.api.world.Chunk;
import org.spongepowered.api.world.World;

public class PoreConverter {

    private static final CachedConverter<PoreWrapper> converter = CachedConverter.builder(PoreWrapper.class)

            // Entities
            .register(Entity.class, PoreEntity.class)
                .register(Living.class, PoreLivingEntity.class)
                    .register(Human.class, PoreHumanEntity.class)
                        .register(Player.class, PorePlayer.class)
                    .register(Agent.class, PoreCreature.class)
                        .register(Ageable.class, PoreAgeable.class)
                            .register(Animal.class, PoreAnimals.class)
                                .register(Chicken.class, PoreChicken.class)
                                .register(Cow.class, PoreCow.class)
                                    .register(Mooshroom.class, PoreMushroomCow.class)
                                .register(Pig.class, PorePig.class)
                                .register(Rabbit.class, PoreRabbit.class)
                                .register(Sheep.class, PoreSheep.class)
                                .register(Tameable.class, PoreTameable.class)
                                    .register(Horse.class, PoreHorse.class)
                                    .register(Ocelot.class, PoreOcelot.class)
                                    .register(Wolf.class, PoreWolf.class)
                            .register(Villager.class, PoreVillager.class)
                        .register(Monster.class, PoreMonster.class)
                            .register(Blaze.class, PoreBlaze.class)
                            .register(Creeper.class, PoreCreeper.class)
                            .register(Enderman.class, PoreEnderman.class)
                            .register(Endermite.class, PoreEndermite.class)
                            .register(Giant.class, PoreGiant.class)
                            .register(Guardian.class, PoreGuardian.class)
                            .register(Silverfish.class, PoreSilverfish.class)
                            .register(Skeleton.class, PoreSkeleton.class)
                            .register(Spider.class, PoreSpider.class)
                                .register(CaveSpider.class, PoreCaveSpider.class)
                            .register(Witch.class, PoreWitch.class)
                            .register(Wither.class, PoreWither.class)
                            .register(Zombie.class, PoreZombie.class)
                                .register(ZombiePigman.class, PorePigZombie.class)
                        .register(Golem.class, PoreGolem.class)
                            .register(IronGolem.class, PoreIronGolem.class)
                            .register(SnowGolem.class, PoreSnowman.class)
                        .register(Aquatic.class, PoreWaterMob.class)
                            .register(Squid.class, PoreSquid.class)
                    .register(Ambient.class, PoreAmbient.class)
                        .register(Bat.class, PoreBat.class)
                    .register(ArmorStand.class, PoreArmorStand.class)
                    .register(ComplexLiving.class, PoreComplexLivingEntity.class)
                        .register(EnderDragon.class, PoreEnderDragon.class)
                    .register(Aerial.class, PoreFlying.class)
                        .register(Ghast.class, PoreGhast.class)
                    .register(Slime.class, PoreSlime.class)
                        .register(MagmaCube.class, PoreMagmaCube.class)
                .register(ComplexLivingPart.class, PoreComplexEntityPart.class)
                    .register(EnderDragonPart.class, PoreEnderDragonPart.class)
                .register(EnderCrystal.class, PoreEnderCrystal.class)
                .register(EyeOfEnder.class, PoreEnderSignal.class)
                .register(ExperienceOrb.class, PoreExperienceOrb.class)
                .register(FallingBlock.class, PoreFallingSand.class)
                .register(Firework.class, PoreFirework.class)
                .register(Hanging.class, PoreHanging.class)
                    .register(ItemFrame.class, PoreItemFrame.class)
                    .register(LeashHitch.class, PoreLeashHitch.class)
                    .register(Painting.class, PorePainting.class)
                .register(Item.class, PoreItem.class)
                .register(Lightning.class, PoreLightningStrike.class)
                .register(Projectile.class, PoreProjectile.class)
                    .register(Arrow.class, PoreArrow.class)
                    .register(Egg.class, PoreEgg.class)
                    .register(EnderPearl.class, PoreEnderPearl.class)
                    .register(Fireball.class, PoreFireball.class)
                        .register(LargeFireball.class, PoreLargeFireball.class)
                        .register(SmallFireball.class, PoreSmallFireball.class)
                        .register(WitherSkull.class, PoreWitherSkull.class)
                    .register(FishHook.class, PoreFish.class)
                    .register(Snowball.class, PoreSnowball.class)
                    .register(ThrownExpBottle.class, PoreThrownExpBottle.class)
                    .register(ThrownPotion.class, PoreThrownPotion.class)
                .register(PrimedTNT.class, PoreTNTPrimed.class)
                .register(WeatherEffect.class, PoreWeather.class)
                .register(Minecart.class, PoreMinecart.class)
                    .register(MinecartChest.class, PoreStorageMinecart.class)
                    .register(MinecartCommandBlock.class, PoreCommandMinecart.class)
                    .register(MinecartFurnace.class, PorePoweredMinecart.class)
                    .register(MinecartHopper.class, PoreHopperMinecart.class)
                    .register(MinecartMobSpawner.class, PoreSpawnerMinecart.class)
                    .register(MinecartRideable.class, PoreRideableMinecart.class)
                    .register(MinecartTNT.class, PoreExplosiveMinecart.class)
                .register(Boat.class, PoreBoat.class)

            .register(Tamer.class, PoreAnimalTamer.class)

            .register(Chunk.class, PoreChunk.class)
            .register(User.class, PoreOfflinePlayer.class)
            .register(World.class, PoreWorld.class)

            .build();

    public static <P extends PoreWrapper<?>> P of(Object handle) {
        return converter.get(handle);
    }

    public static <P extends PoreWrapper<?>> P of(Class<P> type, Object handle) {
        return converter.get(type, handle);
    }
}
