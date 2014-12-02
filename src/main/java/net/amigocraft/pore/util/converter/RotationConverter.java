package net.amigocraft.pore.util.converter;

import com.google.common.collect.ImmutableMap;
import org.bukkit.Rotation;
import org.spongepowered.api.util.rotation.Rotations;

public class RotationConverter {

	private static final ImmutableMap<Rotation, org.spongepowered.api.util.rotation.Rotation> map =
			ImmutableMap.<Rotation, org.spongepowered.api.util.rotation.Rotation>builder()
					  .put(Rotation.NONE, Rotations.TOP)
					  .put(Rotation.CLOCKWISE, Rotations.RIGHT)
					  .put(Rotation.FLIPPED, Rotations.BOTTOM)
					  .put(Rotation.COUNTER_CLOCKWISE, Rotations.LEFT)
					  .build();


	private static final ImmutableMap<org.spongepowered.api.util.rotation.Rotation, Rotation> reverseMap =
			ImmutableMap.<org.spongepowered.api.util.rotation.Rotation, Rotation>builder()
					  .put(Rotations.TOP, Rotation.NONE)
					  .put(Rotations.TOP_RIGHT, Rotation.NONE)
					  .put(Rotations.RIGHT, Rotation.CLOCKWISE)
					  .put(Rotations.BOTTOM_RIGHT, Rotation.CLOCKWISE)
					  .put(Rotations.BOTTOM, Rotation.FLIPPED)
					  .put(Rotations.BOTTOM_LEFT, Rotation.FLIPPED)
					  .put(Rotations.LEFT, Rotation.COUNTER_CLOCKWISE)
					  .put(Rotations.TOP_LEFT, Rotation.COUNTER_CLOCKWISE)
					  .build();

	public static org.spongepowered.api.util.rotation.Rotation of(Rotation rotation) {
		return map.get(rotation);
	}

	public static Rotation of(org.spongepowered.api.util.rotation.Rotation rotation) {
		return reverseMap.get(rotation);
	}
}
