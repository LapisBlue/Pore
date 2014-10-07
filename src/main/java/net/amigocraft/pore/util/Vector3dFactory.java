package net.amigocraft.pore.util;

import org.bukkit.Location;
import org.bukkit.util.Vector;
import org.spongepowered.api.math.Vector3d;
import org.spongepowered.api.math.Vectors;

public class Vector3dFactory {

	public static Vector3d fromLocation(Location location){
		return Vectors.create3d(location.getX(), location.getY(), location.getZ());
	}

	public static Vector3d fromBukkitVector(Vector vector){
		return Vectors.create3d(vector.getX(), vector.getY(), vector.getZ());
	}

}
