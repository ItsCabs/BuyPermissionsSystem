package de.programmingpanda.buypermssystem;

import org.bukkit.plugin.java.JavaPlugin;

import de.programmingpanda.buypermssystem.commands.AddPermissionCommand;
import de.programmingpanda.buypermssystem.commands.BuyPermissionsCommand;
import de.programmingpanda.buypermssystem.commands.ReloadPermissionsCommand;
import de.programmingpanda.buypermssystem.manager.FileManager;
import de.programmingpanda.buypermssystem.utils.Inventorys;

public class MainActivity extends JavaPlugin {

	private static MainActivity instance;

	public void onEnable() {
		System.out.println("[BuyPermissionsSystem] Plugin has started successfully!");
		System.out.println("[BuyPermissionsSystem] and was made with love by Paandaa.");

		instance = this;
		addCommands();
		FileManager.buildFile();
		Inventorys.build();

	}

	public static MainActivity getInstance() {
		return instance;
	}

	private void addCommands() {
		getCommand("prl").setExecutor(new ReloadPermissionsCommand());
		getCommand("bp").setExecutor(new BuyPermissionsCommand());
		getCommand("addp").setExecutor(new AddPermissionCommand());
		
	}

}
