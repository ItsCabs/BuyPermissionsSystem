package de.programmingpanda.buypermssystem.utils;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import de.programmingpanda.buypermssystem.manager.PermissionsManager;

public class Inventorys {

	private static Inventory permissionsGUI;

	public static void build() {
		permissionsGUI = Bukkit.createInventory(null, 9 * 5, "§eWant to Buy Permissions§8?");
		fillPermissionsGUI();

	}

	// Fills the permissions GUI with all buyable permissions
	private static void fillPermissionsGUI() {
		List<Permission> permissions = PermissionsManager.getPermissions();
		for (int i = 0; i != permissionsGUI.getSize(); i++) {
			for (int a = 0; a != permissions.size(); a++)
				permissionsGUI.setItem(i, new ItemStack(permissions.get(a).getItem()));

		}

	}

	public static Inventory getPermissionsGUI() {
		return permissionsGUI;
	}

}
