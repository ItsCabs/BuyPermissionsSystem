package de.programmingpanda.buypermssystem.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;

import de.programmingpanda.buypermssystem.utils.Data;
import de.programmingpanda.buypermssystem.utils.Inventorys;

public class CloseInventoryListener implements Listener {

	@EventHandler
	public void onInventoryClose(InventoryCloseEvent event) {
		Player player = (Player) event.getPlayer();

		if (event.getInventory().equals(Inventorys.getConfirmGUI())) {
			if (Data.isinconfirmMenu.containsKey(player)) {
				player.sendMessage("§7[§eBPS§7] §a» §7Du hast den Kauf der Permission §6" + Data.isinconfirmMenu.get(player).getGroup() + " §7abgebrochen§8!");

			}
		}

	}

}
