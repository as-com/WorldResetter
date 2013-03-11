package com.andrewsun.worldresetter;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public final class WorldResetter extends JavaPlugin {

	public void onEnable(){
		File datadir=new File(getDataFolder(), null);
		if (!datadir.exists()) {
			boolean success = datadir.mkdirs();
			if (!success) {
				// Directory creation failed
				getLogger().info("WorldResetter failed to create data directory!");
			}
			else {
				getLogger().info("WorldResetter enabled!");	
			}
		}
	}

	public void onDisable(){
		getLogger().info("WorldResetter disabled!");
	}
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		if(cmd.getName().equalsIgnoreCase("resetworld")){
			if (args.length > 1) {
				sender.sendMessage(ChatColor.RED + "Usage:");
				sender.sendMessage(ChatColor.RED + "/" + cmd + " <world>");
				return true;
			}
			else {
				if (args.length < 1) {
					sender.sendMessage(ChatColor.RED + "Usage:");
					sender.sendMessage(ChatColor.RED + "/" + cmd + " <world>");
					return true;
				}
				else {
					if (Bukkit.getWorld(args[0]) == null) {
						sender.sendMessage(ChatColor.RED + "World does not exist or isn't loaded!");
						return true;
					}
					else {
						File worlddir=new File(getDataFolder() + args[0], null);
						if (!worlddir.exists()) {
							// No world backup directory
							sender.sendMessage(ChatColor.RED + "There isn't a backup for this world!");
						}
						else {
							// Import World backup
						}
						return true;
					}
				}
			}
		}
		return false;
	}
}
