package org.puretie;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetHomeCommand implements CommandExecutor
{

	@Override
	public boolean onCommand(CommandSender sender, Command fullcommand, String cmd, String[] args)
	{
		if(sender instanceof Player)
		{
			Player p = (Player) sender;
			PlayerObject r = EfficientHomes.pc.get(p);
			if(args.length == 1)
			{
				r.setHome(args[0], p.getLocation());
				sender.sendMessage("Home set!");
			}
		}
		return true;
	}

}
