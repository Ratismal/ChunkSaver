package io.github.ratismal.chunksaver;

import io.github.ratismal.chunksaver.config.Config;
import io.github.ratismal.chunksaver.listeners.BlockChangeListener;
import io.github.ratismal.chunksaver.util.MessageUtil;
import org.bukkit.Chunk;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;

public class Saver extends BukkitRunnable {

    private Config config;

    public boolean running = true;

    public Saver(Config config) {
        this.config = config;
    }

    @SuppressWarnings("deprecation")
    @Override
    public void run() {
        while (running) {
            try {
                Thread.sleep(1000 * config.getSecondsUntilSave());
                MessageUtil.sendMessageToAllPlayers("Saving chunks", "chunksaver.see");
                System.out.println("[ChunkSaver] Saving chunks");
                int chunkCount = 0;
                HashMap<String, Integer> worldChunks = new HashMap<>();
                for (Chunk chunk : BlockChangeListener.changedChunks) {
                    boolean didSave = chunk.unload(true, true);
                    if (didSave) {
                        chunkCount++;
                        String worldName = chunk.getWorld().getName();
                        /** if worldChunks doesn't contain key, add it **/
                        if (!worldChunks.containsKey(worldName)) {
                            worldChunks.put(worldName, 0);
                        }
                        worldChunks.put(worldName, worldChunks.get(worldName) + 1);
                    }
                }
                MessageUtil.sendMessageToAllPlayers("[ChunkSaver] Saved " + chunkCount + " chunks", "chunksaver.see");
                System.out.println("[ChunkSaver] Saved " + chunkCount + " chunks");
                for (String key : worldChunks.keySet()) {
                    MessageUtil.sendMessageToAllPlayers("    " + key + ": " + worldChunks.get(key) + " chunks saved", "chunksaver.see");
                    System.out.println("    " + key + ": " + worldChunks.get(key) + " chunks saved");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
