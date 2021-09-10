package me.hissue.pastegod.feature.command.commands;

import me.hissue.pastegod.Client;
import me.hissue.pastegod.feature.command.Command;
import me.hissue.pastegod.feature.module.Module;
import me.hissue.pastegod.utils.client.MessageBus;

public class ToggleCommand extends Command {

	public ToggleCommand() {
		super("Toggle", "Toggles a module", "<module name>", "t");
	}

	@Override
	public boolean execute(String[] arguments) {
		if (arguments.length != 1) {
			MessageBus.sendErrorMessage("You need to supply exactly one argument!");
			return false;
		}
		Module module = Client.moduleManager.getModule(arguments[0]);
		if (module == null) {
			MessageBus.sendErrorMessage("You need to supply a valid module name!");
			return false;
		}
		module.toggle();
		return true;
	}
}
