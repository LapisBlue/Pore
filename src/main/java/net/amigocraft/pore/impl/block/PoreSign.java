package net.amigocraft.pore.impl.block;

import net.amigocraft.pore.util.converter.TypeConverter;
import org.apache.commons.lang.NotImplementedException;
import org.bukkit.block.Sign;
import org.spongepowered.api.block.BlockState;

public class PoreSign extends PoreBlockState implements Sign {

	private static TypeConverter<BlockState, PoreSign> converter;

	static TypeConverter<org.spongepowered.api.block.BlockState, PoreSign> getSignConverter() {
		if (converter == null) {
			converter = new TypeConverter<org.spongepowered.api.block.BlockState, PoreSign>() {
				@Override
				protected PoreSign convert(org.spongepowered.api.block.BlockState handle) {
					return new PoreSign(handle);
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
	public static PoreSign of(org.spongepowered.api.block.BlockState handle) {
		return converter.apply(handle);
	}

	protected PoreSign(org.spongepowered.api.block.BlockState handle) {
		super(handle);
	}

	@Override
	public String[] getLines() {
		throw new NotImplementedException();
	}

	@Override
	public String getLine(int index) throws IndexOutOfBoundsException {
		throw new NotImplementedException();
	}

	@Override
	public void setLine(int index, String line) throws IndexOutOfBoundsException {
		throw new NotImplementedException();
	}
}
