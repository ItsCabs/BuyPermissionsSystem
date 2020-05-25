package de.programmingpanda.buypermssystem.manager;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class FileManager {

	private static File permissions = new File("plugins/BuyPermissionsSystem", "PermissionsConfig.yml");
	private static FileConfiguration permissionsConfiguration;

	public void buidlFiles() {
		permissionsConfiguration = YamlConfiguration.loadConfiguration(permissions);
		
		if(!permissions.exists()) {
			try {
				permissions.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}

	}

	public File getPermissionsFile() {
		return permissions;

	}

	public FileConfiguration getPermissionsConfiguration() {
		return permissionsConfiguration;
	}

}
