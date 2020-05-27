package de.programmingpanda.buypermssystem.listener;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import de.programmingpanda.buypermssystem.MainActivity;
import de.programmingpanda.buypermssystem.manager.PermissionsManager;
import de.programmingpanda.buypermssystem.utils.Data;
import de.programmingpanda.buypermssystem.utils.Inventorys;
import de.programmingpanda.buypermssystem.utils.Permission;

public class ClickInventoryListener implements Listener {

	@SuppressWarnings("deprecation")
	@EventHandler
	public void onInventoryClick(InventoryClickEvent event) {
		Player player = (Player) event.getWhoClicked();

		if (event.getCurrentItem() != null) {
			if (event.getInventory().equals(Inventorys.getPermissionsGUI())) {
				event.setCancelled(true);
				if (event.getCurrentItem().getType() != Material.BLACK_STAINED_GLASS_PANE) {
					if (event.getCurrentItem().getType() != Material.AIR) {
						Permission currentPermission = PermissionsManager.getPermission(
								event.getCurrentItem().getItemMeta().getDisplayName().replace(".", "").substring(2));
						if (MainActivity.getEconomy().getBalance(player.getName()) >= currentPermission.getPrice()) {
							Data.isinconfirmMenu.put(player, currentPermission);
							Inventorys.fillconfirmGUI(player);
							player.openInventory(Inventorys.getConfirmGUI());
							player.sendMessage("§7[§eBPS§7] §a» §7Du musst nun nur noch den Kauf bestätigen§8!");

						} else {
							player.sendMessage("§7[§eBPS§7] §a» §7Du hast nicht genug Geld für diese Permission§8!");

						}

					}

				}

			} else if (event.getInventory().equals(Inventorys.getConfirmGUI())) {
				event.setCancelled(true);
				if (event.getCurrentItem().getType() == Material.GREEN_STAINED_GLASS_PANE) {
					MainActivity.getEconomy().bankWithdraw(player.getName(),
							Data.isinconfirmMenu.get(player).getPrice());
					player.sendMessage("§7[§eBPS§7] §a» §7Du halst erfolgreich die Permissions §6"
							+ Data.isinconfirmMenu.get(player).getPermission() + " §7gekauft§8!");
					Data.isinconfirmMenu.remove(player, Data.isinconfirmMenu.get(player));
					player.closeInventory();
					player.openInventory(Inventorys.getPermissionsGUI());

				} else if (event.getCurrentItem().getType() == Material.RED_STAINED_GLASS_PANE) {
					player.closeInventory();
					Data.isinconfirmMenu.remove(player, Data.isinconfirmMenu.get(player));
					player.openInventory(Inventorys.getPermissionsGUI());
					
				}

			}

		}

	}

}
