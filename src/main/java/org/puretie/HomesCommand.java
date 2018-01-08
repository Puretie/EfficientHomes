package org.puretie;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HomesCommand implements CommandExecutor
{

	@Override
	public boolean onCommand(CommandSender sender, Command fullcommand, String cmd, String[] args)
	{
		if(sender instanceof Player)
		{
			Player p = (Player) sender;
			PlayerObject r = EfficientHomes.pc.get(p);
			for(String s : r.getHomes())
			{
				p.sendMessage(s);
			}
		}
		else
		{
			sender.sendMessage("Consoles don't have homes.");
		}
		return true;
	}

}
