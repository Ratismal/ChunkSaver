package io.github.ratismal.config;

import org.bukkit.configuration.file.FileConfiguration;

public class Config {

  private int secondsUntilSave = 300;
  
  public Config(FileConfiguration config) {
		this.config = config;
		reload();
	}
	
	public void reload() {
	  secondsUntilSave = getConfig().getInt("seconds-until-save");
	}
	
	public int getSecondsUntilSave() {
	  return secondsUntilSave;
	}

}
