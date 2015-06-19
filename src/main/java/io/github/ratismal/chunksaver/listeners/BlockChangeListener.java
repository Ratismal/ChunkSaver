package io.github.ratismal.chunksaver.listeners;

import org.bukkit.Chunk;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockEvent;

import java.util.List;

public class BlockChangeListener implements Listener {

  public static List<Chunk> changedChunks;

  @EventHandler
  public void onBlockChange(BlockEvent e){
    Block block = e.getBlock();
    Chunk chunk = block.getChunk();
    changedChunks.add(chunk);
  }

}
