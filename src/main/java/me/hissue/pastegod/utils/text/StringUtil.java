package me.hissue.pastegod.utils.text;

import me.hissue.pastegod.utils.Util;

public class StringUtil implements Util {

	public static String removeLastChar(String string) {
		return string.substring(0, string.length() - 1);
	}

}
