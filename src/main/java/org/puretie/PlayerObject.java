package org.puretie;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.bukkit.Location;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.cyberpwn.glang.GList;
import org.cyberpwn.glang.GMap;

public class PlayerObject
{
	private final Player p;
	private GMap<String, Location> homes;

	public PlayerObject(Player p)
	{
		this.p = p;
		homes = new GMap<>();
	}

	public void setHome(String h, Location l)
	{
		homes.put(h, l);
	}

	public Location getHome(String h)
	{
		return homes.get(h);
	}

	public boolean isHome(String h)
	{
		return homes.containsKey(h);
	}

	public GList<String> getHomes()
	{
		return homes.k();
	}

	public int getHomeCount()
	{
		return getHomes().size();
	}

	public void construct(File f) throws FileNotFoundException, IOException, InvalidConfigurationException
	{
		FileConfiguration fc = new YamlConfiguration();
		if(!f.exists())
		{
			f.createNewFile();
		}
		fc.load(f);
		for(String i : fc.getKeys(true))
		{
			Location l = ConfigManager.stringtoLocation(fc.getString(i));
			setHome(i, l);
		}
	}

	public void save(File f) throws IOException
	{
		FileConfiguration fc = new YamlConfiguration();
		for(String i : getHomes())
		{
			Location l = getHome(i);
			String s = ConfigManager.locationToString(l);
			fc.set(i, s);
		}
		fc.save(f);
	}

	public Player getP()
	{
		return p;
	}

}
