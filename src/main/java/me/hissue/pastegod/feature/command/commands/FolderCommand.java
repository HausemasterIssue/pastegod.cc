package me.hissue.pastegod.feature.command.commands;

import java.awt.*;
import java.net.URI;

import me.hissue.pastegod.feature.command.Command;
import me.hissue.pastegod.manager.config.ConfigManager;

public class FolderCommand extends Command {

	public FolderCommand() {
		super("Folder", "Opens the current main folder", ".folder ", "openfolder", "configfolder", "openconfigs");
	}

	@Override
	public boolean execute(String[] arguments) {
		try {
			Desktop.getDesktop().browse(URI.create(ConfigManager.MAIN_FOLDER));
			return true;
		} catch (Exception exception) {
			return false;
		}
	}
}
