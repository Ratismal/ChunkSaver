package io.github.ratismal.listeners;

import org.apocgaming.endreset.EndResetPlugin;
import org.apocgaming.endreset.game.GameHandler;
import org.apocgaming.endreset.util.MessageUtil;
import org.apocgaming.endreset.world.WorldManager;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerPortalEvent;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.scheduler.BukkitScheduler;

public class GameListener implements Listener {

  public static List<Chunk> changedChunks;

  @EventHandler
  public void onBlockChange(BlockEvent e){
    Block block = e.getBlock();
    Chunk chunk = block.getChunk();
    changedChunks.put(chunk);
  }

}
