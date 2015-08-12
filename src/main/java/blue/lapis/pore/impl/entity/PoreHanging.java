/*
 * Pore
 * Copyright (c) 2014-2015, Lapis <https://github.com/LapisBlue>
 *
 * The MIT License
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
package blue.lapis.pore.impl.entity;

import blue.lapis.pore.converter.type.world.DirectionConverter;
import blue.lapis.pore.converter.wrapper.WrapperConverter;

import org.bukkit.block.BlockFace;
import org.spongepowered.api.data.DataTransactionResult;
import org.spongepowered.api.data.key.Keys;
import org.spongepowered.api.entity.hanging.Hanging;

public class PoreHanging extends PoreEntity implements org.bukkit.entity.Hanging {

    public static PoreHanging of(Hanging handle) {
        return WrapperConverter.of(PoreHanging.class, handle);
    }

    protected PoreHanging(Hanging handle) {
        super(handle);
    }

    @Override
    public Hanging getHandle() {
        return (Hanging) super.getHandle();
    }

    @Override
    public BlockFace getFacing() {
        return DirectionConverter.of(getHandle().get(Keys.DIRECTION).get());
    }

    @Override
    public boolean setFacingDirection(BlockFace face, boolean force) {
        return getHandle().offer(Keys.DIRECTION, DirectionConverter.of(face))
                .getType() == DataTransactionResult.Type.SUCCESS;
    }

    @Override
    public void setFacingDirection(BlockFace face) {
        setFacingDirection(face, false);
    }

    @Override
    public BlockFace getAttachedFace() {
        return getFacing().getOppositeFace();
    }

}
