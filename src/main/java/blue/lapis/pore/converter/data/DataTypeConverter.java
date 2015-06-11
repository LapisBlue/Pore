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
package blue.lapis.pore.converter.data;

import com.google.common.base.Optional;
import com.google.common.collect.BiMap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.spongepowered.api.data.manipulator.SingleValueData;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public abstract class DataTypeConverter {

    @SuppressWarnings("rawtypes")
    protected final LinkedHashMap<BiMap<AbstractDataValue, Byte>, Byte> converters
            = new LinkedHashMap<BiMap<AbstractDataValue, Byte>, Byte>();

    protected final ArrayList<Class<? extends SingleValueData<?, ?>>> applicableTypes = Lists.newArrayList();

    public Collection<Class<? extends SingleValueData<?, ?>>> getApplicableDataTypes() {
        return applicableTypes;
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    public byte of(Collection<SingleValueData<?, ?>> data) {
        HashMap<String, SingleValueData> dataMap = Maps.newHashMap();
        for (SingleValueData datum : data) {
            dataMap.put(datum.getClass().getName().split("\\$")[0], datum);
        }
        BiMap<AbstractDataValue, Byte>[] biMapList = new BiMap[converters.size()];
        converters.keySet().toArray(biMapList);
        Byte[] bitSetSizes = new Byte[converters.size()];
        converters.values().toArray(bitSetSizes);
        byte finalValue = 0;
        byte bitOffset = 0;
        for (int i = 0; i < applicableTypes.size(); i++) {
            byte bitsToConsider = bitSetSizes[i];
            assert bitOffset + bitsToConsider <= 8;
            if (dataMap.containsKey(applicableTypes.get(i).getName())) {
                SingleValueData datum = dataMap.get(applicableTypes.get(i).getName());
                BiMap<AbstractDataValue, Byte> bm = biMapList[i];
                AbstractDataValue adv = AbstractDataValue.of(datum);
                finalValue |= bm.containsKey(adv) ? bm.get(adv) << bitOffset : 0; // mask the value onto the data byte
            }
            bitOffset += bitsToConsider;
        }
        return finalValue;
    }

    @SuppressWarnings("rawtypes") // I am very tired and do not feel like dealing with generics anymore
    public Collection<AbstractDataValue> of(byte data) throws IllegalArgumentException {
        ArrayList<AbstractDataValue> converted = new ArrayList<AbstractDataValue>();
        int i = 0;
        for (Map.Entry<BiMap<AbstractDataValue, Byte>, Byte> e : converters.entrySet()) {
            BiMap<AbstractDataValue, Byte> c = e.getKey();
            int bitsToConsider = e.getValue(); // the number of bits to consider from the data byte
            assert i + bitsToConsider <= 8; // we can't consider more than 8 bits within a single byte
            byte masked = data;
            masked >>= i; // right-shift to discard bits considered in previous iterations
            byte mask = (byte)(Math.pow(2, bitsToConsider) - 1); // calculate the bitmask based on the size
            masked &= mask; // apply the mask
            if (!c.containsValue(masked)) {
                throw new IllegalArgumentException("Out of bounds data byte" + data + " for "
                        + this.getClass().getSimpleName());
            }
            converted.add(c.inverse().get(masked));
            i += bitsToConsider; // increment the offset for future iterations
        }
        return converted;
    }

}
