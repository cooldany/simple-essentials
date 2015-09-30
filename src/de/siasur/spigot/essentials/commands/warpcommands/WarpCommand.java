package de.siasur.spigot.essentials.commands.warpcommands;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.siasur.spigot.essentials.helper.WarpHelper;

public class WarpCommand implements CommandExecutor {
	
	WarpHelper helper = new WarpHelper();

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (args.length != 1) {
			return false;
		}
		
		String warpName = args[0];
		
		// Command issued by Player
		if (sender instanceof Player) {
			Player player = (Player) sender;
			Location destination = helper.getWarplocation(warpName);
			if (destination == null) {
				sender.sendMessage("Warp " + warpName + " konnte nicht gefunden werden!");
				return true;
			}
				
				player.teleport(destination);
		}
		
		sender.sendMessage("Der Command " + label + " kann nur als Spieler ausgeführt werden!");
		return true;
	}
}
