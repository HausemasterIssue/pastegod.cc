package me.hissue.pastegod;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLLoadCompleteEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import me.hissue.pastegod.core.ClientLoader;
import me.hissue.pastegod.manager.config.ConfigManager;
import me.hissue.pastegod.manager.feature.CommandManager;
import me.hissue.pastegod.manager.feature.HudManager;
import me.hissue.pastegod.manager.feature.ModuleManager;

@Mod(modid = Client.ID, name = Client.NAME, version = Client.VERSION, certificateFingerprint = "", updateJSON = "", clientSideOnly = true)
public class Client {

	public static final String ID = "pastegod.cc";
	public static final String NAME = "pastegod.cc";
	public static final String CNAME = String.format("§d%s§r%s", NAME.charAt(0), NAME.substring(1));
	public static final String VERSION = "a0.1.0";

	public static final Logger LOGGER = LogManager.getLogger(Client.NAME + " " + Client.VERSION);

	@Instance
	public static Client INSTANCE;

	public Client() {
		INSTANCE = this;
	}

	public static ClientLoader loader;

	public static CommandManager commandManager;
	public static ConfigManager configManager;
	public static HudManager hudManager;
	public static ModuleManager moduleManager;


	@EventHandler
	public void onPreInit(FMLPreInitializationEvent event) {
		loader = new ClientLoader();
		loader.initialize();
	}

	@EventHandler
	public void onInit(FMLInitializationEvent event) {
		commandManager = new CommandManager();
		configManager = new ConfigManager();
		moduleManager = new ModuleManager();
		Display.setTitle(NAME + " " + VERSION);

		configManager.load();

		Runtime.getRuntime().addShutdownHook(new Thread(() -> configManager.save()));
	}

	@EventHandler
	public void onPostInit(FMLPostInitializationEvent event) {

	}

	@EventHandler
	public void onLoadComplete(FMLLoadCompleteEvent event) {

	}


}
