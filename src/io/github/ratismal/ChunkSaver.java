package io.github.ratismal;

import java.util.HashSet;

import org.bukkit.ChatColor;
import org.bukkit.Chunk;
import org.bukkit.World;
import org.bukkit.World.Environment;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.event.player.PlayerTeleportEvent.TeleportCause;
import org.bukkit.plugin.java.JavaPlugin;

public class EndReset extends JavaPlugin {


	private BlockChangeEvent blockChangeEvent;
	private Config pluginconfig;
	
	public void onEnable() {
	  this.pluginconfig = new Config(getConfig());
		expierenceDistributerManager.setup();
		getServer().getPluginManager().registerEvents(new BlockChangeEvent(this), this);
		saveDefaultConfig();
		//configmanager = new Config(getConfig());
		//loadConfig();
    System.out.println("[ChunkSaver] Plugin enabled!");
	}

	@Override
	public void onDisable() {
		System.out.println("[ChunkSaver] Plugin disabled!");
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String commandLabel, String[] args) {
		return false;
	}
}
