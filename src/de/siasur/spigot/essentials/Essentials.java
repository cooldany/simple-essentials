package de.siasur.spigot.essentials;

import java.io.File;

import org.bukkit.plugin.java.JavaPlugin;

public class Essentials extends JavaPlugin {
	
	public static Essentials instance;
	
	public Essentials() {
		instance = this;
	}
	
	@Override
	public void onEnable() {
		createConfig();
	}
	
	@Override
	public void onDisable() {
		
	}
	
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
