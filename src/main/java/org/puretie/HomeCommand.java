package org.puretie;

import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HomeCommand implements CommandExecutor
{

	@Override
	public boolean onCommand(CommandSender sender, Command fullcommand, String cmd, String[] args)
	{
		if(sender instanceof Player)
		{
			Player p = (Player) sender;
			PlayerObject pc = EfficientHomes.pc.get(p);
			if(args.length == 0)
			{
				if(pc.getHomeCount() == 1)
				{
					Location l = pc.getHome(pc.getHomes().get(0));
					p.teleport(l);

				}
				else if(pc.getHomeCount() == 0)
				{
					p.sendMessage("You have no homes!");
				}
				else
				{
					p.sendMessage("/home [home name]");
				}
			}
			else
			{
				String h = args[0];

				if(pc.getHomeCount() == 0)
				{
					p.sendMessage("You have no homes!");
				}
				else
				{
					boolean found = false;
					for(String i : pc.getHomes())
					{
						if(i.equalsIgnoreCase(h) || i.toLowerCase().contains(h.toLowerCase()))
						{
							Location l = pc.getHome(i);
							p.teleport(l);
							found = true;
							break;
						}
					}
					if(!found)
					{
						p.sendMessage("Can't find " + h);
					}
					else
					{
						p.sendMessage("PAOW");
						p.getWorld().playSound(p.getLocation(), Sound.BLOCK_NOTE_BELL, 1f, 1f);
					}
				}
			}
		}
		else
		{
			sender.sendMessage("Players only!");
		}
		return true;
	}

}
