package me.hissue.pastegod.feature.module.client;

import org.lwjgl.input.Keyboard;

import me.hissue.pastegod.feature.module.Category;
import me.hissue.pastegod.feature.module.Module;
import me.hissue.pastegod.ui.click.GuiClick;

public class ClickGUI extends Module {

	public ClickGUI() {
		super("ClickGUI", "Enables the clickable graphical user interface.", Category.CLIENT, Keyboard.KEY_RSHIFT);
	}

	@Override
	public void onEnable() {
		mc.displayGuiScreen(new GuiClick());
	}

	@Override
	public void onDisable() {

	}
}
