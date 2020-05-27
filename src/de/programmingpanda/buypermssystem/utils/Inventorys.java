package de.programmingpanda.buypermssystem.utils;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import de.programmingpanda.buypermssystem.manager.PermissionsManager;

public class Inventorys {

	private static Inventory permissionsGUI;
	private static Inventory confirmGUI;

	public static void build() {
		permissionsGUI = Bukkit.createInventory(null, 9 * 5, "§ePermissions GUI");
		fillPermissionsGUI();

		confirmGUI = Bukkit.createInventory(null, 9 * 3, "§cKauf bestätigen");

	}

	// Fills the permissions GUI with all buyable permissions
	public static void fillPermissionsGUI() {
		List<Permission> permissions = PermissionsManager.getPermissions();
		for (int i = 0; i != permissionsGUI.getSize(); i++) {
			if (i <= 8 || i >= (9 * 5) - 9) {
				permissionsGUI.setItem(i, new ItemStack(Material.BLACK_STAINED_GLASS_PANE, 1));

			}

		}

		for (int a = 0; a != permissions.size(); a++) {
			Permission permission = permissions.get(a);
			permissionsGUI.setItem(a + 9,
					new EasyItem(permissions.get(a).getItem(), 1).setName("§b" + permission.getPermission())
							.setLore("§ePreis§7: §6" + permission.getPrice(), "§eRang§7: §6" + permission.getRang(),
									"§eWelten§7: §6"
											+ permission.getWorld().toString().replace("[", "").replace("]", ""),
									"§eServer§7: §6" + permission.getServer())
							.build());

		}

	}

	public static void fillconfirmGUI(Player player) {
		for (int i = 0; i != confirmGUI.getSize(); i++) {
			confirmGUI.setItem(i, new ItemStack(Material.BLACK_STAINED_GLASS_PANE));
		}

		confirmGUI.setItem(12,
				new EasyItem(Material.GREEN_STAINED_GLASS_PANE, 1).setName("§aKauf bestätigen")
						.setLore("§cDer Kauf der Permission " + Data.isinconfirmMenu.get(player).getPermission()," ist nicht mehr rückgängig zu machen§8!")
						.build());
		confirmGUI.setItem(14, new EasyItem(Material.RED_STAINED_GLASS_PANE, 1)
				.setName("§cKauf abbrechen§8!")
				.build());

	}

	public static Inventory getPermissionsGUI() {
		return permissionsGUI;
	}

	public static Inventory getConfirmGUI() {
		return confirmGUI;
	}

}
