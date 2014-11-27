package net.amigocraft.pore.util;

import net.amigocraft.pore.implementation.entity.PoreFireball;
import net.amigocraft.pore.util.converter.vector.Vector3fFactory;
import org.bukkit.entity.*;
import org.bukkit.util.Vector;
import org.spongepowered.api.entity.projectile.source.ProjectileSource;

public class ProjectileUtil {

	@SuppressWarnings("unchecked")
	public static <T extends Projectile> T
	launchProjectile(ProjectileSource source, Class<? extends T> projectile, Vector velocity){
		if (projectile.isAssignableFrom(Arrow.class)){
			return (T)PoreFireball.of(source.launchProjectile(
					org.spongepowered.api.entity.projectile.Arrow.class,
					Vector3fFactory.fromBukkitVector(velocity)
			));
		}
		else if (projectile.isAssignableFrom(Egg.class)){
			return (T)PoreFireball.of(source.launchProjectile(
					org.spongepowered.api.entity.projectile.Egg.class,
					Vector3fFactory.fromBukkitVector(velocity)
			));
		}
		else if (projectile.isAssignableFrom(EnderPearl.class)){
			return (T)PoreFireball.of(source.launchProjectile(
					org.spongepowered.api.entity.projectile.EnderPearl.class,
					Vector3fFactory.fromBukkitVector(velocity)
			));
		}
		else if (projectile.isAssignableFrom(Fireball.class)){
			if (projectile.isAssignableFrom(LargeFireball.class)) {
				return (T)PoreFireball.of(source.launchProjectile(
						org.spongepowered.api.entity.projectile.fireball.LargeFireball.class,
						Vector3fFactory.fromBukkitVector(velocity)
				));
			}
			else if (projectile.isAssignableFrom(LargeFireball.class)) {
				return (T)PoreFireball.of(source.launchProjectile(
						org.spongepowered.api.entity.projectile.fireball.SmallFireball.class,
						Vector3fFactory.fromBukkitVector(velocity)
				));
			}
			else if (projectile.isAssignableFrom(LargeFireball.class)) {
				return (T)PoreFireball.of(source.launchProjectile(
						org.spongepowered.api.entity.projectile.fireball.WitherSkull.class,
						Vector3fFactory.fromBukkitVector(velocity)
				));
			}
			else {
				return (T)PoreFireball.of(source.launchProjectile(
								org.spongepowered.api.entity.projectile.fireball.Fireball.class,
								Vector3fFactory.fromBukkitVector(velocity)
				));
			}
		}
		else if (projectile.isAssignableFrom(Fish.class)){
			return (T)PoreFireball.of(source.launchProjectile(
					org.spongepowered.api.entity.projectile.FishHook.class,
					Vector3fFactory.fromBukkitVector(velocity)
			));
		}
		else if (projectile.isAssignableFrom(Snowball.class)){
			return (T)PoreFireball.of(source.launchProjectile(
					org.spongepowered.api.entity.projectile.Snowball.class,
					Vector3fFactory.fromBukkitVector(velocity)
			));
		}
		else if (projectile.isAssignableFrom(ThrownExpBottle.class)){
			return (T)PoreFireball.of(source.launchProjectile(
					org.spongepowered.api.entity.projectile.ThrownExpBottle.class,
					Vector3fFactory.fromBukkitVector(velocity)
			));
		}
		else if (projectile.isAssignableFrom(ThrownPotion.class)){
			return (T)PoreFireball.of(source.launchProjectile(
					org.spongepowered.api.entity.projectile.ThrownPotion.class,
					Vector3fFactory.fromBukkitVector(velocity)
			));
		}
		throw new UnsupportedOperationException();
	}

}
