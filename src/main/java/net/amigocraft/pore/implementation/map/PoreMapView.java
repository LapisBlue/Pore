package net.amigocraft.pore.implementation.map;

import java.util.List;

import org.bukkit.World;
import org.bukkit.map.MapRenderer;
import org.bukkit.map.MapView;

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
		return null;
	}

	@Override
	public void setScale(Scale scale) {
		
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
		
	}

	@Override
	public void setCenterZ(int z) {
		
	}

	@Override
	public World getWorld() {
		return null;
	}

	@Override
	public void setWorld(World world) {
		
	}

	@Override
	public List<MapRenderer> getRenderers() {
		return null;
	}

	@Override
	public void addRenderer(MapRenderer renderer) {
		
	}

	@Override
	public boolean removeRenderer(MapRenderer renderer) {
		return false;
	}

}
