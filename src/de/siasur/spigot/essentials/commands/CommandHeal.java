package de.siasur.spigot.essentials.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class CommandHeal extends EssentialsCommandExecutor {
	 
	Player player;
	
	@Override
	public boolean executedByPlayer(Player player) {
		this.player = player;
		
		if (args.length == 0) {
			// Spieler heilt sich selbst
			player.setHealth(player.getMaxHealth());
			return leaveCommand("You healed yourself!");
		} else if (args.length == 1) {
			return leaveCommand(healOtherPlayer(args[0]));
		}
		
		return false;
	}
	
	@Override
	protected boolean executedByConsole(ConsoleCommandSender console) {
		if (args.length == 0) {
			return leaveCommand("Console can only be used to heal other players!");
		} else if (args.length == 1) {
			return leaveCommand(healOtherPlayer(args[0]));
		}
		return false;
	}
	
	private String healOtherPlayer(String targetName)
	{
		if (!sender.hasPermission("sessentials.heal.other")) {
			return "You are not allowed to heal other player!";
		}
		
		Player target = Bukkit.getPlayer(targetName);
		
		if (target == null) {
			return "Could not find Player " + targetName;
		}
		
		if (!target.isOnline()) {
			return "Could not heal " + targetName + " (Player is not online)";
		}
		
		target.setHealth(target.getMaxHealth());
		return "You healed " + target.getName() + "!";
	}
}
