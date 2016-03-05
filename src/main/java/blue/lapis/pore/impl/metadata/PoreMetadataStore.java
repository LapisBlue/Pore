/*
 * Pore
 * Copyright (c) 2014-2016, Lapis <https://github.com/LapisBlue>
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

package blue.lapis.pore.impl.metadata;

import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.metadata.MetadataStore;
import org.bukkit.metadata.MetadataStoreBase;

public class PoreMetadataStore<T> extends MetadataStoreBase<T> implements MetadataStore<T> {

    @Override
    protected String disambiguate(T subject, String metadataKey) {
        Class<?> clazz = subject.getClass();
        if (Block.class.isAssignableFrom(clazz)) {
            Block b = (Block) subject;
            return b.getX() + ":" + b.getY() + ':' + b.getZ() + ':' + metadataKey;
        } else if (Player.class.isAssignableFrom(clazz)) {
            Player p = (Player) subject;
            return p.getName().toLowerCase() + ':' + metadataKey;
        } else if (Entity.class.isAssignableFrom(clazz)) {
            Entity e = (Entity) subject;
            return e.getUniqueId() + ":" + metadataKey;
        } else if (World.class.isAssignableFrom(clazz)) {
            World w = (World) subject;
            return w.getUID() + ":" + metadataKey;
        } else {
            return subject + ":" + metadataKey;
        }
    }


}
