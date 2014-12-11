package net.amigocraft.pore.util.converter;

import org.bukkit.event.block.Action;
import org.spongepowered.api.block.BlockLoc;
import org.spongepowered.api.entity.EntityInteractionType;

public class ActionConverter {

    public static Action of(EntityInteractionType type, BlockLoc clicked){
        if (type == EntityInteractionType.LEFT_CLICK){
            return clicked == null ? Action.LEFT_CLICK_AIR : Action.LEFT_CLICK_BLOCK;
        }
        else if (type == EntityInteractionType.RIGHT_CLICK){
            return clicked == null ? Action.RIGHT_CLICK_AIR : Action.RIGHT_CLICK_BLOCK;
        }
        //TODO: do something about EnitityInteractionType.MIDDLE_CLICK
        return null;
    }

    public static EntityInteractionType of(Action action){
        if (action == Action.LEFT_CLICK_AIR){
            return EntityInteractionType.LEFT_CLICK;
        }
        else if (action == Action.LEFT_CLICK_BLOCK){
            return EntityInteractionType.LEFT_CLICK;
        }
        else if (action == Action.RIGHT_CLICK_AIR){
            return EntityInteractionType.RIGHT_CLICK;
        }
        else if (action == Action.RIGHT_CLICK_BLOCK){
            return EntityInteractionType.RIGHT_CLICK;
        }
        //TODO: do somethinb about Action.PHYSICAL
        return null;
    }

}
