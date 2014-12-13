/*
 * Pore
 * Copyright (c) 2014, Lapis <https://github.com/LapisBlue>
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package net.amigocraft.pore.util.converter;

import org.bukkit.event.block.Action;
import org.spongepowered.api.block.BlockLoc;
import org.spongepowered.api.entity.EntityInteractionType;

public class ActionConverter {

    public static Action of(EntityInteractionType type, BlockLoc clicked) {
        if (type == EntityInteractionType.LEFT_CLICK) {
            return clicked == null ? Action.LEFT_CLICK_AIR : Action.LEFT_CLICK_BLOCK;
        } else if (type == EntityInteractionType.RIGHT_CLICK) {
            return clicked == null ? Action.RIGHT_CLICK_AIR : Action.RIGHT_CLICK_BLOCK;
        }
        //TODO: do something about EnitityInteractionType.MIDDLE_CLICK
        return null;
    }

    public static EntityInteractionType of(Action action) {
        if (action == Action.LEFT_CLICK_AIR) {
            return EntityInteractionType.LEFT_CLICK;
        } else if (action == Action.LEFT_CLICK_BLOCK) {
            return EntityInteractionType.LEFT_CLICK;
        } else if (action == Action.RIGHT_CLICK_AIR) {
            return EntityInteractionType.RIGHT_CLICK;
        } else if (action == Action.RIGHT_CLICK_BLOCK) {
            return EntityInteractionType.RIGHT_CLICK;
        }
        //TODO: do somethinb about Action.PHYSICAL
        return null;
    }

}
