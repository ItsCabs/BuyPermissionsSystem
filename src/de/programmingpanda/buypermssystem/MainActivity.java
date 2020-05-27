package de.programmingpanda.buypermssystem;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import de.programmingpanda.buypermssystem.commands.AddPermissionCommand;
import de.programmingpanda.buypermssystem.commands.BuyPermissionsCommand;
import de.programmingpanda.buypermssystem.commands.ReloadPermissionsCommand;
import de.programmingpanda.buypermssystem.listener.ClickInventoryListener;
import de.programmingpanda.buypermssystem.listener.CloseInventoryListener;
import de.programmingpanda.buypermssystem.manager.FileManager;
import de.programmingpanda.buypermssystem.utils.Inventorys;
import net.luckperms.api.LuckPerms;
import net.milkbowl.vault.economy.Economy;

public class MainActivity extends JavaPlugin {

	private static MainActivity instance;
	private static Economy economy = null;
	private static LuckPerms luckPerms;

	public void onEnable() {
		System.out.println("[BuyPermissionsSystem] Plugin has started successfully!");
		System.out.println("[BuyPermissionsSystem] and was made with love by Paandaa.");

		instance = this;
		setupLuckPerms();
		addCommands();
		setupVault();
		
		System.out.println((setupLuckPerms()) ? "[BSP] > LUCKPERMS wurde erfolgreich für BSP eingerichtet"
				: "[BSP] > Es gab einen Fehler bei der Einrichtung von LUCKPERMS!");
		
		System.out.println((setupVault()) ? "[BSP] > VAULT wurde erfolgreich für BSP eingerichtet"
				: "[BSP] > Es gab einen Fehler bei der Einrichtung von VAULT!");

		FileManager.buildFile();
		Inventorys.build();
		registerListener();

	}

	public static MainActivity getInstance() {
		return instance;
	}

	private void registerListener() {
		PluginManager pluginManager = Bukkit.getPluginManager();
		pluginManager.registerEvents(new ClickInventoryListener(), instance);
		pluginManager.registerEvents(new CloseInventoryListener(), instance);

	}

	private void addCommands() {
		getCommand("prl").setExecutor(new ReloadPermissionsCommand());
		getCommand("bp").setExecutor(new BuyPermissionsCommand());
		getCommand("addp").setExecutor(new AddPermissionCommand());

	}

	private boolean setupVault() {
		if (getServer().getPluginManager().getPlugin("Vault") == null) {
			return false;

		}

		RegisteredServiceProvider<Economy> registeredServiceProvider = getServer().getServicesManager()
				.getRegistration(Economy.class);
		if (registeredServiceProvider == null) {
			return false;

		}
		economy = registeredServiceProvider.getProvider();
		return economy != null;

	}
	
	private boolean setupLuckPerms() {
		RegisteredServiceProvider<LuckPerms> provider = Bukkit.getServicesManager().getRegistration(LuckPerms.class);
		if (provider != null) {
			luckPerms = provider.getProvider();
			return true;
			
		} else {
			return false;
			
		}
		
	}

	public static Economy getEconomy() {
		return economy;

	}

	public static LuckPerms getLuckPerms() {
		return luckPerms;
	}

}
