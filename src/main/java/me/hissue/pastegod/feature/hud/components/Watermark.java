package me.hissue.pastegod.feature.hud.components;

import java.awt.*;

import me.hissue.pastegod.Client;
import me.hissue.pastegod.feature.hud.HudComponent;

public class Watermark extends HudComponent {

	public Watermark() {
		super("Watermark", "Shows a watermark with the name of the client", new Point(2, 2));
		this.setEnabled(true);
	}

	private final String watermark = String.format("%s v%s", Client.CNAME, Client.VERSION);

	@Override
	public void render(float ticks) {
		mc.fontRenderer.drawString(watermark, location.x, location.y, 0xffffffff);
	}

	public int width() { return mc.fontRenderer.getStringWidth(watermark); }
	public int height() { return mc.fontRenderer.FONT_HEIGHT; }

}
