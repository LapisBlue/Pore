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

import blue.lapis.pore.converter.type.material.ItemStackConverter;
import blue.lapis.pore.converter.vector.EulerAngleConverter;
import blue.lapis.pore.converter.wrapper.WrapperConverter;

import org.bukkit.entity.EntityType;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.EulerAngle;
import org.spongepowered.api.data.manipulators.entities.BodyPartRotationalData;
import org.spongepowered.api.data.manipulators.entities.InvisibilityData;
import org.spongepowered.api.entity.living.ArmorStand;

public class PoreArmorStand extends PoreLivingEntity implements org.bukkit.entity.ArmorStand {

    public static PoreArmorStand of(ArmorStand handle) {
        return WrapperConverter.of(PoreArmorStand.class, handle);
    }

    protected PoreArmorStand(ArmorStand handle) {
        super(handle);
    }

    @Override
    public ArmorStand getHandle() {
        return (ArmorStand) super.getHandle();
    }

    @Override
    public EntityType getType() {
        return EntityType.ARMOR_STAND;
    }

    @Override
    public ItemStack getItemInHand() {
        return ItemStackConverter.of(getHandle().getItemInHand().orNull());
    }

    @Override
    public void setItemInHand(ItemStack item) {
        getHandle().setItemInHand(ItemStackConverter.of(item));
    }

    @Override
    public ItemStack getBoots() {
        return ItemStackConverter.of(getHandle().getBoots().orNull());
    }

    @Override
    public void setBoots(ItemStack item) {
        getHandle().setBoots(ItemStackConverter.of(item));
    }

    @Override
    public ItemStack getLeggings() {
        return ItemStackConverter.of(getHandle().getLeggings().orNull());
    }

    @Override
    public void setLeggings(ItemStack item) {
        getHandle().setLeggings(ItemStackConverter.of(item));
    }

    @Override
    public ItemStack getChestplate() {
        return ItemStackConverter.of(getHandle().getChestplate().orNull());
    }

    @Override
    public void setChestplate(ItemStack item) {
        getHandle().setChestplate(ItemStackConverter.of(item));
    }

    @Override
    public ItemStack getHelmet() {
        return ItemStackConverter.of(getHandle().getHelmet().orNull());
    }

    @Override
    public void setHelmet(ItemStack item) {
        getHandle().setHelmet(ItemStackConverter.of(item));
    }

    @Override
    public EulerAngle getBodyPose() {
        return EulerAngleConverter.of(get(BodyPartRotationalData.class).getBodyRotation());
    }

    @Override
    public void setBodyPose(EulerAngle pose) {
        BodyPartRotationalData data = getOrCreate(BodyPartRotationalData.class);
        data.setBodyDirection(EulerAngleConverter.of(pose));
        set(data);
    }

    @Override
    public EulerAngle getLeftArmPose() {
        return EulerAngleConverter.of(get(BodyPartRotationalData.class).getLeftArmDirection());
    }

    @Override
    public void setLeftArmPose(EulerAngle pose) {
        BodyPartRotationalData data = getOrCreate(BodyPartRotationalData.class);
        data.setLeftArmDirection(EulerAngleConverter.of(pose));
        set(data);
    }

    @Override
    public EulerAngle getRightArmPose() {
        return EulerAngleConverter.of(get(BodyPartRotationalData.class).getRightArmDirection());
    }

    @Override
    public void setRightArmPose(EulerAngle pose) {
        BodyPartRotationalData data = getOrCreate(BodyPartRotationalData.class);
        data.setRightArmDirection(EulerAngleConverter.of(pose));
        set(data);
    }

    @Override
    public EulerAngle getLeftLegPose() {
        return EulerAngleConverter.of(get(BodyPartRotationalData.class).getLeftLegDirection());
    }

    @Override
    public void setLeftLegPose(EulerAngle pose) {
        BodyPartRotationalData data = getOrCreate(BodyPartRotationalData.class);
        data.setLeftLegDirection(EulerAngleConverter.of(pose));
        set(data);
    }

    @Override
    public EulerAngle getRightLegPose() {
        return EulerAngleConverter.of(get(BodyPartRotationalData.class).getRightLegDirection());
    }

    @Override
    public void setRightLegPose(EulerAngle pose) {
        BodyPartRotationalData data = getOrCreate(BodyPartRotationalData.class);
        data.setRightLegDirection(EulerAngleConverter.of(pose));
        set(data);
    }

    @Override
    public EulerAngle getHeadPose() {
        return EulerAngleConverter.of(get(BodyPartRotationalData.class).getHeadDirection());
    }

    @Override
    public void setHeadPose(EulerAngle pose) {
        BodyPartRotationalData data = getOrCreate(BodyPartRotationalData.class);
        data.setHeadDirection(EulerAngleConverter.of(pose));
        set(data);
    }

    @Override
    public boolean hasBasePlate() {
        return getHandle().hasBasePlate();
    }

    @Override
    public void setBasePlate(boolean basePlate) {
        getHandle().setHasBasePlate(basePlate);
    }

    @Override
    public boolean hasGravity() {
        return this.getHandle().hasGravity();
    }

    @Override
    public void setGravity(boolean gravity) {
        this.getHandle().setGravity(gravity);
    }

    @Override
    public boolean isVisible() {
        return !has(InvisibilityData.class); // TODO: ???
    }

    @Override
    public void setVisible(boolean visible) {
        if (visible != isVisible()) {
            if (visible) {
                remove(InvisibilityData.class);
            } else {
                set(getOrCreate(InvisibilityData.class));
            }
        }
    }

    @Override
    public boolean hasArms() {
        return getHandle().doesShowArms();
    }

    @Override
    public void setArms(boolean arms) {
        this.getHandle().setShowArms(arms);
    }

    @Override
    public boolean isSmall() {
        return getHandle().isSmall();
    }

    @Override
    public void setSmall(boolean small) {
        getHandle().setSmall(small);
    }
}
