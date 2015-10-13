package de.siasur.spigot.essentials;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.bukkit.plugin.java.JavaPlugin;

import de.siasur.spigot.essentials.commands.CommandFly;

/**
 * Simple Essentials Main Class
 * 
 * @author Mischa
 */
public class Essentials extends JavaPlugin {
	/**
	 * Holds the instance of the Plugin
	 */
	public static Essentials instance;
//	public static Localizer localizer;
	public static Boolean debugging;
	
	/**
	 * Executed when the plugin is enabled
	 */
	@Override
	public void onEnable() {
		instance = this;
		saveDefaultConfig();
		
		debugging = getConfig().getBoolean("Debugging");
		this.getLogger().log(Level.INFO, "Debugging output is " + (debugging? "enabled" : "disabled"));
		
//		localizer = new Localizer(this, "de-DE");
		
		if (debugging) {
			doDebugOutput();
		}
		
		this.getCommand("fly").setExecutor(new CommandFly());
	}
	
	private void doDebugOutput() {
		Logger logger = this.getLogger();
		logger.log(Level.INFO, "");
		
	}

	/**
	 * Executed when the plugin is disabled
	 */
	@Override
	public void onDisable() {
		instance = null;
	}
}
