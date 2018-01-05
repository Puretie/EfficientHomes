package org.puretie;

import java.io.IOException;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.plugin.java.JavaPlugin;

public class EfficientHomes extends JavaPlugin
{
	public static EfficientHomes efh;

	public EfficientHomes()
	{

	}

	@Override
	public void onEnable()
	{
		efh = this;
		getCommand("efficienthomes").setExecutor(new HomeCommand());
		try
		{
			ConfigManager.doFileConfiguration();
		}
		catch(IOException e)
		{
			System.out.println("Something happened...");
			e.printStackTrace();
		}
		catch(InvalidConfigurationException e)
		{
			System.out.println("Y U NO CONFIG");
			e.printStackTrace();
		}
		System.out.println(ConfigManager.fc.getBoolean("config.value"));
	}

	@Override
	public void onDisable()
	{

	}

	@Override
	public void onLoad()
	{

	}
}
