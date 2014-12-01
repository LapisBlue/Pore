package net.amigocraft.pore.impl.block;

import net.amigocraft.pore.util.converter.TypeConverter;
import org.apache.commons.lang.NotImplementedException;
import org.bukkit.Material;
import org.bukkit.block.Jukebox;
import org.spongepowered.api.block.BlockState;

public class PoreJukebox extends PoreBlockState implements Jukebox {

	private static TypeConverter<BlockState, PoreJukebox> converter;

	static TypeConverter<org.spongepowered.api.block.BlockState, PoreJukebox> getJukeboxConverter() {
		if (converter == null) {
			converter = new TypeConverter<org.spongepowered.api.block.BlockState, PoreJukebox>() {
				@Override
				protected PoreJukebox convert(org.spongepowered.api.block.BlockState handle) {
					return new PoreJukebox(handle);
				}
			};
		}

		return converter;
	}

	/**
	 * Returns a Pore wrapper for the given handle.
	 * If one exists, it will be retrieved; otherwise, a new wrapper instance will be created.
	 * @param handle The Sponge object to wrap.
	 * @return A Pore wrapper for the given Sponge object.
	 */
	public static PoreJukebox of(org.spongepowered.api.block.BlockState handle) {
		return converter.apply(handle);
	}

	protected PoreJukebox(org.spongepowered.api.block.BlockState handle) {
		super(handle);
	}

	@Override
	public Material getPlaying() {
		throw new NotImplementedException();
	}

	@Override
	public void setPlaying(Material record) {
		throw new NotImplementedException();
	}

	@Override
	public boolean isPlaying() {
		throw new NotImplementedException();
	}

	@Override
	public boolean eject() {
		throw new NotImplementedException();
	}
}
