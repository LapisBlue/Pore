package net.amigocraft.pore.implementation.entity;

import org.apache.commons.lang.NotImplementedException;
import org.bukkit.*;
import org.bukkit.conversations.Conversation;
import org.bukkit.conversations.ConversationAbandonedEvent;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.map.MapView;
import org.bukkit.plugin.Plugin;
import org.bukkit.scoreboard.Scoreboard;
import org.spongepowered.api.util.Identifiable;

import java.net.InetSocketAddress;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

//TODO: bridge

public class PorePlayer extends PoreHumanEntity implements Player {

	public PorePlayer(org.spongepowered.api.entity.Player handle) {
		super(handle);
	}

	@Override
	public String getDisplayName() {
		return ((org.spongepowered.api.entity.Player)handle).getDisplayName();
	}

	@Override
	public void setDisplayName(String name) {
		throw new NotImplementedException();
	}

	@Override
	public String getPlayerListName() {
		return ((org.spongepowered.api.entity.Player)handle).getDisplayName(); //TODO: temporary measure
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
		throw new NotImplementedException();
	}

	@Override
	public boolean isConversing() {
		return false;
	}

	@Override
	public void acceptConversationInput(String input) {
		throw new NotImplementedException();
	}

	@Override
	public boolean beginConversation(Conversation conversation) {
		return false;
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
		throw new NotImplementedException();
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
		return false;
	}

	@Override
	public boolean isSneaking() {
		return false;
	}

	@Override
	public void setSneaking(boolean sneak) {
		throw new NotImplementedException();
	}

	@Override
	public boolean isSprinting() {
		return false;
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
		return false;
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
		throw new NotImplementedException();
	}

	@Override
	public void playSound(Location location, String sound, float volume, float pitch) {
		throw new NotImplementedException();
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
		return false;
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
		return false;
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
		return 0;
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
		return 0;
	}

	@Override
	public void incrementStatistic(Statistic statistic, Material material, int amount) throws IllegalArgumentException {
		throw new NotImplementedException();
	}

	@Override
	public void decrementStatistic(Statistic statistic, Material material, int amount) throws IllegalArgumentException {
		throw new NotImplementedException();
	}

	@Override
	public void setStatistic(Statistic statistic, Material material, int newValue) throws IllegalArgumentException {
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
		return 0;
	}

	@Override
	public void incrementStatistic(Statistic statistic, EntityType entityType, int amount) throws IllegalArgumentException {
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
		return 0;
	}

	@Override
	public long getPlayerTimeOffset() {
		return 0;
	}

	@Override
	public boolean isPlayerTimeRelative() {
		return false;
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
		return 0;
	}

	@Override
	public void setExp(float exp) {
		throw new NotImplementedException();
	}

	@Override
	public int getLevel() {
		return 0;
	}

	@Override
	public void setLevel(int level) {
		throw new NotImplementedException();
	}

	@Override
	public int getTotalExperience() {
		return 0;
	}

	@Override
	public void setTotalExperience(int exp) {
		throw new NotImplementedException();
	}

	@Override
	public float getExhaustion() {
		return 0;
	}

	@Override
	public void setExhaustion(float value) {
		throw new NotImplementedException();
	}

	@Override
	public float getSaturation() {
		return 0;
	}

	@Override
	public void setSaturation(float value) {
		throw new NotImplementedException();
	}

	@Override
	public int getFoodLevel() {
		return 0;
	}

	@Override
	public void setFoodLevel(int value) {
		throw new NotImplementedException();
	}

	@Override
	public boolean isOnline() {
		return false;
	}

	@Override
	public boolean isBanned() {
		return false;
	}

	@Override
	public void setBanned(boolean banned) {
		throw new NotImplementedException();
	}

	@Override
	public boolean isWhitelisted() {
		return false;
	}

	@Override
	public void setWhitelisted(boolean value) {
		throw new NotImplementedException();
	}

	@Override
	public Player getPlayer() {
		throw new NotImplementedException();
	}

	@Override
	public long getFirstPlayed() {
		return 0;
	}

	@Override
	public long getLastPlayed() {
		return 0;
	}

	@Override
	public boolean hasPlayedBefore() {
		return false;
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
		return false;
	}

	@Override
	public void setAllowFlight(boolean flight) {
		throw new NotImplementedException();
	}

	@Override
	public void hidePlayer(Player player) {
		throw new NotImplementedException();
	}

	@Override
	public void showPlayer(Player player) {
		throw new NotImplementedException();
	}

	@Override
	public boolean canSee(Player player) {
		return false;
	}

	@Override
	public boolean isFlying() {
		return false;
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
		return 0;
	}

	@Override
	public float getWalkSpeed() {
		return 0;
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
		return false;
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
		return 0;
	}

	@Override
	public void sendMessage(String message) {
		throw new NotImplementedException();
	}

	@Override
	public void sendMessage(String[] messages) {
		throw new NotImplementedException();
	}

	@Override
	public Map<String, Object> serialize() {
		throw new NotImplementedException();
	}

	@Override
	public void sendPluginMessage(Plugin source, String channel, byte[] message) {
		throw new NotImplementedException();
	}

	@Override
	public Set<String> getListeningPluginChannels() {
		throw new NotImplementedException();
	}

	@Override
	public UUID getUniqueId() {
		if (handle instanceof Identifiable) { // this should never return false, but it checks just in case
			return ((Identifiable)handle).getUniqueId();
		}
		else {
			throw new UnsupportedOperationException("getUniqueId called on non-identifiable object");
		}
	}
}
