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
import blue.lapis.pore.converter.type.entity.player.GameModeConverter;
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
import org.apache.commons.lang3.NotImplementedException;
import org.bukkit.Achievement;
import org.bukkit.Effect;
import org.bukkit.GameMode;
import org.bukkit.Instrument;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Note;
import org.bukkit.Sound;
import org.bukkit.Statistic;
import org.bukkit.WeatherType;
import org.bukkit.conversations.Conversation;
import org.bukkit.conversations.ConversationAbandonedEvent;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.map.MapView;
import org.bukkit.plugin.Plugin;
import org.bukkit.scoreboard.Scoreboard;
import org.spongepowered.api.block.BlockTypes;
import org.spongepowered.api.data.manipulator.DisplayNameData;
import org.spongepowered.api.data.manipulator.entity.AchievementData;
import org.spongepowered.api.data.manipulator.entity.ExperienceHolderData;
import org.spongepowered.api.data.manipulator.entity.FlyingData;
import org.spongepowered.api.data.manipulator.entity.FoodData;
import org.spongepowered.api.data.manipulator.entity.GameModeData;
import org.spongepowered.api.data.manipulator.entity.InvisibilityData;
import org.spongepowered.api.data.manipulator.entity.JoinData;
import org.spongepowered.api.data.manipulator.entity.RespawnLocationData;
import org.spongepowered.api.data.manipulator.entity.SneakingData;
import org.spongepowered.api.data.manipulator.entity.StatisticData;
import org.spongepowered.api.data.manipulator.entity.WhitelistData;
import org.spongepowered.api.effect.sound.SoundType;
import org.spongepowered.api.entity.player.Player;
import org.spongepowered.api.entity.player.tab.PlayerTabInfo;
import org.spongepowered.api.resourcepack.ResourcePacks;
import org.spongepowered.api.statistic.BlockStatistic;
import org.spongepowered.api.statistic.EntityStatistic;
import org.spongepowered.api.statistic.StatisticGroup;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.Texts;
import org.spongepowered.api.text.title.Titles;
import org.spongepowered.api.util.TextMessageException;

import java.io.FileNotFoundException;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
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
        return has(DisplayNameData.class)
                ? Texts.legacy().to(getHandle().getDisplayNameData().getDisplayName())
                : getName();
    }

    @Override
    @SuppressWarnings("deprecation")
    public void setDisplayName(String name) {
        try {
            getHandle().offer(getHandle().getDisplayNameData().setDisplayName(Texts.legacy().from(name)));
        } catch (TextMessageException ex) {
            throw new IllegalArgumentException(ex);
        }
    }

    @Override
    @SuppressWarnings("deprecation")
    public String getPlayerListName() {
        Optional<PlayerTabInfo> info = this.getHandle().getTabList().getPlayer(this.getUniqueId());
        return info.isPresent() ? Texts.legacy().to(info.get().getDisplayName()) : this.getDisplayName();
    }

    @Override
    @SuppressWarnings("deprecation")
    public void setPlayerListName(String name) {
        Optional<PlayerTabInfo> info = this.getHandle().getTabList().getPlayer(this.getUniqueId());
        if (info.isPresent()) {
            try {
                info.get().setDisplayName(Texts.legacy().from(name));
            } catch (TextMessageException ex) {
                throw new IllegalArgumentException(ex);
            }
        }
    }

    @Override
    public Location getCompassTarget() {
        throw new NotImplementedException("TODO");
    }

    @Override
    public void setCompassTarget(Location loc) {
        throw new NotImplementedException("TODO");
    }

    @Override
    public InetSocketAddress getAddress() {
        return getHandle().getConnection().getAddress();
    }

    @Override
    public boolean isConversing() {
        throw new NotImplementedException("TODO");
    }

    @Override
    public void acceptConversationInput(String input) {
        throw new NotImplementedException("TODO");
    }

    @Override
    public boolean beginConversation(Conversation conversation) {
        throw new NotImplementedException("TODO");
    }

    @Override
    public void abandonConversation(Conversation conversation) {
        throw new NotImplementedException("TODO");
    }

    @Override
    public void abandonConversation(Conversation conversation, ConversationAbandonedEvent details) {
        throw new NotImplementedException("TODO");
    }

    @Override
    public void sendRawMessage(String message) {
        this.sendMessage(message);
    }

    @Override
    public void kickPlayer(String message) {
        throw new NotImplementedException("TODO");
    }

    @Override
    public void chat(String msg) {
        throw new NotImplementedException("TODO");
    }

    @Override
    public boolean performCommand(String command) {
        throw new NotImplementedException("TODO");
    }

    @Override
    public boolean isSneaking() {
        return has(SneakingData.class);
    }

    @Override
    public void setSneaking(boolean sneak) {
        if (sneak != isSneaking()) {
            if (sneak) {
                set(getOrCreate(SneakingData.class));
            } else {
                remove(SneakingData.class);
            }
        }
    }

    @Override
    public boolean isSprinting() {
        throw new NotImplementedException("TODO");
    }

    @Override
    public void setSprinting(boolean sprinting) {
        throw new NotImplementedException("TODO");
    }

    @Override
    public void saveData() {
        throw new NotImplementedException("TODO");
    }

    @Override
    public void loadData() {
        throw new NotImplementedException("TODO");
    }

    @Override
    public boolean isSleepingIgnored() {
        //TODO: This feature is deeply implemented in CB, so I have no damn clue how we're going to manage to implement
        // this on top of Sponge short of mixins (which is obviously a really bad idea).
        throw new NotImplementedException("TODO");
    }

    @Override
    public void setSleepingIgnored(boolean isSleeping) {
        //TODO: Same deal here. I commented the NotImplementedExcpetion out temporarily to keep Essentials from
        // freaking out every two seconds when it tries to call this method from a scheduler.
        //throw new NotImplementedException("TODO");
    }

    @Override
    public void playNote(Location loc, byte instrument, byte note) {
        throw new NotImplementedException("TODO");
    }

    @Override
    public void playNote(Location loc, Instrument instrument, Note note) {
        throw new NotImplementedException("TODO");
    }

    @Override
    public void playSound(Location location, Sound sound, float volume, float pitch) {
        getHandle().playSound(SoundConverter.of(sound), VectorConverter.create3d(location), volume, pitch);
    }

    @Override
    public void playSound(Location location, String sound, float volume, float pitch) {
        // TODO: Isn't the String sound the ID and not the name?
        //TODO: no idea whether this is right
        Optional<SoundType> spongeSound = Pore.getGame().getRegistry().getType(SoundType.class, sound);
        if (spongeSound.isPresent()) {
            getHandle().playSound(spongeSound.get(), VectorConverter.create3d(location), volume, pitch);
        }
    }

    @Override
    public void playEffect(Location loc, Effect effect, int data) {
        throw new NotImplementedException("TODO");
    }

    @Override
    public <T> void playEffect(Location loc, Effect effect, T data) {
        throw new NotImplementedException("TODO");
    }

    @Override
    public void sendBlockChange(Location loc, Material material, byte data) {
        throw new NotImplementedException("TODO");
    }

    @Override
    public boolean sendChunkChange(Location loc, int sx, int sy, int sz, byte[] data) {
        throw new NotImplementedException("TODO");
    }

    @Override
    public void sendBlockChange(Location loc, int material, byte data) {
        throw new NotImplementedException("TODO");
    }

    @Override
    public void sendSignChange(Location loc, String[] lines) throws IllegalArgumentException {
        throw new NotImplementedException("TODO");
    }

    @Override
    public void sendMap(MapView map) {
        throw new NotImplementedException("TODO");
    }

    @Override
    public void updateInventory() {
        throw new NotImplementedException("TODO");
    }

    @Override
    public void awardAchievement(Achievement achievement) {
        getOrCreate(AchievementData.class).add(AchievementConverter.of(achievement));
    }

    @Override
    public void removeAchievement(Achievement achievement) { //TODO: no idea whether this is right
        List<org.spongepowered.api.statistic.achievement.Achievement> list = get(AchievementData.class).getAll();
        if (list.contains(AchievementConverter.of(achievement))) {
            for (int i = 0; i < list.size(); i++) {
                if (get(AchievementData.class).get(i).get() == AchievementConverter.of(achievement)) {
                    get(AchievementData.class).remove(i);
                }
            }
        }
    }

    @Override
    public boolean hasAchievement(Achievement achievement) {
        return get(AchievementData.class).contains(AchievementConverter.of(achievement));
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
        getOrCreate(StatisticData.class).set(StatisticConverter.asStdStat(statistic), (long) amount);
    }

    @Override
    public void decrementStatistic(Statistic statistic, int amount) throws IllegalArgumentException {
        incrementStatistic(statistic, -amount);
    }

    @Override
    public void setStatistic(Statistic statistic, int newValue) throws IllegalArgumentException {
        checkNotNull(statistic, "Statistic must not be null");
        getOrCreate(StatisticData.class).set(StatisticConverter.asStdStat(statistic), (long) newValue);
    }

    @Override
    public int getStatistic(Statistic statistic) throws IllegalArgumentException {
        checkNotNull(statistic, "Statistic must not be null");
        return get(StatisticData.class).get(StatisticConverter.asStdStat(statistic)).or(0L).intValue();
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
        return get(StatisticData.class).get(stat.get()).or(0L).intValue();
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
        getOrCreate(StatisticData.class).set(stat.get(), (long) amount);
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
        getOrCreate(StatisticData.class).set(stat.get(), (long) newValue);
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
        return get(StatisticData.class).get(stat.get()).or(0L).intValue();
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
        getOrCreate(StatisticData.class).set(stat.get(), (long) amount);
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
        getOrCreate(StatisticData.class).set(stat.get(), (long) newValue);
    }

    @Override
    public void setPlayerTime(long time, boolean relative) {
        throw new NotImplementedException("TODO");
    }

    @Override
    public long getPlayerTime() {
        throw new NotImplementedException("TODO");
    }

    @Override
    public long getPlayerTimeOffset() {
        throw new NotImplementedException("TODO");
    }

    @Override
    public boolean isPlayerTimeRelative() {
        throw new NotImplementedException("TODO");
    }

    @Override
    public void resetPlayerTime() {
        throw new NotImplementedException("TODO");
    }

    @Override
    public void setPlayerWeather(WeatherType type) {
        throw new NotImplementedException("TODO");
    }

    @Override
    public WeatherType getPlayerWeather() {
        throw new NotImplementedException("TODO");
    }

    @Override
    public void resetPlayerWeather() {
        throw new NotImplementedException("TODO");
    }

    @Override
    public void giveExp(int amount) {
        this.get(ExperienceHolderData.class).setTotalExperience(
                this.get(ExperienceHolderData.class).getTotalExperience() + amount);
    }

    @Override
    public void giveExpLevels(int amount) {
        this.get(ExperienceHolderData.class).setLevel(this.get(ExperienceHolderData.class).getLevel() + amount);
    }

    @Override
    public float getExp() {
        return this.get(ExperienceHolderData.class).getExperienceSinceLevel()
                / this.get(ExperienceHolderData.class).getExperienceBetweenLevels();
    }

    @Override
    public void setExp(float exp) {
        this.get(ExperienceHolderData.class).setExperienceSinceLevel(
                (int) (this.get(ExperienceHolderData.class).getExperienceBetweenLevels() * exp));
    }

    @Override
    public int getLevel() {
        return this.get(ExperienceHolderData.class).getLevel();
    }

    @Override
    public void setLevel(int level) {
        this.get(ExperienceHolderData.class).setLevel(level);
    }

    @Override
    public int getTotalExperience() {
        return this.get(ExperienceHolderData.class).getTotalExperience();
    }

    @Override
    public void setTotalExperience(int exp) {
        this.get(ExperienceHolderData.class).setTotalExperience(exp);
    }

    @Override
    public float getExhaustion() {
        return (float) get(FoodData.class).getExhaustion();
    }

    @Override
    public void setExhaustion(float value) {
        get(FoodData.class).setExhaustion(value);
    }

    @Override
    public float getSaturation() {
        return (float) get(FoodData.class).getSaturation();
    }

    @Override
    public void setSaturation(float value) {
        get(FoodData.class).setSaturation(value);
    }

    @Override
    public int getFoodLevel() {
        return (int) this.get(FoodData.class).getFoodLevel();
    }

    @Override
    public void setFoodLevel(int value) {
        this.get(FoodData.class).setFoodLevel(value);
    }

    @Override
    public boolean isOnline() {
        return getHandle().isOnline();
    }

    @Override
    public boolean isBanned() {
        throw new NotImplementedException("TODO");//TODO: Use the BanService
    }

    @Override
    public void setBanned(boolean banned) {
        throw new NotImplementedException("TODO");//TODO: Use the BanService
    }

    @Override
    public boolean isWhitelisted() {
        return has(WhitelistData.class);
    }

    @Override
    public void setWhitelisted(boolean value) {
        if (value != isWhitelisted()) {
            if (value) {
                set(getOrCreate(WhitelistData.class));
            } else {
                remove(WhitelistData.class);
            }
        }
    }

    @Override
    public org.bukkit.entity.Player getPlayer() {
        return this;
    }

    @Override
    public long getFirstPlayed() {
        return get(JoinData.class).getFirstPlayed().getTime();
    }

    @Override
    public long getLastPlayed() {
        return get(JoinData.class).getLastPlayed().getTime();
    }

    @Override
    public boolean hasPlayedBefore() {
        throw new NotImplementedException("TODO");
    }

    @Override
    public Location getBedSpawnLocation() {
        return has(RespawnLocationData.class)
                ? LocationConverter.of(get(RespawnLocationData.class).getRespawnLocation())
                : getWorld().getSpawnLocation();
    }

    @Override
    public void setBedSpawnLocation(Location location) {
        setBedSpawnLocation(location, false);
    }

    @Override
    public void setBedSpawnLocation(Location location, boolean force) {
        org.spongepowered.api.world.Location spongeLoc = LocationConverter.of(location);
        //noinspection ConstantConditions
        if (force || spongeLoc.getBlockType() == BlockTypes.BED) {
            getOrCreate(RespawnLocationData.class).setRespawnLocation(spongeLoc);
        }
    }

    @Override
    public void hidePlayer(org.bukkit.entity.Player player) {
        if (!(player instanceof PorePlayer)) { // not sure why this might return false, but just in case
            throw new UnsupportedOperationException("Cannot check invisibility status of non-wrapped player");
        }
        ((PorePlayer) player).get(InvisibilityData.class).setInvisibleTo(this.getHandle(), true);
    }

    @Override
    public void showPlayer(org.bukkit.entity.Player player) {
        if (!(player instanceof PorePlayer)) { // not sure why this might return false, but just in case
            throw new UnsupportedOperationException("Cannot check invisibility status of non-wrapped player");
        }
        ((PorePlayer) player).get(InvisibilityData.class).setInvisibleTo(this.getHandle(), false);
    }

    @Override
    public boolean canSee(org.bukkit.entity.Player player) {
        if (!(player instanceof PorePlayer)) { // not sure why this might return false, but just in case
            throw new UnsupportedOperationException("Cannot check invisibility status of non-wrapped player");
        }
        return ((PorePlayer) player).get(InvisibilityData.class).isInvisibleTo(this.getHandle());
    }

    @Override
    public boolean isFlying() {
        return this.has(FlyingData.class);
    }

    @Override
    public void setFlying(boolean value) {
        if (value != isFlying()) {
            if (value) {
                this.set(getOrCreate(FlyingData.class));
            } else {
                this.remove(FlyingData.class);
            }
        }
    }

    //TODO: movement speeds and flight toggle will be included with the attributes API
    @Override
    public boolean getAllowFlight() {
        return has(FlyingData.class);
    }

    @Override
    public void setAllowFlight(boolean flight) {
        if (!has(FlyingData.class)) {
            set(getOrCreate(FlyingData.class));
        }
    }

    @Override
    public float getWalkSpeed() {
        throw new NotImplementedException("TODO");
    }

    @Override
    public void setWalkSpeed(float value) throws IllegalArgumentException {
        throw new NotImplementedException("TODO");
    }

    @Override
    public float getFlySpeed() {
        throw new NotImplementedException("TODO");
    }

    @Override
    public void setFlySpeed(float value) throws IllegalArgumentException {
        throw new NotImplementedException("TODO");
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
        throw new NotImplementedException("TODO");
    }

    @Override
    public double getHealthScale() {
        throw new NotImplementedException("TODO");
    }

    @Override
    public Entity getSpectatorTarget() {
        throw new NotImplementedException("TODO");
    }

    @Override
    public void setSpectatorTarget(Entity entity) {
        throw new NotImplementedException("TODO");
    }

    @Override
    @SuppressWarnings("deprecation")
    public void sendTitle(String title, String subtitle) {
        getHandle().sendTitle(Titles.of(Texts.legacy().fromUnchecked(title), Texts.legacy().fromUnchecked(subtitle)));
    }

    @Override
    public void resetTitle() {
        getHandle().resetTitle();
    }

    @Override
    public void setHealthScaled(boolean scale) {
        throw new NotImplementedException("TODO");
    }

    @Override
    public void setHealthScale(double scale) throws IllegalArgumentException {
        throw new NotImplementedException("TODO");
    }

    @Override
    @SuppressWarnings("deprecation")
    public void sendMessage(String message) {
        try {
            getHandle().sendMessage(Texts.legacy().from(message));
        } catch (TextMessageException ex) {
            throw new IllegalArgumentException(ex);
        }
    }

    @Override
    @SuppressWarnings("deprecation")
    public void sendMessage(String[] messages) {
        Text[] texts = new Text[messages.length];
        for (int i = 0; i < messages.length; i++) {
            try {
                texts[i] = Texts.legacy().from(messages[i]);
            } catch (TextMessageException ex) {
                throw new IllegalArgumentException(ex);
            }
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
        throw new NotImplementedException("TODO");
    }

    @Override
    public UUID getUniqueId() {
        return getHandle().getUniqueId();
    }

    @Override
    public GameMode getGameMode() {
        return GameModeConverter.of(getHandle().getGameModeData().getGameMode());
    }

    @Override
    public void setGameMode(GameMode mode) {
        GameModeData gmData = getHandle().getGameModeData();
        gmData.setGameMode(GameModeConverter.of(mode));
        getHandle().offer(gmData);
    }
}
