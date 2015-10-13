package de.siasur.spigot.essentials.commands;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import de.siasur.spigot.essentials.Essentials;

public class CommandFly implements CommandExecutor, TabCompleter {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (!Essentials.instance.getServer().getAllowFlight()) {
			sender.sendMessage("Fly is not enabled!");
			return true;
		}
		
		if (sender instanceof Player) {
			Player player = (Player)sender;
			player.setAllowFlight(!player.getAllowFlight());
		}
		
		return false;
	}

	@Override
	public List<String> onTabComplete(CommandSender sender, Command cmd, String label, String[] args) {
		// TODO Dies ist ein sinnloser Test
		
		List<String> ds = new ArrayList<String>();
		ds.add("huhu");
		
		return ds;
	}

}
