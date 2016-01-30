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

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.base.Preconditions.checkState;
import static org.spongepowered.api.data.manipulator.catalog.CatalogEntityData.EXPERIENCE_HOLDER_DATA;
import static org.spongepowered.api.data.manipulator.catalog.CatalogEntityData.FLYING_DATA;
import static org.spongepowered.api.data.manipulator.catalog.CatalogEntityData.FOOD_DATA;
import static org.spongepowered.api.data.manipulator.catalog.CatalogEntityData.GAME_MODE_DATA;
import static org.spongepowered.api.data.manipulator.catalog.CatalogEntityData.JOIN_DATA;
import static org.spongepowered.api.data.manipulator.catalog.CatalogEntityData.RESPAWN_LOCATION_DATA;
import static org.spongepowered.api.data.manipulator.catalog.CatalogEntityData.SNEAKING_DATA;

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
import blue.lapis.pore.util.PoreText;

import com.flowpowered.math.vector.Vector3d;
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
import org.spongepowered.api.effect.sound.SoundType;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.entity.living.player.tab.PlayerTabInfo;
import org.spongepowered.api.profile.GameProfile;
import org.spongepowered.api.resourcepack.ResourcePacks;
import org.spongepowered.api.service.ban.BanService;
import org.spongepowered.api.service.whitelist.WhitelistService;
import org.spongepowered.api.statistic.BlockStatistic;
import org.spongepowered.api.statistic.EntityStatistic;
import org.spongepowered.api.statistic.StatisticGroup;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.title.Title;
import org.spongepowered.api.util.ban.Ban;

import java.io.FileNotFoundException;
import java.net.InetSocketAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;
import java.util.Optional;
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
    public String getDisplayName() {
        return super.getCustomName();
    }

    @Override
    public void setDisplayName(String name) {
        super.setCustomName(name);
    }

    @Override
    @SuppressWarnings("deprecation")
    public String getPlayerListName() {
        Optional<PlayerTabInfo> info = this.getHandle().getTabList().getPlayer(this.getUniqueId());
        return info.isPresent() ? PoreText.convert(info.get().getDisplayName()) : this.getDisplayName();
    }

    @Override
    @SuppressWarnings("deprecation")
    public void setPlayerListName(String name) {
        Optional<PlayerTabInfo> info = this.getHandle().getTabList().getPlayer(this.getUniqueId());
        if (info.isPresent()) {
            info.get().setDisplayName(PoreText.convert(name));
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
        return hasData(SNEAKING_DATA);
    }

    @Override
    public void setSneaking(boolean sneak) {
        if (sneak != isSneaking()) {
            if (sneak) {
                getHandle().offer(getHandle().getOrCreate(SNEAKING_DATA).get().sneaking().set(true));
            } else {
                getHandle().remove(SNEAKING_DATA);
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
        // TODO
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
        getHandle().offer(getHandle().getAchievementData().achievements().add(AchievementConverter.of(achievement)));
    }

    @Override
    public void removeAchievement(Achievement achievement) {
        getHandle().offer(getHandle().getAchievementData().achievements().remove(AchievementConverter.of(achievement)));
    }

    @Override
    public boolean hasAchievement(Achievement achievement) {
        return getHandle().getAchievementData().achievements().contains(AchievementConverter.of(achievement));
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
        setStatistic(statistic, getStatistic(statistic) + amount);
    }

    @Override
    public void decrementStatistic(Statistic statistic, int amount) throws IllegalArgumentException {
        incrementStatistic(statistic, -amount);
    }

    private void setStatistic(org.spongepowered.api.statistic.Statistic statistic, int newValue) {
        getHandle().offer(getHandle().getStatisticData().statistics()
                .put(statistic, (long) newValue));
    }

    @Override
    public void setStatistic(Statistic statistic, int newValue) throws IllegalArgumentException {
        checkNotNull(statistic, "Statistic must not be null");
        setStatistic(StatisticConverter.asStdStat(statistic), newValue);
    }

    private int getStatistic(org.spongepowered.api.statistic.Statistic statistic) {
        Long l = getHandle().getStatisticData().statistics().get().get(statistic);
        return l != null ? l.intValue() : 0;
    }

    @Override
    public int getStatistic(Statistic statistic) throws IllegalArgumentException {
        checkNotNull(statistic, "Statistic must not be null");
        checkArgument(statistic.getType() == Statistic.Type.UNTYPED, "Statistic " + statistic.toString()
                + " requires an additional parameter");
        return getStatistic(StatisticConverter.asStdStat(statistic));
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
        checkArgument(statistic.getType() == Statistic.Type.BLOCK || statistic.getType() == Statistic.Type.ITEM,
                "Statistic " + statistic.name() + " cannot accept a Material parameter");
        StatisticGroup group = StatisticConverter.asGroupStat(statistic);
        Optional<BlockStatistic> stat =
                Pore.getGame().getRegistry().getBlockStatistic(group, MaterialConverter.asBlock(material));
        if (!stat.isPresent()) {
            throw new UnsupportedOperationException("Cannot get block statistic " + statistic.name() + " for material "
                    + material.name());
        }
        return getStatistic(stat.get());
    }

    @Override
    public void setStatistic(Statistic statistic, Material material, int newValue)
            throws IllegalArgumentException {
        checkNotNull(statistic, "Statistic must not be null");
        checkState(statistic.getType() == Statistic.Type.BLOCK,
                "Statistic " + statistic.name() + " cannot accept a Material parameter");
        StatisticGroup group = StatisticConverter.asGroupStat(statistic);
        Optional<BlockStatistic> stat =
                Pore.getGame().getRegistry().getBlockStatistic(group, MaterialConverter.asBlock(material));
        if (!stat.isPresent()) {
            throw new UnsupportedOperationException("Cannot get block statistic " + statistic.name() + " for material "
                    + material.name());
        }
        setStatistic(stat.get(), newValue);
    }

    @Override
    public void incrementStatistic(Statistic statistic, Material material, int amount)
            throws IllegalArgumentException {
        setStatistic(statistic, material, getStatistic(statistic, material) + amount);
    }

    @Override
    public void decrementStatistic(Statistic statistic, Material material, int amount)
            throws IllegalArgumentException {
        incrementStatistic(statistic, material, -amount);
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
                "Statistic " + statistic.name() + " cannot accept an Entity parameter");
        StatisticGroup group = StatisticConverter.asGroupStat(statistic);
        Optional<EntityStatistic> stat =
                Pore.getGame().getRegistry().getEntityStatistic(group, EntityConverter.of(entityType));
        if (!stat.isPresent()) {
            throw new UnsupportedOperationException("Cannot get entity statistic " + statistic.name() + " for entity "
                    + entityType.name());
        }
        return getStatistic(stat.get());
    }

    @Override
    public void incrementStatistic(Statistic statistic, EntityType entityType, int amount)
            throws IllegalArgumentException {
        setStatistic(statistic, entityType, getStatistic(statistic, entityType) + amount);
    }

    @Override
    public void decrementStatistic(Statistic statistic, EntityType entityType, int amount) {
        incrementStatistic(statistic, entityType, -amount);
    }

    @Override
    public void setStatistic(Statistic statistic, EntityType entityType, int newValue) {
        checkNotNull(statistic, "Statistic must not be null");
        checkState(statistic.getType() == Statistic.Type.ENTITY,
                "Statistic " + statistic.name() + " cannot accept an entity parameter");
        StatisticGroup group = StatisticConverter.asGroupStat(statistic);
        Optional<EntityStatistic> stat =
                Pore.getGame().getRegistry().getEntityStatistic(group, EntityConverter.of(entityType));
        if (!stat.isPresent()) {
            throw new UnsupportedOperationException("Cannot get entity statistic " + statistic.name() + " for entity "
                    + entityType.name());
        }
        setStatistic(stat.get(), newValue);
    }

    @Override
    public void setPlayerTime(long time, boolean relative) {
        throw new NotImplementedException("TODO");
    }

    @Override
    public long getPlayerTime() {
        return getWorld().getTime(); // TODO
    }

    @Override
    public long getPlayerTimeOffset() {
        throw new NotImplementedException("TODO");
    }

    @Override
    public boolean isPlayerTimeRelative() {
        return true;
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
        setTotalExperience(getTotalExperience() + amount);
    }

    @Override
    public void giveExpLevels(int amount) {
        setLevel(getLevel() + amount);
    }

    @Override
    public float getExp() {
        if (!hasData(EXPERIENCE_HOLDER_DATA)) {
            return 0;
        }
        return getHandle().get(EXPERIENCE_HOLDER_DATA).get().experienceSinceLevel().get()
                / getHandle().get(EXPERIENCE_HOLDER_DATA).get().getExperienceBetweenLevels().get();
    }

    @Override
    public void setExp(float exp) {
        int newExp = (int)
                (getHandle().getOrCreate(EXPERIENCE_HOLDER_DATA).get().getExperienceBetweenLevels().get() * exp);
        //TODO: setExperienceSinceLevel(newExp)
        getHandle().get(EXPERIENCE_HOLDER_DATA).get().totalExperience();
        throw new NotImplementedException("TODO");
    }

    @Override
    public int getLevel() {
        return hasData(EXPERIENCE_HOLDER_DATA) ? getHandle().get(EXPERIENCE_HOLDER_DATA).get().level().get() : 0;
    }

    @Override
    public void setLevel(int level) {
        throw new NotImplementedException("TODO");
    }

    @Override
    public int getTotalExperience() {
        return hasData(EXPERIENCE_HOLDER_DATA)
                ? getHandle().get(EXPERIENCE_HOLDER_DATA).get().totalExperience().get()
                : 0;
    }

    @Override
    public void setTotalExperience(int exp) {
        throw new NotImplementedException("TODO");
    }

    @Override
    public float getExhaustion() {
        return getHandle().get(FOOD_DATA).get().exhaustion().get().floatValue();
    }

    @Override
    public void setExhaustion(float value) {
        getHandle().get(FOOD_DATA).get().exhaustion().set((double) value);
    }

    @Override
    public float getSaturation() {
        return getHandle().get(FOOD_DATA).get().saturation().get().floatValue();
    }

    @Override
    public void setSaturation(float value) {
        getHandle().get(FOOD_DATA).get().saturation().set((double) value);
    }

    @Override
    public int getFoodLevel() {
        return getHandle().get(FOOD_DATA).get().foodLevel().get();
    }

    @Override
    public void setFoodLevel(int value) {
        getHandle().get(FOOD_DATA).get().foodLevel().set(value);
    }

    @Override
    public boolean isOnline() {
        return getHandle().isOnline();
    }

    @Override
    public boolean isBanned() {
        Optional<BanService> bs = Pore.getGame().getServiceManager().provide(BanService.class);
        return bs.isPresent() && bs.get().isBanned(getHandle().getProfile());
    }

    @Override
    public void setBanned(boolean banned) {
        applyBan(getHandle().getProfile(), banned);
    }

    @Override
    public boolean isWhitelisted() {
        Optional<WhitelistService> ws = Pore.getGame().getServiceManager().provide(WhitelistService.class);
        return ws.isPresent() && ws.get().isWhitelisted(getHandle().getProfile());
    }

    @Override
    public void setWhitelisted(boolean value) {
        applyWhitelisting(getHandle().getProfile(), value);
    }

    public static void applyBan(GameProfile profile, boolean banned) {
        Optional<BanService> bs = Pore.getGame().getServiceManager().provide(BanService.class);
        if (bs.isPresent()) {
            if (bs.get().isBanned(profile) != banned) {
                if (banned) {
                    bs.get().addBan(Ban.of(profile));
                } else {
                    bs.get().removeBan(bs.get().getBanFor(profile).get());
                }
            }
        }
    }

    public static void applyWhitelisting(GameProfile profile, boolean value) {
        Optional<WhitelistService> ws = Pore.getGame().getServiceManager().provide(WhitelistService.class);
        if (ws.isPresent()) {
            if (ws.get().isWhitelisted(profile) != value) {
                if (value) {
                    ws.get().addProfile(profile);
                } else {
                    ws.get().removeProfile(profile);
                }
            }
        }
    }

    @Override
    public org.bukkit.entity.Player getPlayer() {
        return this;
    }

    @Override
    public long getFirstPlayed() {
        return getHandle().get(JOIN_DATA).get().firstPlayed().get().getEpochSecond();
    }

    @Override
    public long getLastPlayed() {
        return getHandle().get(JOIN_DATA).get().lastPlayed().get().getEpochSecond();
    }

    @Override
    public boolean hasPlayedBefore() {
        throw new NotImplementedException("TODO");
    }

    @Override
    public Location getBedSpawnLocation() {
        return hasData(RESPAWN_LOCATION_DATA)
                ? LocationConverter.fromVector3d(getHandle().getWorld(),
                getHandle().get(RESPAWN_LOCATION_DATA).get().respawnLocation().get().get(getWorld().getUID()))
                : null;
    }

    @Override
    public void setBedSpawnLocation(Location location) {
        setBedSpawnLocation(location, false);
    }

    @Override
    public void setBedSpawnLocation(Location location, boolean force) {
        org.spongepowered.api.world.Location<?> spongeLoc = LocationConverter.of(location);
        //noinspection ConstantConditions
        if (force || spongeLoc.getBlockType() == BlockTypes.BED) {
            getHandle().offer(getHandle().get(RESPAWN_LOCATION_DATA).get().respawnLocation().put(
                    location.getWorld().getUID(),
                    new Vector3d(location.getX(), location.getY(), location.getZ())
            ));
        }
    }

    @Override
    public void hidePlayer(org.bukkit.entity.Player player) {
        //TODO: implement this once contextual data is merged into master
    }

    @Override
    public void showPlayer(org.bukkit.entity.Player player) {
        //TODO: implement this once contextual data is merged into master
    }

    @Override
    public boolean canSee(org.bukkit.entity.Player player) {
        //TODO: implement this once contextual data is merged into master
        return true;
    }

    @Override
    public boolean isFlying() {
        return hasData(FLYING_DATA) && getHandle().get(FLYING_DATA).get().flying().get();
    }

    @Override
    public void setFlying(boolean value) {
        if (value != isFlying()) {
            if (value) {
                getHandle().offer(getHandle().getOrCreate(FLYING_DATA).get().flying().set(true));
            } else {
                getHandle().remove(FLYING_DATA);
            }
        }
    }

    //TODO: movement speeds and flight toggle will be included with the attributes API
    @Override
    public boolean getAllowFlight() {
        throw new NotImplementedException("TODO");
    }

    @Override
    public void setAllowFlight(boolean flight) {
        throw new NotImplementedException("TODO");
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
            getHandle().sendResourcePack(ResourcePacks.fromUri(new URI(url)));
        } catch (URISyntaxException | FileNotFoundException swallow) {
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
        getHandle().sendTitle(Title.of(PoreText.convert(title), PoreText.convert(subtitle)));
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
        getHandle().sendMessage(PoreText.convert(message));
    }

    @Override
    @SuppressWarnings("deprecation")
    public void sendMessage(String[] messages) {
        Text[] texts = new Text[messages.length];
        for (int i = 0; i < messages.length; i++) {
            texts[i] = PoreText.convert(messages[i]);
        }
        this.getHandle().sendMessages(texts);
    }

    @Override
    public Map<String, Object> serialize() {
        Map<String, Object> result = Maps.newLinkedHashMap();
        result.put("name", getName());
        return result;
    }

    @Override
    public void sendPluginMessage(Plugin source, String channel, byte[] message) {
        throw new NotImplementedException("TODO");
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
        return GameModeConverter.of(getHandle().getOrCreate(GAME_MODE_DATA).get().type().get());
    }

    @Override
    public void setGameMode(GameMode mode) {
        getHandle().offer(getHandle().getOrCreate(GAME_MODE_DATA).get().type().set(GameModeConverter.of(mode)));
    }
}
