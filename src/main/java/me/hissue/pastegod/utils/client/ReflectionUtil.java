package me.hissue.pastegod.utils.client;

import org.reflections.Reflections;

import me.hissue.pastegod.utils.Util;

import java.util.Set;

public class ReflectionUtil implements Util {

	public static Set<Class<?>> findClasses(String pkg, Class subType) {
		Reflections reflections = new Reflections(pkg);
		return reflections.getSubTypesOf(subType);
	}

}
