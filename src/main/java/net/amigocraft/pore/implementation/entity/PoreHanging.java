package net.amigocraft.pore.implementation.entity;

import com.google.common.collect.ImmutableMap;
import net.amigocraft.pore.util.converter.DirectionConverter;
import net.amigocraft.pore.util.converter.TypeConverter;
import org.apache.commons.lang.NotImplementedException;
import org.bukkit.block.BlockFace;
import org.spongepowered.api.entity.hanging.Hanging;
import org.spongepowered.api.entity.hanging.ItemFrame;
import org.spongepowered.api.entity.hanging.LeashHitch;
import org.spongepowered.api.entity.hanging.Painting;

public class PoreHanging extends PoreEntity implements org.bukkit.entity.Hanging {

	private static TypeConverter<Hanging, PoreHanging> converter;

	@SuppressWarnings("unchecked")
	static TypeConverter<Hanging, PoreHanging> getHangingConverter() {
		if (converter == null) {
			converter = new TypeConverter<Hanging, PoreHanging>(
					(ImmutableMap)ImmutableMap.builder()
							.put(ItemFrame.class, PoreItemFrame.getItemFrameConverter())
							.put(LeashHitch.class, PoreLeashHitch.getLeashHitchConverter())
							.put(Painting.class, PorePainting.getPaintingConverter())
							.build()
			){
				@Override
				protected PoreHanging convert(Hanging handle) {
					return new PoreHanging(handle);
				}
			};
		}
		return converter;
	}

	protected PoreHanging(Hanging handle) {
		super(handle);
	}

	@Override
	public Hanging getHandle() {
		return (Hanging)super.getHandle();
	}

	/**
	 * Returns a Pore wrapper for the given handle.
	 * If one exists, it will be retrieved; otherwise, a new wrapper instance will be created.
	 * @param handle The Sponge object to wrap.
	 * @return A Pore wrapper for the given Sponge object.
	 */
	public static PoreHanging of(Hanging handle) {
		return converter.apply(handle);
	}

	@Override
	public boolean setFacingDirection(BlockFace face, boolean force) {
		getHandle().setHangingDirection(DirectionConverter.of(face), force);
		return true; //TODO
	}

	@Override
	public BlockFace getAttachedFace() {
		throw new NotImplementedException(); //TODO
	}

	@Override
	public void setFacingDirection(BlockFace face) {
		setFacingDirection(face, false);
	}

	@Override
	public BlockFace getFacing() {
		return DirectionConverter.of(getHandle().getHangingDirection());
	}
}
