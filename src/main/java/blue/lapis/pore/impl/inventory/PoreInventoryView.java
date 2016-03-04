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

package blue.lapis.pore.impl.inventory;

import static com.google.common.base.Preconditions.checkNotNull;

import blue.lapis.pore.impl.entity.PorePlayer;

import org.bukkit.entity.HumanEntity;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.InventoryView;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.item.inventory.Inventory;

//TODO: this wrapper may need to optimized but I'm not sure how we would do that at the moment
public class PoreInventoryView extends InventoryView {

    private final org.bukkit.entity.HumanEntity player;
    private final org.bukkit.inventory.Inventory top;
    private final org.bukkit.inventory.Inventory bottom;

    protected PoreInventoryView(org.bukkit.entity.HumanEntity player, org.bukkit.inventory.Inventory top,
            org.bukkit.inventory.Inventory bottom) {
        this.player = player;
        this.top = top;
        this.bottom = bottom;
    }

    public static PoreInventoryView.Builder builder() {
        return new PoreInventoryView.Builder();
    }

    @Override
    public org.bukkit.inventory.Inventory getTopInventory() {
        return this.top;
    }

    @Override
    public org.bukkit.inventory.Inventory getBottomInventory() {
        return this.bottom;
    }

    @Override
    public HumanEntity getPlayer() {
        return this.player;
    }

    @Override
    public InventoryType getType() {
        //TODO: I have no idea whether this is correct
        return this.getTopInventory().getType();
    }

    /**
     * Builder used to dynamically construct an {@link InventoryView}.
     */
    public static class Builder {

        private org.bukkit.entity.HumanEntity player;
        private org.bukkit.inventory.Inventory top;
        private org.bukkit.inventory.Inventory bottom;

        /**
         * Sets the player for the new {@link InventoryView}.
         * @param player The player to construct the new {@link InventoryView}
         *               with
         * @return The current {@link Builder} instance
         */
        public Builder setPlayer(Player player) {
            this.player = PorePlayer.of(player);
            return this;
        }

        /**
         * Sets the player for the new {@link InventoryView}.
         * @param player The player to construct the new {@link InventoryView}
         *               with
         * @return The current {@link Builder} instance
         */
        public Builder setPlayer(org.bukkit.entity.HumanEntity player) {
            this.player = player;
            return this;
        }

        /**
         * Sets the top inventory for the new {@link InventoryView}.
         * @param inventory The top inventory to construct the new
         *                  {@link InventoryView} with
         * @return The current {@link Builder} instance
         */
        public Builder setTopInventory(Inventory inventory) {
            this.top = PoreInventory.of(inventory);
            return this;
        }

        /**
         * Sets the top inventory for the new {@link InventoryView}.
         * @param inventory The top inventory to construct the new
         *                  {@link InventoryView} with
         * @return The current {@link Builder} instance
         */
        public Builder setTopInventory(org.bukkit.inventory.Inventory inventory) {
            this.top = inventory;
            return this;
        }

        /**
         * Sets the bottom inventory for the new {@link InventoryView}.
         * @param inventory The bottom inventory to construct the new
         *                  {@link InventoryView} with
         * @return The current {@link Builder} instance
         */
        public Builder setBottomInventory(Inventory inventory) {
            this.bottom = PoreInventory.of(inventory);
            return this;
        }

        /**
         * Sets the bottom inventory for the new {@link InventoryView}.
         * @param inventory The bottom inventory to construct the new
         *                  {@link InventoryView} with
         * @return The current {@link Builder} instance
         */
        public Builder setBottomInventory(org.bukkit.inventory.Inventory inventory) {
            this.bottom = inventory;
            return this;
        }

        /**
         * Constructs the final {@link InventoryView}.
         *
         * @return The newly constructed {@link InventoryView}.
         * @throws IllegalArgumentException If the player or either inventory
         *                                  has not been set for this builder
         */
        public InventoryView build() {
            checkNotNull(this.player, "Player cannot be null");
            checkNotNull(this.top, "Top inventory cannot be null");
            checkNotNull(this.bottom, "Bottom inventory cannot be null");
            return new PoreInventoryView(this.player, this.top, this.bottom);
        }

    }
}
