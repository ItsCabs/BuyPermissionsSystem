package de.programmingpanda.buypermssystem.utils;

import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;

public class Inventorys {

	private static Inventory permissionsGUI;
	
	public static void build() {
		permissionsGUI = Bukkit.createInventory(null, 9*5, "§eWant to Buy Permissions§8?");
		fillPermissionsGUI();
		
	}
	
	private static void fillPermissionsGUI() {
		
		
	}

	public static Inventory getPermissionsGUI() {
		return permissionsGUI;
	}
	
}
