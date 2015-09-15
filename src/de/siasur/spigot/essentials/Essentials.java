package de.siasur.spigot.essentials;

import java.io.File;

import org.bukkit.plugin.java.JavaPlugin;

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
	
	/**
	 * Default Constructor
	 */
	public Essentials() {
		instance = this;
	}
	
	/**
	 * Executed when the plugin is enabled
	 */
	@Override
	public void onEnable() {
		createConfig();
	}
	
	/**
	 * Executed when the plugin is disabled
	 */
	@Override
	public void onDisable() {
		
	}
	
	/**
	 * Create the default config file if not existing
	 */
	private void createConfig() {
		if (!getDataFolder().exists()) {
			getDataFolder().mkdirs();
		}
		
		File file = new File(getDataFolder(), "config.yml");
		if (!file.exists()) {
			getLogger().info("config.yml not found, creating!");
			saveDefaultConfig();
		} else {
			getLogger().info("config.yml found, loading!");
		}
	}
}
