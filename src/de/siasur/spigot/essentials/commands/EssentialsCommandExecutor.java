package de.siasur.spigot.essentials.commands;

import org.bukkit.command.BlockCommandSender;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.command.ProxiedCommandSender;
import org.bukkit.entity.Player;

public abstract class EssentialsCommandExecutor implements CommandExecutor {

	protected CommandSender sender;
	protected Command command;
	protected String label;
	protected String[] args;
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		
		this.sender = sender;
		this.command = command;
		this.label = label;
		this.args = args;
		
		if (this.sender instanceof Player) {
			return executedByPlayer((Player) sender);
		}
		
		if (this.sender instanceof ConsoleCommandSender) {
			return executedByConsole((ConsoleCommandSender) sender);
		}
		
		if (this.sender instanceof BlockCommandSender) {
			return executedByCommandBlock((BlockCommandSender) sender);
		}
		
		if (this.sender instanceof ProxiedCommandSender) {
			return executedByProxiedSender((ProxiedCommandSender) sender);
		}
		
		return executedByUnknownSender(sender);
	}
	
	protected boolean executedByPlayer(Player player) {
		return leaveCommand("Command " + label + " can not be executed by Player!");
	}
	
	protected boolean executedByConsole(ConsoleCommandSender console) {
		return leaveCommand("Command " + label + " can not be executed by Console!");
	}
	
	protected boolean executedByCommandBlock(BlockCommandSender block) {
		return leaveCommand("Command " + label + " can not be executed by CommandBlock!");
	}
	
	protected boolean executedByProxiedSender(ProxiedCommandSender proxiedSender) {
		return leaveCommand("Command " + label + " can not be executed by proxied Sender!");
	}
	
	protected boolean executedByUnknownSender(CommandSender commandSender) {
		return leaveCommand("Command " + label + " can not be executed by unknown sender (" + sender.getName() + ")");
	}
	
	protected boolean leaveCommand() {
		return true;
	}
	
	protected boolean leaveCommand(String message) {
		this.sender.sendMessage(message);
		return true;
	}

}
