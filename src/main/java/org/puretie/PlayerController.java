package org.puretie;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.cyberpwn.glang.GMap;

public class PlayerController implements Listener
{
	private GMap<Player, PlayerObject> o;

	public PlayerController()
	{
		Bukkit.getPluginManager().registerEvents(this, EfficientHomes.efh);
		o = new GMap<>();
	}

	public PlayerObject get(Player p)
	{
		return o.get(p);
	}

	private void load(Player p) throws FileNotFoundException, IOException, InvalidConfigurationException
	{
		PlayerObject r = new PlayerObject(p);
		File f = new File(EfficientHomes.efh.getDataFolder(), "Players");
		File d = new File(f, p.getUniqueId().toString() + ".yml");
		r.construct(d);
		o.put(p, r);
	}

	private void save(Player p) throws IOException
	{
		PlayerObject r = o.get(p);
		File f = new File(EfficientHomes.efh.getDataFolder(), "Players");
		File d = new File(f, p.getUniqueId().toString() + ".yml");
		r.save(d);
		o.remove(p);
	}

	public void start()
	{
		for(Player i : Bukkit.getOnlinePlayers())
		{
			try
			{
				load(i);
			}
			catch(IOException | InvalidConfigurationException e)
			{
				e.printStackTrace();
			}
		}
	}

	public void stop()
	{
		for(Player i : Bukkit.getOnlinePlayers())
		{
			try
			{
				save(i);
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
		}
	}

	@EventHandler
	public void on(PlayerJoinEvent e)
	{
		try
		{
			load(e.getPlayer());
		}
		catch(IOException | InvalidConfigurationException e1)
		{
			e1.printStackTrace();
		}

	}

	@EventHandler
	public void on(PlayerQuitEvent e)
	{
		try
		{
			save(e.getPlayer());
		}
		catch(IOException e1)
		{
			e1.printStackTrace();
		}

	}
}
