package org.puretie;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

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
}
