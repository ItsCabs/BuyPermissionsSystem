package de.programmingpanda.buypermssystem;

import org.bukkit.plugin.java.JavaPlugin;

import net.luckperms.api.LuckPerms;
import net.luckperms.api.LuckPermsProvider;

public class MainActivity extends JavaPlugin {

	private static MainActivity instance;
	private static LuckPerms luckPermsAPI = LuckPermsProvider.get();
	
	public void onEnable() {
		instance = this;
		luckPermsAPI.getUserManager().getUser("lol");
	}

	public static MainActivity getInstance() {
		return instance;
	}
	
}
