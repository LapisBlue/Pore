package net.amigocraft.pore.implementation.map;

import org.apache.commons.lang.NotImplementedException;
import org.bukkit.map.MapCanvas;
import org.bukkit.map.MapCursorCollection;
import org.bukkit.map.MapFont;
import org.bukkit.map.MapView;

import java.awt.*;

public class PoreMapCanvas implements MapCanvas {

	// TODO: Bridge

	@Override
	public MapView getMapView() {
		throw new NotImplementedException();
	}

	@Override
	public MapCursorCollection getCursors() {
		throw new NotImplementedException();
	}

	@Override
	public void setCursors(MapCursorCollection cursors) {
		throw new NotImplementedException();
	}

	@Override
	public void setPixel(int x, int y, byte color) {
		throw new NotImplementedException();
	}

	@Override
	public byte getPixel(int x, int y) {
		throw new NotImplementedException();
	}

	@Override
	public byte getBasePixel(int x, int y) {
		throw new NotImplementedException();
	}

	@Override
	public void drawImage(int x, int y, Image image) {
		throw new NotImplementedException();
	}

	@Override
	public void drawText(int x, int y, MapFont font, String text) {
		throw new NotImplementedException();
	}

}
