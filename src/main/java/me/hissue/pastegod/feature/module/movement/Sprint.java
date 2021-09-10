package me.hissue.pastegod.feature.module.movement;

import me.hissue.pastegod.feature.module.Category;
import me.hissue.pastegod.feature.module.Module;
import me.hissue.pastegod.feature.settings.Setting;
import me.hissue.pastegod.feature.settings.SettingBuilder;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class Sprint extends Module {

	private Setting<Boolean> rage = new SettingBuilder<>(true).name("Rage").description("Always sprints.").build(this);

	public Sprint() {
		super("Sprint", "Automatically sprints for you.", Category.MOVEMENT);
	}

	@SubscribeEvent
	public void onTick(TickEvent.ClientTickEvent event) {
		if (nullCheck()) return;

		if (mc.player.getFoodStats().getFoodLevel() < 6) {
			mc.player.setSprinting(mc.gameSettings.keyBindSprint.isKeyDown());
			return;
		}
		mc.player.setSprinting(!rage.getValue() || (mc.gameSettings.keyBindForward.isKeyDown() &&
						!mc.player.collidedHorizontally &&
						!mc.player.isSneaking()));
	}

	@Override
	public void onDisable() {
		if (nullCheck()) return;

		mc.player.setSprinting(mc.gameSettings.keyBindSprint.isKeyDown());
	}
}
