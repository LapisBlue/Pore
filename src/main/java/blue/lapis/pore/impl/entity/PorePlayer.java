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

import blue.lapis.pore.Pore;
import blue.lapis.pore.converter.type.SoundConverter;
import blue.lapis.pore.converter.vector.VectorConverter;
import blue.lapis.pore.converter.wrapper.PoreConverter;
import com.google.common.base.Optional;
import org.apache.commons.lang.NotImplementedException;
import org.bukkit.Achievement;
import org.bukkit.Effect;
import org.bukkit.Instrument;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Note;
import org.bukkit.Sound;
import org.bukkit.Statistic;
import org.bukkit.WeatherType;
import org.bukkit.conversations.Conversation;
import org.bukkit.conversations.ConversationAbandonedEvent;
import org.bukkit.entity.EntityType;
import org.bukkit.map.MapView;
import org.bukkit.plugin.Plugin;
import org.bukkit.scoreboard.Scoreboard;
import org.spongepowered.api.effect.sound.SoundType;
import org.spongepowered.api.entity.player.Player;

import java.net.InetSocketAddress;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

public class PorePlayer extends PoreHumanEntity implements org.bukkit.entity.Player {

    public static PorePlayer of(Player handle) {
        return PoreConverter.of(PorePlayer.class, handle);
    }

    protected PorePlayer(Player handle) {
        super(handle);
    }

    @Override
    public Player getHandle() {
        return (Player) super.getHandle();
    }

    @Override
    public EntityType getType() {
        return EntityType.PLAYER;
    }

    @Override
    public String getDisplayName() {
        return getHandle().getDisplayName().toLegacy();
    }

    @Override
    public void setDisplayName(String name) {
        throw new NotImplementedException();
    }

    @Override
    public String getPlayerListName() {
        return getDisplayName(); //TODO: temporary measure
    }

    @Override
    public void setPlayerListName(String name) {
        throw new NotImplementedException();
    }

    @Override
    public void setCompassTarget(Location loc) {
        throw new NotImplementedException();
    }

    @Override
    public Location getCompassTarget() {
        throw new NotImplementedException();
    }

    @Override
    public InetSocketAddress getAddress() {
        return getHandle().getConnection().getAddress();
    }

    @Override
    public boolean isConversing() {
        throw new NotImplementedException();
    }

    @Override
    public void acceptConversationInput(String input) {
        throw new NotImplementedException();
    }

    @Override
    public boolean beginConversation(Conversation conversation) {
        throw new NotImplementedException();
    }

    @Override
    public void abandonConversation(Conversation conversation) {
        throw new NotImplementedException();
    }

    @Override
    public void abandonConversation(Conversation conversation, ConversationAbandonedEvent details) {
        throw new NotImplementedException();
    }

    @Override
    public void sendRawMessage(String message) {
        sendMessage(message);
    }

    @Override
    public void kickPlayer(String message) {
        throw new NotImplementedException();
    }

    @Override
    public void chat(String msg) {
        throw new NotImplementedException();
    }

    @Override
    public boolean performCommand(String command) {
        throw new NotImplementedException();
    }

    @Override
    public boolean isSneaking() {
        throw new NotImplementedException();
    }

    @Override
    public void setSneaking(boolean sneak) {
        throw new NotImplementedException();
    }

    @Override
    public boolean isSprinting() {
        throw new NotImplementedException();
    }

    @Override
    public void setSprinting(boolean sprinting) {
        throw new NotImplementedException();
    }

    @Override
    public void saveData() {
        throw new NotImplementedException();
    }

    @Override
    public void loadData() {
        throw new NotImplementedException();
    }

    @Override
    public void setSleepingIgnored(boolean isSleeping) {
        throw new NotImplementedException();
    }

    @Override
    public boolean isSleepingIgnored() {
        throw new NotImplementedException();
    }

    @Override
    public void playNote(Location loc, byte instrument, byte note) {
        throw new NotImplementedException();
    }

    @Override
    public void playNote(Location loc, Instrument instrument, Note note) {
        throw new NotImplementedException();
    }

    @Override
    public void playSound(Location location, Sound sound, float volume, float pitch) {
        getHandle().playSound(SoundConverter.of(sound), VectorConverter.create3d(location), (double) volume,
                (double) pitch);
    }

    @Override
    public void playSound(Location location, String sound, float volume, float pitch) {
        // TODO: Isn't the String sound the ID and not the name?
        Optional<SoundType> spongeSound = Pore.getGame().getRegistry().getSound(sound);
        if (spongeSound.isPresent()) {
            getHandle().playSound(spongeSound.get(), VectorConverter.create3d(location),
                    (double) volume, (double) pitch);
        }
    }

    @Override
    public void playEffect(Location loc, Effect effect, int data) {
        throw new NotImplementedException();
    }

    @Override
    public <T> void playEffect(Location loc, Effect effect, T data) {
        throw new NotImplementedException();
    }

    @Override
    public void sendBlockChange(Location loc, Material material, byte data) {
        throw new NotImplementedException();
    }

    @Override
    public boolean sendChunkChange(Location loc, int sx, int sy, int sz, byte[] data) {
        throw new NotImplementedException();
    }

    @Override
    public void sendBlockChange(Location loc, int material, byte data) {
        throw new NotImplementedException();
    }

    @Override
    public void sendSignChange(Location loc, String[] lines) throws IllegalArgumentException {
        throw new NotImplementedException();
    }

    @Override
    public void sendMap(MapView map) {
        throw new NotImplementedException();
    }

    @Override
    public void updateInventory() {
        throw new NotImplementedException();
    }

    @Override
    public void awardAchievement(Achievement achievement) {
        throw new NotImplementedException();
    }

    @Override
    public void removeAchievement(Achievement achievement) {
        throw new NotImplementedException();
    }

    @Override
    public boolean hasAchievement(Achievement achievement) {
        throw new NotImplementedException();
    }

    @Override
    public void incrementStatistic(Statistic statistic) throws IllegalArgumentException {
        throw new NotImplementedException();
    }

    @Override
    public void decrementStatistic(Statistic statistic) throws IllegalArgumentException {
        throw new NotImplementedException();
    }

    @Override
    public void incrementStatistic(Statistic statistic, int amount) throws IllegalArgumentException {
        throw new NotImplementedException();
    }

    @Override
    public void decrementStatistic(Statistic statistic, int amount) throws IllegalArgumentException {
        throw new NotImplementedException();
    }

    @Override
    public void setStatistic(Statistic statistic, int newValue) throws IllegalArgumentException {
        throw new NotImplementedException();
    }

    @Override
    public int getStatistic(Statistic statistic) throws IllegalArgumentException {
        throw new NotImplementedException();
    }

    @Override
    public void incrementStatistic(Statistic statistic, Material material) throws IllegalArgumentException {
        throw new NotImplementedException();
    }

    @Override
    public void decrementStatistic(Statistic statistic, Material material) throws IllegalArgumentException {
        throw new NotImplementedException();
    }

    @Override
    public int getStatistic(Statistic statistic, Material material) throws IllegalArgumentException {
        throw new NotImplementedException();
    }

    @Override
    public void incrementStatistic(Statistic statistic, Material material, int amount)
            throws IllegalArgumentException {
        throw new NotImplementedException();
    }

    @Override
    public void decrementStatistic(Statistic statistic, Material material, int amount)
            throws IllegalArgumentException {
        throw new NotImplementedException();
    }

    @Override
    public void setStatistic(Statistic statistic, Material material, int newValue)
            throws IllegalArgumentException {
        throw new NotImplementedException();
    }

    @Override
    public void incrementStatistic(Statistic statistic, EntityType entityType) throws IllegalArgumentException {
        throw new NotImplementedException();
    }

    @Override
    public void decrementStatistic(Statistic statistic, EntityType entityType) throws IllegalArgumentException {
        throw new NotImplementedException();
    }

    @Override
    public int getStatistic(Statistic statistic, EntityType entityType) throws IllegalArgumentException {
        throw new NotImplementedException();
    }

    @Override
    public void incrementStatistic(Statistic statistic, EntityType entityType, int amount)
            throws IllegalArgumentException {
        throw new NotImplementedException();
    }

    @Override
    public void decrementStatistic(Statistic statistic, EntityType entityType, int amount) {
        throw new NotImplementedException();
    }

    @Override
    public void setStatistic(Statistic statistic, EntityType entityType, int newValue) {
        throw new NotImplementedException();
    }

    @Override
    public void setPlayerTime(long time, boolean relative) {
        throw new NotImplementedException();
    }

    @Override
    public long getPlayerTime() {
        throw new NotImplementedException();
    }

    @Override
    public long getPlayerTimeOffset() {
        throw new NotImplementedException();
    }

    @Override
    public boolean isPlayerTimeRelative() {
        throw new NotImplementedException();
    }

    @Override
    public void resetPlayerTime() {
        throw new NotImplementedException();
    }

    @Override
    public void setPlayerWeather(WeatherType type) {
        throw new NotImplementedException();
    }

    @Override
    public WeatherType getPlayerWeather() {
        throw new NotImplementedException();
    }

    @Override
    public void resetPlayerWeather() {
        throw new NotImplementedException();
    }

    @Override
    public void giveExp(int amount) {
        throw new NotImplementedException();
    }

    @Override
    public void giveExpLevels(int amount) {
        throw new NotImplementedException();
    }

    @Override
    public float getExp() {
        throw new NotImplementedException();
    }

    @Override
    public void setExp(float exp) {
        throw new NotImplementedException();
    }

    @Override
    public int getLevel() {
        throw new NotImplementedException();
    }

    @Override
    public void setLevel(int level) {
        throw new NotImplementedException();
    }

    @Override
    public int getTotalExperience() {
        throw new NotImplementedException();
    }

    @Override
    public void setTotalExperience(int exp) {
        throw new NotImplementedException();
    }

    @Override
    public float getExhaustion() {
        return getHandle().getHunger();
    }

    @Override
    public void setExhaustion(float value) {
        getHandle().setHunger(value);
    }

    @Override
    public float getSaturation() {
        return getHandle().getSaturation();
    }

    @Override
    public void setSaturation(float value) {
        getHandle().setSaturation(value);
    }

    @Override
    public int getFoodLevel() {
        throw new NotImplementedException();
    }

    @Override
    public void setFoodLevel(int value) {
        throw new NotImplementedException();
    }

    @Override
    public boolean isOnline() {
        return getHandle().isOnline();
    }

    @Override
    public boolean isBanned() {
        return getHandle().isBanned();
    }

    @Override
    public void setBanned(boolean banned) {
        throw new NotImplementedException();
    }

    @Override
    public boolean isWhitelisted() {
        return getHandle().isWhitelisted();
    }

    @Override
    public void setWhitelisted(boolean value) {
        throw new NotImplementedException();
    }

    @Override
    public org.bukkit.entity.Player getPlayer() {
        return this;
    }

    @Override
    public long getFirstPlayed() {
        return getHandle().getFirstPlayed().getTime();
    }

    @Override
    public long getLastPlayed() {
        return getHandle().getLastPlayed().getTime();
    }

    @Override
    public boolean hasPlayedBefore() {
        return getHandle().hasJoinedBefore();
    }

    @Override
    public Location getBedSpawnLocation() {
        throw new NotImplementedException();
    }

    @Override
    public void setBedSpawnLocation(Location location) {
        throw new NotImplementedException();
    }

    @Override
    public void setBedSpawnLocation(Location location, boolean force) {
        throw new NotImplementedException();
    }

    @Override
    public boolean getAllowFlight() {
        return getHandle().getAllowFlight();
    }

    @Override
    public void setAllowFlight(boolean flight) {
        getHandle().setAllowFlight(flight);
    }

    @Override
    public void hidePlayer(org.bukkit.entity.Player player) {
        throw new NotImplementedException();
    }

    @Override
    public void showPlayer(org.bukkit.entity.Player player) {
        throw new NotImplementedException();
    }

    @Override
    public boolean canSee(org.bukkit.entity.Player player) {
        throw new NotImplementedException();
    }

    @Override
    public boolean isFlying() {
        throw new NotImplementedException();
    }

    @Override
    public void setFlying(boolean value) {
        throw new NotImplementedException();
    }

    @Override
    public void setFlySpeed(float value) throws IllegalArgumentException {
        throw new NotImplementedException();
    }

    @Override
    public void setWalkSpeed(float value) throws IllegalArgumentException {
        throw new NotImplementedException();
    }

    @Override
    public float getFlySpeed() {
        throw new NotImplementedException();
    }

    @Override
    public float getWalkSpeed() {
        throw new NotImplementedException();
    }

    @Override
    public void setTexturePack(String url) {
        throw new NotImplementedException();
    }

    @Override
    public void setResourcePack(String url) {
        throw new NotImplementedException();
    }

    @Override
    public Scoreboard getScoreboard() {
        throw new NotImplementedException();
    }

    @Override
    public void setScoreboard(Scoreboard scoreboard) throws IllegalArgumentException, IllegalStateException {
        throw new NotImplementedException();
    }

    @Override
    public boolean isHealthScaled() {
        throw new NotImplementedException();
    }

    @Override
    public void setHealthScaled(boolean scale) {
        throw new NotImplementedException();
    }

    @Override
    public void setHealthScale(double scale) throws IllegalArgumentException {
        throw new NotImplementedException();
    }

    @Override
    public double getHealthScale() {
        throw new NotImplementedException();
    }

    @Override
    public void sendMessage(String message) {
        getHandle().sendMessage(message);
    }

    @Override
    public void sendMessage(String[] messages) {
        getHandle().sendMessage(messages);
    }

    @Override
    public Map<String, Object> serialize() {
        Map<String, Object> result = new LinkedHashMap<String, Object>();
        result.put("name", getName());
        return result;
    }

    @Override
    public void sendPluginMessage(Plugin source, String channel, byte[] message) {
        getHandle().getConnection().sendCustomPayload(source, channel, message);
    }

    @Override
    public Set<String> getListeningPluginChannels() {
        throw new NotImplementedException();
    }

    @Override
    public UUID getUniqueId() {
        return getHandle().getUniqueId();
    }
}
