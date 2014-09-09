package net.amigocraft.pore.implementation.entity;

import org.bukkit.block.BlockFace;
import org.bukkit.entity.Hanging;

public class PoreHanging extends PoreEntity implements Hanging {
    // TODO: Bridge
    @Override
    public boolean setFacingDirection(BlockFace face, boolean force) {
        return false;
    }

    @Override
    public BlockFace getAttachedFace() {
        return null;
    }

    @Override
    public void setFacingDirection(BlockFace face) {

    }

    @Override
    public BlockFace getFacing() {
        return null;
    }
}
