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
	 * Executed when the plugin is enabled
	 */
	@Override
	public void onEnable() {
		instance = this;
		verifyConfigs();
	}
	
	/**
	 * Executed when the plugin is disabled
	 */
	@Override
	public void onDisable() {
		instance = null;
	}
	
	/**
	 * Verifies that all configs are present
	 */
	private void verifyConfigs() {
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
