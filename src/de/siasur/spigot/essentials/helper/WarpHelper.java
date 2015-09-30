package de.siasur.spigot.essentials.helper;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.ConfigurationSection;

import de.siasur.spigot.essentials.Essentials;

public class WarpHelper {

	public Location getWarplocation(String warp) {
		return getWarplocation(warp, Essentials.instance.getConfig().getBoolean("warp.directional"));
	}	
	
	public Location getWarplocation(String warp, Boolean directional) {
		ConfigurationSection warpSection = Essentials.instance.warpConfig.getConfigurationSection(warp);
		String worldName = warpSection.getString("world");
		World world = Bukkit.getWorld(worldName);
		
		// TODO Vernünftig implementieren... :D
		
		return null;
	}
	
}
