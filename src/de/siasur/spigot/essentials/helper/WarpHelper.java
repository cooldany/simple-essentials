package de.siasur.spigot.essentials.helper;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.ConfigurationSection;

import de.siasur.spigot.essentials.Essentials;

public class WarpHelper {

	public Location getWarp(String warp) {
		return getWarp(warp, Essentials.instance.getConfig().getBoolean("warp.directional"));
	}	
	
	public Location getWarp(String warp, Boolean directional) {
		ConfigurationSection warpSection = Essentials.instance.warpConfig.getConfigurationSection(warp);
		
		if (warpSection == null) {
			return null;
		}
		
		String worldName = warpSection.getString("world");
		World world = Bukkit.getWorld(worldName);
		float yaw = (float)warpSection.getDouble("yaw", 0);
		float pitch = (float)warpSection.getDouble("pitch", 0);
		
		Location location = warpSection.getVector("location").toLocation(world, directional? yaw : 0, directional? pitch : 0);
		return location;
	}
	
	public void setWarp(String warpname, Location location) {
		setWarp(warpname, location, Essentials.instance.getConfig().getBoolean("warp.directional"));
	}
	
	public void setWarp(String warpname, Location location, Boolean directional) {
		ConfigurationSection warpSection = Essentials.instance.warpConfig.createSection(warpname);
		
		warpSection.set("location", location.toVector());
		warpSection.set("yaw", directional? location.getYaw() : 0);
		warpSection.set("pitch", directional? location.getPitch() : 0);
		
		Essentials.instance.saveConfigs();
	}
	
}
