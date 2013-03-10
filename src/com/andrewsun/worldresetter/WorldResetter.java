package com.andrewsun.worldresetter;

import org.bukkit.plugin.java.JavaPlugin;
 
public final class WorldResetter extends JavaPlugin {
	public void onEnable(){
		getLogger().info("WorldResetter enabled!");
	}
 
	public void onDisable(){
		getLogger().info("WorldResetter disabled!");
	}
}