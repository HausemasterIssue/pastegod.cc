package me.hissue.pastegod.feature.module.misc;

import me.hissue.pastegod.Client;
import me.hissue.pastegod.feature.module.Category;
import me.hissue.pastegod.feature.module.Module;
import me.hissue.pastegod.feature.settings.Setting;
import me.hissue.pastegod.feature.settings.SettingBuilder;
import net.minecraftforge.client.event.ClientChatEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ChatSuffix extends Module {

	public ChatSuffix() {
		super("ChatSuffix", "Appends a suffix to all your chat messages.", Category.MISC);
	}

	private final Setting<Boolean> version = new SettingBuilder<>(true)
			.name("Version")
			.description("Show the version of the client in the suffix")
			.build(this);

	@SubscribeEvent
	public void onChat(ClientChatEvent event) {
		if (event.getMessage().startsWith("/")) return;

		event.setMessage(String.format("%s | %s %s", event.getMessage(), Client.NAME, version.getValue() ? Client.VERSION : ""));
	}

}
