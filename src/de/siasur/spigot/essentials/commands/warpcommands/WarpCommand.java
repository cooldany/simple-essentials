package de.siasur.spigot.essentials.commands.warpcommands;

import org.bukkit.Bukkit;
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
		if (sender instanceof Player) {
			if (args.length == 1) {
				return doWarp((Player) sender, args[0]);
			} else if (args.length == 2) {
				return doWarp(Bukkit.getPlayer(args[0]), args[1]);
			}
		}
		
		
		return false;
	}
	
	private boolean doWarp(Player player, String warp) {
		Location target = helper.getWarplocation(warp);
		
		if (target == null) {
			player.sendMessage("Warp " + warp + " konnte nicht gefunden werden");
			return true;
		}
		
		return false;
	}

}
