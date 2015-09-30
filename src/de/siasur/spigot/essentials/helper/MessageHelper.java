package de.siasur.spigot.essentials.helper;

import java.util.HashMap;
import java.util.Map.Entry;

public class MessageHelper {
	
	public static String FormatMessage(String message, HashMap<String, String> replacements) {
		String msg = message;
		for (Entry<String, String> replacement : replacements.entrySet()) {
			msg = msg.replaceAll(replacement.getKey(), replacement.getValue());
		}
		
		return msg;
	}
	
}
