package me.hissue.pastegod.event.events;

import me.hissue.pastegod.event.Event;
import net.minecraft.network.Packet;

public abstract class PacketEvent extends Event {

	private final Packet packet;

	public PacketEvent(Packet packet) {
		this.packet = packet;
	}

	public Packet getPacket() { return packet; }

	public static class Send extends PacketEvent {
		public Send(Packet packet) {
			super(packet);
		}
	}

	public static class Read extends PacketEvent {
		public Read(Packet packet) {
			super(packet);
		}
	}

}
