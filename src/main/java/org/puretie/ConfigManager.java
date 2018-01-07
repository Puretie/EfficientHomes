package org.puretie;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class ConfigManager
{
	public static FileConfiguration fc = new YamlConfiguration();

	public static void makeDataFolder()
	{
		EfficientHomes.efh.getDataFolder().mkdirs();
	}

	private static void writeConfig() throws IOException
	{

		File f = new File(EfficientHomes.efh.getDataFolder(), "config.yml");
		if(f.exists())
		{
			return;
		}

		makeDataFolder();
		f.createNewFile();
		fc.set("config.value", false);
		fc.save(f);

	}

	private static void readFileConfiguration() throws FileNotFoundException, IOException, InvalidConfigurationException
	{
		File f = new File(EfficientHomes.efh.getDataFolder(), "config.yml");
		fc.load(f);
	}

	public static void doFileConfiguration() throws IOException, InvalidConfigurationException
	{
		writeConfig();
		readFileConfiguration();
	}

	public static String locationToString(Location l)
	{
		return l.getWorld().getName() + ";" + l.getX() + ";" + l.getY() + ";" + l.getZ() + ";" + l.getYaw() + ";" + l.getPitch();
	}

	public static Location stringtoLocation(String s)
	{
		String[] par = s.split(";");
		World w = Bukkit.getWorld(par[0]);
		double x = Double.valueOf(par[1]);
		double y = Double.valueOf(par[2]);
		double z = Double.valueOf(par[3]);
		float yaw = Float.valueOf(par[4]);
		float pitch = Float.valueOf(par[5]);

		Location l = new Location(w, x, y, z, yaw, pitch);
		return l;
	}
}
