package de.programmingpanda.buypermssystem;

import org.bukkit.plugin.java.JavaPlugin;

public class MainActivity extends JavaPlugin {

	private static MainActivity instance;
	
	public void onEnable() {
		instance = this;
		
	}

	public static MainActivity getInstance() {
		return instance;
	}
	
}
