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

import blue.lapis.pore.util.converter.PoreConverter;
import blue.lapis.pore.Pore;
import blue.lapis.pore.util.converter.entity.ProfessionConverter;
import org.bukkit.entity.EntityType;
import org.spongepowered.api.entity.living.villager.Villager;

public class PoreVillager extends PoreAgeable implements org.bukkit.entity.Villager {

    public static PoreVillager of(Villager handle) {
        return PoreConverter.of(PoreVillager.class, handle);
    }

    protected PoreVillager(Villager handle) {
        super(handle);
    }

    @Override
    public Villager getHandle() {
        return (Villager) super.getHandle();
    }

    @Override
    public EntityType getType() {
        return EntityType.VILLAGER;
    }

    @Override
    public Profession getProfession() {
        return ProfessionConverter.of(getHandle().getCareer().getProfession());
    }

    @Override
    public void setProfession(Profession profession) {
        //TODO: not really sure what to do here
        getHandle().setCareer(
                Pore.getGame().getRegistry().getCareers(ProfessionConverter.of(profession)).get(0));
    }
}
