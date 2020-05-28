package de.programmingpanda.buypermssystem.manager;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import de.programmingpanda.buypermssystem.utils.Permission;

public class FileManager {

	private static File folder = new File("plugins/BuyPermissionsSystem");
	private static File permissions = new File("plugins/BuyPermissionsSystem", "PermissionsConfig.yml");
	private static FileConfiguration permissionsConfiguration;

	public static void buildFile() {
		permissionsConfiguration = YamlConfiguration.loadConfiguration(permissions);

		if (!folder.exists()) {
			folder.mkdir();

		}

		if (permissions.exists()) {
			try {
				permissionsConfiguration.save(permissions);
			} catch (IOException e) {
				e.printStackTrace();

			}
		} else {
			try {
				permissions.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

	}

	public static void addPermission(Permission permission) {
		String prefix = permission.getPermission().replace(".", "");
		permissionsConfiguration.set(prefix + "." + "permission", permission.getPermission());
		permissionsConfiguration.set(prefix + "." + "displayName", prefix);
		permissionsConfiguration.set(prefix + "." + "price", permission.getPrice());
		permissionsConfiguration.set(prefix + "." + "item", permission.getItem().toString());
		permissionsConfiguration.set(prefix + "." + "group", permission.getGroup());
		permissionsConfiguration.set(prefix + "." + "world", permission.getWorld());
		permissionsConfiguration.set(prefix + "." + "server", permission.getServer());
		reloadPermissions();

	}

	public static void reloadPermissions() {
		try {
			permissionsConfiguration.save(permissions);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static File getPermissionsFile() {
		return permissions;

	}

	public static FileConfiguration getPermissionsConfiguration() {
		return permissionsConfiguration;
	}

}
