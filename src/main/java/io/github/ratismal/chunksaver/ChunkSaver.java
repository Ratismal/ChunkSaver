package io.github.ratismal.chunksaver;

import io.github.ratismal.chunksaver.config.Config;
import io.github.ratismal.chunksaver.listeners.BlockChangeListener;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public class ChunkSaver extends JavaPlugin {


    private BlockChangeListener blockChangeEvent;
    private Saver saver;
    private Config pluginconfig;

    public void onEnable() {
        this.pluginconfig = new Config(getConfig());
        getServer().getPluginManager().registerEvents(new BlockChangeListener(), this);
        saveDefaultConfig();
        //configmanager = new Config(getConfig());
        //loadConfig();

        saver = new Saver(pluginconfig);
        new Thread(saver).start();

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
