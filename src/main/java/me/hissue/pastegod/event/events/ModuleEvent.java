package me.hissue.pastegod.event.events;

import me.hissue.pastegod.event.Event;
import me.hissue.pastegod.feature.module.Module;

public abstract class ModuleEvent extends Event {

	private final Module module;

	public ModuleEvent(Module module) {
		this.module = module;
	}

	public Module getModule() { return module; }

	public static class Enable extends ModuleEvent {
		public Enable(Module module) {
			super(module);
		}
	}
	public static class Disable extends ModuleEvent {
		public Disable(Module module) {
			super(module);
		}
	}

}
