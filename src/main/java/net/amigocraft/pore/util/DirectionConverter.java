package net.amigocraft.pore.util;

import org.bukkit.block.BlockFace;
import org.spongepowered.api.util.Direction;

public class DirectionConverter {

	public static BlockFace toBlockFace(Direction dir){

		switch (dir){
			case DOWN:
				return BlockFace.DOWN;
			case UP:
				return BlockFace.UP;
			case NORTH:
				return BlockFace.NORTH;
			case NORTH_NORTHEAST:
				return BlockFace.NORTH_NORTH_EAST;
			case NORTHEAST:
				return BlockFace.NORTH_EAST;
			case EAST_NORTHEAST:
				return BlockFace.EAST_NORTH_EAST;
			case EAST:
				return BlockFace.EAST;
			case EAST_SOUTHEAST:
				return BlockFace.EAST_SOUTH_EAST;
			case SOUTHEAST:
				return BlockFace.SOUTH_EAST;
			case SOUTH_SOUTHEAST:
				return BlockFace.SOUTH_SOUTH_EAST;
			case SOUTH:
				return BlockFace.SOUTH;
			case SOUTH_SOUTHWEST:
				return BlockFace.SOUTH_SOUTH_WEST;
			case SOUTHWEST:
				return BlockFace.SOUTH_WEST;
			case WEST_SOUTHWEST:
				return BlockFace.WEST_SOUTH_WEST;
			case WEST:
				return BlockFace.WEST;
			case WEST_NORTHWEST:
				return BlockFace.WEST_NORTH_WEST;
			case NORTHWEST:
				return BlockFace.NORTH_WEST;
			case NORTH_NORTHWEST:
				return BlockFace.NORTH_NORTH_WEST;
		}

		return null;
	}

	public static Direction toDirection(BlockFace face){
		switch (face) {
			case DOWN:
				return Direction.DOWN;
			case UP:
				return Direction.UP;
			case NORTH:
				return Direction.NORTH;
			case NORTH_NORTH_EAST:
				return Direction.NORTH_NORTHEAST;
			case NORTH_EAST:
				return Direction.NORTHEAST;
			case EAST_NORTH_EAST:
				return Direction.EAST_NORTHEAST;
			case EAST:
				return Direction.EAST;
			case EAST_SOUTH_EAST:
				return Direction.EAST_SOUTHEAST;
			case SOUTH_EAST:
				return Direction.SOUTHEAST;
			case SOUTH_SOUTH_EAST:
				return Direction.SOUTH_SOUTHEAST;
			case SOUTH:
				return Direction.SOUTH;
			case SOUTH_SOUTH_WEST:
				return Direction.SOUTH_SOUTHWEST;
			case SOUTH_WEST:
				return Direction.SOUTHWEST;
			case WEST_SOUTH_WEST:
				return Direction.WEST_SOUTHWEST;
			case WEST:
				return Direction.WEST;
			case WEST_NORTH_WEST:
				return Direction.WEST_NORTHWEST;
			case NORTH_WEST:
				return Direction.NORTHWEST;
			case NORTH_NORTH_WEST:
				return Direction.NORTH_NORTHWEST;
		}

		return null;
	}

}
