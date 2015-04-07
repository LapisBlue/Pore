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

import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.base.Preconditions.checkState;

import blue.lapis.pore.Pore;
import blue.lapis.pore.converter.type.entity.EntityConverter;
import blue.lapis.pore.converter.type.material.MaterialConverter;
import blue.lapis.pore.converter.type.statistic.AchievementConverter;
import blue.lapis.pore.converter.type.statistic.StatisticConverter;
import blue.lapis.pore.converter.type.world.effect.SoundConverter;
import blue.lapis.pore.converter.vector.LocationConverter;
import blue.lapis.pore.converter.vector.VectorConverter;
import blue.lapis.pore.converter.wrapper.WrapperConverter;
import blue.lapis.pore.impl.scoreboard.PoreScoreboard;

import com.google.common.base.Optional;
import com.google.common.collect.Maps;
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
import org.spongepowered.api.block.BlockTypes;
import org.spongepowered.api.effect.sound.SoundType;
import org.spongepowered.api.entity.player.Player;
import org.spongepowered.api.entity.player.tab.PlayerTabInfo;
import org.spongepowered.api.resourcepack.ResourcePacks;
import org.spongepowered.api.stats.BlockStatistic;
import org.spongepowered.api.stats.EntityStatistic;
import org.spongepowered.api.stats.StatisticGroup;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.Texts;

import java.io.FileNotFoundException;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

public class PorePlayer extends PoreHumanEntity implements org.bukkit.entity.Player {

    public static PorePlayer of(Player handle) {
        return WrapperConverter.of(PorePlayer.class, handle);
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
    @SuppressWarnings("deprecation")
    public String getDisplayName() {
        return Texts.toLegacy(getHandle().getDisplayName());
    }

    @Override
    @SuppressWarnings("deprecation")
    public void setDisplayName(String name) {
        this.getHandle().setDisplayName(Texts.fromLegacy(name));
    }

    @Override
    public String getPlayerListName() {
        Optional<PlayerTabInfo> info = this.getHandle().getTabList().getPlayer(this.getUniqueId());
        return info.isPresent() ? Texts.toLegacy(info.get().getDisplayName()) : this.getDisplayName();
    }

    @Override
    @SuppressWarnings("deprecation")
    public void setPlayerListName(String name) {
        Optional<PlayerTabInfo> info = this.getHandle().getTabList().getPlayer(this.getUniqueId());
        if (info.isPresent()) {
            info.get().setDisplayName(Texts.fromLegacy(name));
        }
    }

    @Override
    public Location getCompassTarget() {
        throw new NotImplementedException();
    }

    @Override
    public void setCompassTarget(Location loc) {
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
        this.sendMessage(message);
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
        return this.getHandle().isSneaking();
    }

    @Override
    public void setSneaking(boolean sneak) {
        this.getHandle().setSneaking(sneak);
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
    public boolean isSleepingIgnored() {
        throw new NotImplementedException();
    }

    @Override
    public void setSleepingIgnored(boolean isSleeping) {
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
        getHandle().grantAchievement(AchievementConverter.of(achievement));
    }

    @Override
    public void removeAchievement(Achievement achievement) {
        getHandle().revokeAchievement(AchievementConverter.of(achievement));
    }

    @Override
    public boolean hasAchievement(Achievement achievement) {
        return getHandle().hasAchievement(AchievementConverter.of(achievement));
    }

    @Override
    public void incrementStatistic(Statistic statistic) throws IllegalArgumentException {
        incrementStatistic(statistic, 1);
    }

    @Override
    public void decrementStatistic(Statistic statistic) throws IllegalArgumentException {
        decrementStatistic(statistic, 1);
    }

    @Override
    public void incrementStatistic(Statistic statistic, int amount) throws IllegalArgumentException {
        checkNotNull(statistic, "Statistic must not be null");
        getHandle().addToStatistic(StatisticConverter.asStdStat(statistic), amount);
    }

    @Override
    public void decrementStatistic(Statistic statistic, int amount) throws IllegalArgumentException {
        incrementStatistic(statistic, -amount);
    }

    @Override
    public void setStatistic(Statistic statistic, int newValue) throws IllegalArgumentException {
        checkNotNull(statistic, "Statistic must not be null");
        getHandle().setStatistic(StatisticConverter.asStdStat(statistic), newValue);
    }

    @Override
    public int getStatistic(Statistic statistic) throws IllegalArgumentException {
        checkNotNull(statistic, "Statistic must not be null");
        return getHandle().getStatistic(StatisticConverter.asStdStat(statistic)).or(0L).intValue();
    }

    @Override
    public void incrementStatistic(Statistic statistic, Material material) throws IllegalArgumentException {
        incrementStatistic(statistic, material, 1);
    }

    @Override
    public void decrementStatistic(Statistic statistic, Material material) throws IllegalArgumentException {
        decrementStatistic(statistic, material, 1);
    }

    @Override
    public int getStatistic(Statistic statistic, Material material) throws IllegalArgumentException {
        checkNotNull(statistic, "Statistic must not be null");
        checkState(statistic.getType() == Statistic.Type.BLOCK,
                "Cannot augment non-block statistic " + statistic.name());
        StatisticGroup group = StatisticConverter.asGroupStat(statistic);
        Optional<BlockStatistic> stat =
                Pore.getGame().getRegistry().getBlockStatistic(group, MaterialConverter.asBlock(material));
        if (!stat.isPresent()) {
            throw new UnsupportedOperationException("Cannot get block statistic " + statistic.name() + " for material "
                    + material.name());
        }
        return getHandle().getStatistic(stat.get()).or(0L).intValue();
    }

    @Override
    public void incrementStatistic(Statistic statistic, Material material, int amount)
            throws IllegalArgumentException {
        checkNotNull(statistic, "Statistic must not be null");
        checkState(statistic.getType() == Statistic.Type.BLOCK,
                "Cannot augment non-block statistic " + statistic.name());
        StatisticGroup group = StatisticConverter.asGroupStat(statistic);
        Optional<BlockStatistic> stat =
                Pore.getGame().getRegistry().getBlockStatistic(group, MaterialConverter.asBlock(material));
        if (!stat.isPresent()) {
            throw new UnsupportedOperationException("Cannot get block statistic " + statistic.name() + " for material "
                    + material.name());
        }
        getHandle().addToStatistic(stat.get(), amount);
    }

    @Override
    public void decrementStatistic(Statistic statistic, Material material, int amount)
            throws IllegalArgumentException {
        incrementStatistic(statistic, material, -amount);
    }

    @Override
    public void setStatistic(Statistic statistic, Material material, int newValue)
            throws IllegalArgumentException {
        checkNotNull(statistic, "Statistic must not be null");
        checkState(statistic.getType() == Statistic.Type.BLOCK,
                "Cannot augment non-block statistic " + statistic.name());
        StatisticGroup group = StatisticConverter.asGroupStat(statistic);
        Optional<BlockStatistic> stat =
                Pore.getGame().getRegistry().getBlockStatistic(group, MaterialConverter.asBlock(material));
        if (!stat.isPresent()) {
            throw new UnsupportedOperationException("Cannot get block statistic " + statistic.name() + " for material "
                    + material.name());
        }
        getHandle().setStatistic(stat.get(), newValue);
    }

    @Override
    public void incrementStatistic(Statistic statistic, EntityType entityType) throws IllegalArgumentException {
        incrementStatistic(statistic, entityType, 1);
    }

    @Override
    public void decrementStatistic(Statistic statistic, EntityType entityType) throws IllegalArgumentException {
        decrementStatistic(statistic, entityType, 1);
    }

    @Override
    public int getStatistic(Statistic statistic, EntityType entityType) throws IllegalArgumentException {
        checkNotNull(statistic, "Statistic must not be null");
        checkState(statistic.getType() == Statistic.Type.ENTITY,
                "Cannot augment non-entity statistic " + statistic.name());
        StatisticGroup group = StatisticConverter.asGroupStat(statistic);
        Optional<EntityStatistic> stat =
                Pore.getGame().getRegistry().getEntityStatistic(group, EntityConverter.of(entityType));
        if (!stat.isPresent()) {
            throw new UnsupportedOperationException("Cannot get entity statistic " + statistic.name() + " for entity "
                    + entityType.name());
        }
        return getHandle().getStatistic(stat.get()).or(0L).intValue();
    }

    @Override
    public void incrementStatistic(Statistic statistic, EntityType entityType, int amount)
            throws IllegalArgumentException {
        checkNotNull(statistic, "Statistic must not be null");
        checkState(statistic.getType() == Statistic.Type.ENTITY,
                "Cannot augment non-entity statistic " + statistic.name());
        StatisticGroup group = StatisticConverter.asGroupStat(statistic);
        Optional<EntityStatistic> stat =
                Pore.getGame().getRegistry().getEntityStatistic(group, EntityConverter.of(entityType));
        if (!stat.isPresent()) {
            throw new UnsupportedOperationException("Cannot get entity statistic " + statistic.name() + " for entity "
                    + entityType.name());
        }
        getHandle().addToStatistic(stat.get(), amount);
    }

    @Override
    public void decrementStatistic(Statistic statistic, EntityType entityType, int amount) {
        incrementStatistic(statistic, entityType, -amount);
    }

    @Override
    public void setStatistic(Statistic statistic, EntityType entityType, int newValue) {
        checkNotNull(statistic, "Statistic must not be null");
        checkState(statistic.getType() == Statistic.Type.ENTITY,
                "Cannot augment non-entity statistic " + statistic.name());
        StatisticGroup group = StatisticConverter.asGroupStat(statistic);
        Optional<EntityStatistic> stat =
                Pore.getGame().getRegistry().getEntityStatistic(group, EntityConverter.of(entityType));
        if (!stat.isPresent()) {
            throw new UnsupportedOperationException("Cannot get entity statistic " + statistic.name() + " for entity "
                    + entityType.name());
        }
        getHandle().setStatistic(stat.get(), newValue);
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
        this.getHandle().setTotalExperience(this.getHandle().getTotalExperience() + amount);
    }

    @Override
    public void giveExpLevels(int amount) {
        this.getHandle().setLevel(this.getHandle().getLevel() + amount);
    }

    @Override
    public float getExp() {
        return this.getHandle().getExperienceSinceLevel() / this.getHandle().getExperienceBetweenLevels();
    }

    @Override
    public void setExp(float exp) {
        this.getHandle().setExperienceSinceLevel((int)(this.getHandle().getExperienceBetweenLevels() * exp));
    }

    @Override
    public int getLevel() {
        return this.getHandle().getLevel();
    }

    @Override
    public void setLevel(int level) {
        this.getHandle().setLevel(level);
    }

    @Override
    public int getTotalExperience() {
        return this.getHandle().getTotalExperience();
    }

    @Override
    public void setTotalExperience(int exp) {
        this.getHandle().setTotalExperience(exp);
    }

    @Override
    public float getExhaustion() {
        return (float) getHandle().getExhaustion();
    }

    @Override
    public void setExhaustion(float value) {
        getHandle().setExhaustion(value);
    }

    @Override
    public float getSaturation() {
        return (float) getHandle().getSaturation();
    }

    @Override
    public void setSaturation(float value) {
        getHandle().setSaturation(value);
    }

    @Override
    public int getFoodLevel() {
        return (int) this.getHandle().getFoodLevel();
    }

    @Override
    public void setFoodLevel(int value) {
        this.getHandle().setFoodLevel(value);
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
        return LocationConverter.of(this.getHandle().getBedLocation().orNull());
    }

    @Override
    public void setBedSpawnLocation(Location location) {
        this.setBedSpawnLocation(location, false);
    }

    @Override
    public void setBedSpawnLocation(Location location, boolean force) {
        org.spongepowered.api.world.Location spongeLoc = LocationConverter.of(location);
        //noinspection ConstantConditions
        if (force || spongeLoc.getType() == BlockTypes.BED) {
            this.getHandle().setBedLocation(spongeLoc);
        }
    }

    @Override
    public void hidePlayer(org.bukkit.entity.Player player) {
        if (!(player instanceof PorePlayer)) { // not sure why this might return false, but just in case
            throw new UnsupportedOperationException("Cannot check invisibility status of non-wrapped player");
        }
        ((PorePlayer)player).getHandle().setInvisibleTo(this.getHandle(), true);
    }

    @Override
    public void showPlayer(org.bukkit.entity.Player player) {
        if (!(player instanceof PorePlayer)) { // not sure why this might return false, but just in case
            throw new UnsupportedOperationException("Cannot check invisibility status of non-wrapped player");
        }
        ((PorePlayer)player).getHandle().setInvisibleTo(this.getHandle(), false);
    }

    @Override
    public boolean canSee(org.bukkit.entity.Player player) {
        if (!(player instanceof PorePlayer)) { // not sure why this might return false, but just in case
            throw new UnsupportedOperationException("Cannot check invisibility status of non-wrapped player");
        }
        return ((PorePlayer)player).getHandle().isInvisibleTo(this.getHandle());
    }

    @Override
    public boolean isFlying() {
        return this.getHandle().isFlying();
    }

    @Override
    public void setFlying(boolean value) {
        this.getHandle().setFlying(value);
    }

    //TODO: movement speeds and flight toggle will be included with the attributes API
    @Override
    public boolean getAllowFlight() {
        throw new NotImplementedException();
    }

    @Override
    public void setAllowFlight(boolean flight) {
        throw new NotImplementedException();
    }

    @Override
    public float getWalkSpeed() {
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
    public void setFlySpeed(float value) throws IllegalArgumentException {
        throw new NotImplementedException();
    }

    @Override
    public void setTexturePack(String url) {
        setResourcePack(url);
    }

    @Override
    public void setResourcePack(String url) {
        try {
            getHandle().sendResourcePack(ResourcePacks.fromUrl(new URL(url)));
        } catch (FileNotFoundException swallow) {
            //TODO: okay to swallow?
        } catch (MalformedURLException swallow) {
            //TODO: okay to swallow?
        }
    }

    @Override
    public Scoreboard getScoreboard() {
        return PoreScoreboard.of(getHandle().getScoreboard());
    }

    @Override
    public void setScoreboard(Scoreboard scoreboard) throws IllegalArgumentException, IllegalStateException {
        getHandle().setScoreboard(((PoreScoreboard) scoreboard).getHandle());
    }

    //TODO: As far as I can tell this is unique to Bukkit, so it'll need to be handled exclusively by Pore.
    @Override
    public boolean isHealthScaled() {
        throw new NotImplementedException();
    }

    @Override
    public double getHealthScale() {
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
    @SuppressWarnings("deprecation")
    public void sendMessage(String message) {
        getHandle().sendMessage(Texts.fromLegacy(message));
    }

    @Override
    @SuppressWarnings("deprecation")
    public void sendMessage(String[] messages) {
        Text[] texts = new Text[messages.length];
        for (int i = 0; i < messages.length; i++) {
            texts[i] = Texts.fromLegacy(messages[i]);
        }
        this.getHandle().sendMessage(texts);
    }

    @Override
    public Map<String, Object> serialize() {
        Map<String, Object> result = Maps.newLinkedHashMap();
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
