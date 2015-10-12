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

import static org.spongepowered.api.data.manipulator.catalog.CatalogEntityData.INVISIBILITY_DATA;

import blue.lapis.pore.converter.type.material.ItemStackConverter;
import blue.lapis.pore.converter.vector.EulerAngleConverter;
import blue.lapis.pore.converter.wrapper.WrapperConverter;

import org.apache.commons.lang3.NotImplementedException;
import org.bukkit.entity.EntityType;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.EulerAngle;
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
        return ItemStackConverter.of(getHandle().getItemInHand().orElse(null));
    }

    @Override
    public void setItemInHand(ItemStack item) {
        getHandle().setItemInHand(ItemStackConverter.of(item));
    }

    @Override
    public ItemStack getHelmet() {
        return ItemStackConverter.of(getHandle().getHelmet().orElse(null));
    }

    @Override
    public void setHelmet(ItemStack item) {
        getHandle().setHelmet(ItemStackConverter.of(item));
    }

    @Override
    public ItemStack getChestplate() {
        return ItemStackConverter.of(getHandle().getChestplate().orElse(null));
    }

    @Override
    public void setChestplate(ItemStack item) {
        getHandle().setChestplate(ItemStackConverter.of(item));
    }

    @Override
    public ItemStack getLeggings() {
        return ItemStackConverter.of(getHandle().getLeggings().orElse(null));
    }

    @Override
    public void setLeggings(ItemStack item) {
        getHandle().setLeggings(ItemStackConverter.of(item));
    }

    @Override
    public ItemStack getBoots() {
        return ItemStackConverter.of(getHandle().getBoots().orElse(null));
    }

    @Override
    public void setBoots(ItemStack item) {
        getHandle().setBoots(ItemStackConverter.of(item));
    }

    @Override
    public EulerAngle getHeadPose() {
        return EulerAngleConverter.of(getHandle().getBodyPartRotationalData().headDirection().get());
    }

    @Override
    public void setHeadPose(EulerAngle pose) {
        getHandle().getBodyPartRotationalData().headDirection().set(EulerAngleConverter.of(pose));
    }

    @Override
    public EulerAngle getBodyPose() {
        return EulerAngleConverter.of(getHandle().getBodyPartRotationalData().bodyRotation().get());
    }

    @Override
    public void setBodyPose(EulerAngle pose) {
        getHandle().getBodyPartRotationalData().bodyRotation().set(EulerAngleConverter.of(pose));
    }

    @Override
    public EulerAngle getLeftArmPose() {
        return EulerAngleConverter.of(getHandle().getBodyPartRotationalData().leftArmDirection().get());
    }

    @Override
    public void setLeftArmPose(EulerAngle pose) {
        getHandle().getBodyPartRotationalData().leftArmDirection().set(EulerAngleConverter.of(pose));
    }

    @Override
    public EulerAngle getRightArmPose() {
        return EulerAngleConverter.of(getHandle().getBodyPartRotationalData().rightArmDirection().get());
    }

    @Override
    public void setRightArmPose(EulerAngle pose) {
        getHandle().getBodyPartRotationalData().rightArmDirection().set(EulerAngleConverter.of(pose));
    }

    @Override
    public EulerAngle getLeftLegPose() {
        return EulerAngleConverter.of(getHandle().getBodyPartRotationalData().leftLegDirection().get());
    }

    @Override
    public void setLeftLegPose(EulerAngle pose) {
        getHandle().getBodyPartRotationalData().leftLegDirection().set(EulerAngleConverter.of(pose));
    }

    @Override
    public EulerAngle getRightLegPose() {
        return EulerAngleConverter.of(getHandle().getBodyPartRotationalData().rightArmDirection().get());
    }

    @Override
    public void setRightLegPose(EulerAngle pose) {
        getHandle().getBodyPartRotationalData().rightLegDirection().set(EulerAngleConverter.of(pose));
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
        return getHandle().get(INVISIBILITY_DATA).isPresent();
    }

    @Override
    public void setVisible(boolean visible) {
        getHandle().getOrCreate(INVISIBILITY_DATA);
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

    @Override
    public boolean isMarker() {
        throw new NotImplementedException("TODO");
    }

    @Override
    public void setMarker(boolean marker) {
        throw new NotImplementedException("TODO");
    }
}
