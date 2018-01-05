package org.puretie;

import org.bukkit.plugin.java.JavaPlugin;

public class EfficientHomes extends JavaPlugin
{
	public EfficientHomes()
	{

	}

	@Override
	public void onEnable()
	{
		getCommand("efficienthomes").setExecutor(new HomeCommand());
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
