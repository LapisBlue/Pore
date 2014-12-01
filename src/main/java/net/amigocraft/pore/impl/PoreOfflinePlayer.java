package net.amigocraft.pore.impl;

import com.google.common.base.Optional;
import net.amigocraft.pore.impl.entity.PorePlayer;
import net.amigocraft.pore.util.PoreWrapper;
import net.amigocraft.pore.util.converter.TypeConverter;
import org.apache.commons.lang.NotImplementedException;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.spongepowered.api.entity.player.User;

import java.util.Map;
import java.util.UUID;

public class PoreOfflinePlayer extends PoreWrapper<User> implements org.bukkit.OfflinePlayer {
	private static TypeConverter<User, PoreOfflinePlayer> converter;

	static TypeConverter<User, PoreOfflinePlayer> getConverter() {
		if (converter == null) {
			converter = new TypeConverter<User, PoreOfflinePlayer>() {
				@Override
				protected PoreOfflinePlayer convert(User handle) {
					return new PoreOfflinePlayer(handle);
				}
			};
		}

		return converter;
	}

	protected PoreOfflinePlayer(User handle) {
		super(handle);
	}

	public static PoreOfflinePlayer of(User user) {
		return converter.apply(user);
	}

	@Override
	public boolean isOnline() {
		return getHandle().isOnline();
	}

	@Override
	public String getName() {
		return getHandle().getName();
	}

	@Override
	public UUID getUniqueId() {
		return getHandle().getUniqueId();
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
	public Player getPlayer() {
		Optional<org.spongepowered.api.entity.player.Player> player = getHandle().getPlayer();
		if (player.isPresent()) {
			return PorePlayer.of(player.get());
		} else {
			return null;
		}
	}

	@Override
	public long getFirstPlayed() {
		throw new NotImplementedException();
	}

	@Override
	public long getLastPlayed() {
		throw new NotImplementedException();
	}

	@Override
	public boolean hasPlayedBefore() {
		throw new NotImplementedException();
	}

	@Override
	public Location getBedSpawnLocation() {
		throw new NotImplementedException();
	}

	@Override
	public Map<String, Object> serialize() {
		throw new NotImplementedException();
	}

	@Override
	public boolean isOp() {
		throw new NotImplementedException();
	}

	@Override
	public void setOp(boolean value) {
		throw new NotImplementedException();
	}
}
