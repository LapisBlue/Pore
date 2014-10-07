package net.amigocraft.pore.implementation.map;

import org.apache.commons.lang.NotImplementedException;
import org.bukkit.World;
import org.bukkit.map.MapRenderer;
import org.bukkit.map.MapView;

import java.util.List;

public class PoreMapView implements MapView {

	// TODO: Bridge

	@Override
	public short getId() {
		return 0;
	}

	@Override
	public boolean isVirtual() {
		return false;
	}

	@Override
	public Scale getScale() {
		throw new NotImplementedException();
	}

	@Override
	public void setScale(Scale scale) {
		throw new NotImplementedException();
	}

	@Override
	public int getCenterX() {
		return 0;
	}

	@Override
	public int getCenterZ() {
		return 0;
	}

	@Override
	public void setCenterX(int x) {
		throw new NotImplementedException();
	}

	@Override
	public void setCenterZ(int z) {
		throw new NotImplementedException();
	}

	@Override
	public World getWorld() {
		throw new NotImplementedException();
	}

	@Override
	public void setWorld(World world) {
		throw new NotImplementedException();
	}

	@Override
	public List<MapRenderer> getRenderers() {
		throw new NotImplementedException();
	}

	@Override
	public void addRenderer(MapRenderer renderer) {
		throw new NotImplementedException();
	}

	@Override
	public boolean removeRenderer(MapRenderer renderer) {
		return false;
	}

}
