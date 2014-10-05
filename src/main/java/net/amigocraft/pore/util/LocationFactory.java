package net.amigocraft.pore.util;

import net.amigocraft.pore.implementation.PoreWorld;
import org.bukkit.Location;
import org.spongepowered.api.math.Vector3d;
import org.spongepowered.api.math.Vector3f;
import org.spongepowered.api.math.Vector3i;
import org.spongepowered.api.world.World;

public class LocationFactory {

	public static Location fromVector3i(World world, Vector3i locationVector){
		return new Location(PoreWorld.of(world), locationVector.getX(), locationVector.getY(), locationVector.getZ());
	}

	public static Location fromVector3d(World world, Vector3d locationVector){
		return new Location(PoreWorld.of(world), locationVector.getX(), locationVector.getY(), locationVector.getZ());
	}

	public static Location fromVector3f(World world, Vector3f locationVector){
		return new Location(PoreWorld.of(world), locationVector.getX(), locationVector.getY(), locationVector.getZ());
	}

	//TODO: should EulerDirection be used instead of Vector3f?
	public static Location fromVector3iWithRotation(World world, Vector3i locationVector, Vector3f rotationVector){
		return new Location(PoreWorld.of(world), locationVector.getX(), locationVector.getY(), locationVector.getZ(),
				rotationVector.getY(), rotationVector.getX());
	}

	public static Location fromVector3dwithRotation(World world, Vector3d locationVector, Vector3f rotationVector){
		return new Location(PoreWorld.of(world), locationVector.getX(), locationVector.getY(), locationVector.getZ(),
				rotationVector.getY(), rotationVector.getX());
	}

	public static Location fromVector3fwithRotation(World world, Vector3f locationVector, Vector3f rotationVector){
		return new Location(PoreWorld.of(world), locationVector.getX(), locationVector.getY(), locationVector.getZ(),
				rotationVector.getY(), rotationVector.getX());
	}

}
