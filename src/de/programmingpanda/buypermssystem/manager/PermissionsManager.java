package de.programmingpanda.buypermssystem.manager;

import java.util.ArrayList;
import java.util.List;

import de.programmingpanda.buypermssystem.utils.Permission;

public class PermissionsManager extends FileManager {

	// Returns an arraylist of all permissions in the permissions Config
	public static ArrayList<Permission> getPermissions() {
		ArrayList<Permission> permissions = new ArrayList<>();
		for (String current : getPermissionsConfiguration().getKeys(false)) {
			Permission permission = getPermission(current);
			System.out.println(permission.getPermission());
			permissions.add(permission);
			
		}
		
		return permissions;
	}
	
	// Returns a permission out of the permissions Config
	private static Permission getPermission(String permissionName) {
		String prefix = permissionName + ".";
		String permissionString = getPermissionsConfiguration().getString(prefix + "permission");
		int price = getPermissionsConfiguration().getInt(prefix + "price");
		String item = getPermissionsConfiguration().getString(prefix + "item");
		String rang = getPermissionsConfiguration().getString(prefix + "rang");
		List<String> worlds = getPermissionsConfiguration().getStringList(prefix + "worlds");
		String server = getPermissionsConfiguration().getString(prefix + "server");
		
		return new Permission(permissionString, price, item, rang, server, worlds);
	}
	
}
