package net.amigocraft.pore.util;

import org.bukkit.util.Vector;
import org.spongepowered.api.math.Vector3d;
import org.spongepowered.api.math.Vector3f;
import org.spongepowered.api.math.Vector3i;

public class BukkitVectorFactory {

	public static Vector fromVector3i(Vector3i vector){
		return new Vector(vector.getX(), vector.getY(), vector.getZ());
	}

	public static Vector fromVector3d(Vector3d vector){
		return new Vector(vector.getX(), vector.getY(), vector.getZ());
	}

	public static Vector fromVector3f(Vector3f vector){
		return new Vector(vector.getX(), vector.getY(), vector.getZ());
	}

}
