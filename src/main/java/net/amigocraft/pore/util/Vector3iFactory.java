package net.amigocraft.pore.util;

import org.bukkit.Location;
import org.bukkit.util.Vector;
import org.spongepowered.api.math.Vector3i;
import org.spongepowered.api.math.Vectors;

public class Vector3iFactory {

	public static Vector3i fromLocation(Location location){
		return Vectors.create3i((int)location.getX(), (int)location.getY(), (int)location.getZ());
	}

	public static Vector3i fromBukkitVector(Vector vector){
		return Vectors.create3i(vector.getBlockX(), vector.getBlockY(), vector.getBlockZ());
	}

}
