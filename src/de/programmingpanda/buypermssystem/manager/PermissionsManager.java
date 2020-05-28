package de.programmingpanda.buypermssystem.manager;

import java.util.ArrayList;

import de.programmingpanda.buypermssystem.utils.Permission;

public class PermissionsManager extends FileManager {

	// Returns an arraylist of all permissions in the permissions Config
	public static ArrayList<Permission> getPermissions() {
		ArrayList<Permission> permissions = new ArrayList<>();
		for (String current : getPermissionsConfiguration().getKeys(false)) {
			Permission permission = getPermission(current);
			permissions.add(permission);

		}

		return permissions;
	}

	// Returns a permission out of the permissions Config
	public static Permission getPermission(String permissionName) {
		String prefix = permissionName + ".";
		String permissionString = getPermissionsConfiguration().getString(prefix + "permission");
		String displayName = getPermissionsConfiguration().getString(prefix + "displayName");
		int price = getPermissionsConfiguration().getInt(prefix + "price");
		String item = getPermissionsConfiguration().getString(prefix + "item");
		String rang = getPermissionsConfiguration().getString(prefix + "group");
		String world = getPermissionsConfiguration().getString(prefix + "world");
		String server = getPermissionsConfiguration().getString(prefix + "server");

		return new Permission(permissionString, displayName, price, item, rang, server, world);

	}

}
