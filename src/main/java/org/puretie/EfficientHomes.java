package org.puretie;

import java.io.IOException;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.plugin.java.JavaPlugin;

public class EfficientHomes extends JavaPlugin
{
	public static EfficientHomes efh;
	public static PlayerController pc;

	public EfficientHomes()
	{

	}

	@Override
	public void onEnable()
	{
		efh = this;
		pc = new PlayerController();
		pc.start();
		getCommand("efficienthome").setExecutor(new HomeCommand());
		getCommand("efficientsethome").setExecutor(new SetHomeCommand());
		getCommand("efficienthomes").setExecutor(new HomesCommand());

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
		pc.stop();
	}

	@Override
	public void onLoad()
	{

	}
}
