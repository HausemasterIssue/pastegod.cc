package me.hissue.pastegod.ui.click;

import net.minecraft.client.gui.GuiScreen;

import java.awt.*;
import java.io.IOException;

import me.hissue.pastegod.Client;
import me.hissue.pastegod.feature.module.client.ClickGUI;
import me.hissue.pastegod.utils.render.Colors;

public class GuiClick extends GuiScreen {

	public static Colors colors = new Colors(new Color(0xff3f3fff), new Color(0xff3f3f3f), new Color(0xfff3f3f3));

	public GuiClick() {

	}

	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		super.drawScreen(mouseX, mouseY, partialTicks);
	}

	@Override
	protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException {
		super.mouseClicked(mouseX, mouseY, mouseButton);
	}

	@Override
	protected void mouseReleased(int mouseX, int mouseY, int state) {
		super.mouseReleased(mouseX, mouseY, state);
	}

	@Override
	protected void keyTyped(char typedChar, int keyCode) throws IOException {
		super.keyTyped(typedChar, keyCode);
	}

	@Override
	public void onGuiClosed() {
		Client.moduleManager.getModule(ClickGUI.class).setEnabled(false);
		super.onGuiClosed();
	}

}
