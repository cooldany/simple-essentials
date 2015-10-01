package de.siasur.spigot.essentials;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import de.siasur.spigot.essentials.helper.FileHelper;

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
	
	private File languageFile;
	private File warpFile;
	
	public FileConfiguration languageConfig;
	public FileConfiguration warpConfig;
	
	/**
	 * Constructor
	 */
	public Essentials() {
		languageFile = new File(getDataFolder(), "messages.yml");
		warpFile = new File(getDataFolder(), "warps.yml");
	}
	
	/**
	 * Executed when the plugin is enabled
	 */
	@Override
	public void onEnable() {
		instance = this;
		verifyConfigs();
		
		languageConfig = new YamlConfiguration();
		warpConfig = new YamlConfiguration();
		
		try {
			languageConfig.load(languageFile);
			warpConfig.load(warpFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
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
			saveDefaultConfig();
			
			if (!languageFile.exists()) {
				FileHelper.copy(getResource("messages.yml"), languageFile);
			}
			
			if (!warpFile.exists()) {
				FileHelper.copy(getResource("warps.yml"), warpFile);
			}
	}
	
	public void saveConfigs() {
		saveConfig();
		
		try {
			warpConfig.save(warpFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
