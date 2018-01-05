package org.puretie;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class HomeCommand implements CommandExecutor
{

	@Override
	public boolean onCommand(CommandSender sender, Command fullcommand, String cmd, String[] args)
	{
		sender.sendMessage("YOU DID STUFF");
		return true;
	}

}
