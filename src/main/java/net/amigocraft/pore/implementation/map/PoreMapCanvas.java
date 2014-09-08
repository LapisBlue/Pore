package net.amigocraft.pore.implementation.map;

import java.awt.Image;

import org.bukkit.map.MapCanvas;
import org.bukkit.map.MapCursorCollection;
import org.bukkit.map.MapFont;
import org.bukkit.map.MapView;

public class PoreMapCanvas implements MapCanvas {

	// TODO: Bridge
	
	@Override
	public MapView getMapView() {
		return null;
	}

	@Override
	public MapCursorCollection getCursors() {
		return null;
	}

	@Override
	public void setCursors(MapCursorCollection cursors) {
		
	}

	@Override
	public void setPixel(int x, int y, byte color) {
		
	}

	@Override
	public byte getPixel(int x, int y) {
		return 0;
	}

	@Override
	public byte getBasePixel(int x, int y) {
		return 0;
	}

	@Override
	public void drawImage(int x, int y, Image image) {
		
	}

	@Override
	public void drawText(int x, int y, MapFont font, String text) {
		
	}

}
