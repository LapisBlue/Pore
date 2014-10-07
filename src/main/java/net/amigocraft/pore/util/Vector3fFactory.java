package net.amigocraft.pore.util;

import org.bukkit.Location;
import org.bukkit.util.Vector;
import org.spongepowered.api.math.Vector3f;
import org.spongepowered.api.math.Vectors;

public class Vector3fFactory {

	public static Vector3f fromLocation(Location location){
		return Vectors.create3f((float)location.getX(), (float)location.getY(), (float)location.getZ());
	}

	public static Vector3f fromBukkitVector(Vector vector){
		return Vectors.create3f((float)vector.getX(), (float)vector.getY(), (float)vector.getZ());
	}

}
