package me.hissue.pastegod.event.events;

import me.hissue.pastegod.event.Event;
import net.minecraft.entity.MoverType;

public abstract class PlayerEvent extends Event {

	public PlayerEvent() {
	}

	public static class Move extends PlayerEvent {
		public MoverType type;
		public double x;
		public double y;
		public double z;

		public Move(MoverType type, double x, double y, double z) {
			this.type = type;
			this.x = x;
			this.y = y;
			this.z = z;
		}
	}

}
