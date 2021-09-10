package me.hissue.pastegod.manager.feature;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import me.hissue.pastegod.feature.hud.HudComponent;
import me.hissue.pastegod.manager.Manager;
import me.hissue.pastegod.utils.client.ReflectionUtil;

public class HudManager extends Manager {

	private final List<HudComponent> components = new ArrayList<>();

	public HudManager() {
		MinecraftForge.EVENT_BUS.register(this);
		try {
			Set<Class<?>> classes = ReflectionUtil.findClasses(HudComponent.class.getPackage().getName(), HudComponent.class);
			for (Class<?> clazz : classes) {
				HudComponent component = (HudComponent) clazz.newInstance();
				this.addComponent(component);
			}
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
	}

	public void addComponent(HudComponent component) { this.components.add(component); }

	@SubscribeEvent
	public void onRender(TickEvent.RenderTickEvent event) {
		for (HudComponent component : components)
			if (component.enabled)
				component.render(event.renderTickTime);
	}

	public HudComponent getComponent(String name) {
		return this.components.stream()
				.filter(component -> component.name.equalsIgnoreCase(name))
				.findFirst()
				.orElse(null);
	}
	public HudComponent getComponent(Class<? extends HudComponent> clazz) {
		return this.components.stream()
				.filter(component -> component.getClass() == clazz)
				.findFirst()
				.orElse(null);
	}

	public List<HudComponent> getComponents() {
		return this.components;
	}
	
}
