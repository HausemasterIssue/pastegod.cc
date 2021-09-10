package me.hissue.pastegod.feature.module.client;

import org.lwjgl.input.Keyboard;

import me.hissue.pastegod.feature.module.Category;
import me.hissue.pastegod.feature.module.Module;
import me.hissue.pastegod.ui.editor.GuiEditor;
import me.hissue.pastegod.utils.client.MessageBus;

public class HUDEditor extends Module {

	public HUDEditor() {
		super("HUDEditor", "Enables the heads-up display editor.", Category.CLIENT, Keyboard.KEY_P);
	}

	@Override
	public void onEnable() {
		mc.displayGuiScreen(new GuiEditor());
		MessageBus.sendDebugMessage("GuiEditor enabled");
	}

	@Override
	public void onDisable() {

	}

}
