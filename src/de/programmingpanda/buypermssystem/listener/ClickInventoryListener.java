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
import net.luckperms.api.context.DefaultContextKeys;
import net.luckperms.api.model.user.User;
import net.luckperms.api.node.types.PermissionNode;

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
						if (event.getSlot() <= 35 && event.getSlot() >= 9) {
							Permission currentPermission = PermissionsManager.getPermission(event.getCurrentItem()
									.getItemMeta().getDisplayName().replace(".", "").substring(2));
							for (Permission permission : PermissionsManager.getPermissions()) {
								if (permission.getDisplayName().equalsIgnoreCase(event.getCurrentItem().getItemMeta().getDisplayName().substring(2))) {
									currentPermission = permission;
									break;
								}

							}

							if (!(player.hasPermission(currentPermission.getPermission()))) {
								if (player.hasPermission("group." + currentPermission.getGroup())) {
									if (MainActivity.getEconomy().getBalance(player.getName()) >= currentPermission
											.getPrice()) {
										Data.isinconfirmMenu.put(player, currentPermission);
										Inventorys.fillconfirmGUI(player);
										player.openInventory(Inventorys.getConfirmGUI());
										player.sendMessage("§7[§eBPS§7] §a» §7Du musst nun nur noch den Kauf bestätigen§8!");

									} else {
										player.sendMessage("§7[§eBPS§7] §a» §7Du hast nicht genug Geld für diese Permission§8!");

									}

								} else {
									player.sendMessage("§7[§eBPS§7] §a» §7Für den Kauf der Permission benötigtst du den Rang§8: §6"+ currentPermission.getGroup() + "§8!");

								}

							} else {
								player.sendMessage("§7[§eBPS§7] §a» §7Du besitzt diese Permission bereits§8!");

							}

						}

					}
					
				}

			} else if (event.getInventory().equals(Inventorys.getConfirmGUI())) {
				event.setCancelled(true);
				if (event.getCurrentItem().getType() == Material.GREEN_STAINED_GLASS_PANE) {
					confirmPurchase(player);

				} else if (event.getCurrentItem().getType() == Material.RED_STAINED_GLASS_PANE) {
					player.closeInventory();
					Data.isinconfirmMenu.remove(player, Data.isinconfirmMenu.get(player));
					player.openInventory(Inventorys.getPermissionsGUI());

				}

			}

		}

	}

	private void confirmPurchase(Player player) {
		Permission currentPermission = Data.isinconfirmMenu.get(player);

		MainActivity.getEconomy().withdrawPlayer(player, Data.isinconfirmMenu.get(player).getPrice());
		player.sendMessage("§7[§eBPS§7] §a» §7Du halst erfolgreich die Permissions §6"
				+ currentPermission.getPermission() + " §7gekauft§8!");

		// Adding the Permission to the Player

		PermissionNode permissionNode = null;

		if (currentPermission.getWorld().equalsIgnoreCase("Alle")
				&& currentPermission.getServer().equalsIgnoreCase("Alle")) {
			permissionNode = PermissionNode.builder(currentPermission.getPermission()).build();

		} else if (currentPermission.getWorld().equalsIgnoreCase("Alle")
				&& !(currentPermission.getServer().equalsIgnoreCase("Alle"))) {
			permissionNode = PermissionNode.builder(currentPermission.getPermission())
					.withContext(DefaultContextKeys.SERVER_KEY, currentPermission.getServer()).build();

		} else if (!currentPermission.getWorld().equalsIgnoreCase("Alle")
				&& (currentPermission.getServer().equalsIgnoreCase("Alle"))) {
			permissionNode = PermissionNode.builder(currentPermission.getPermission()).build();

		} else if (!currentPermission.getWorld().equalsIgnoreCase("Alle")
				&& !(currentPermission.getServer().equalsIgnoreCase("Alle"))) {
			permissionNode = PermissionNode.builder(currentPermission.getPermission())
					.withContext(DefaultContextKeys.WORLD_KEY, currentPermission.getWorld())
					.withContext(DefaultContextKeys.SERVER_KEY, currentPermission.getServer()).build();

		}

		User user = MainActivity.getLuckPerms().getUserManager().getUser(player.getUniqueId());
		user.data().add(permissionNode);
		MainActivity.getLuckPerms().getUserManager().saveUser(user);

		Data.isinconfirmMenu.remove(player, Data.isinconfirmMenu.get(player));
		player.closeInventory();
		player.openInventory(Inventorys.getPermissionsGUI());

	}

}
