package de.siasur.spigot.essentials;

import java.util.logging.Level;

import org.bukkit.plugin.java.JavaPlugin;

import de.siasur.spigot.essentials.commands.CommandFly;
import de.siasur.spigot.essentials.commands.CommandHeal;

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
		
		registerCommands();
	}
	
	private void registerCommands() {
		this.getCommand("fly").setExecutor(new CommandFly());
		this.getCommand("heal").setExecutor(new CommandHeal());
	}

	/**
	 * Executed when the plugin is disabled
	 */
	@Override
	public void onDisable() {
		instance = null;
	}
}
