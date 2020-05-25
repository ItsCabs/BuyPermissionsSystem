package de.programmingpanda.buypermssystem.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.programmingpanda.buypermssystem.utils.Inventorys;

public class BuyPermissionsCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (sender instanceof Player) {
			Player player = (Player) sender;
			player.openInventory(Inventorys.getPermissionsGUI());

		} else {
			sender.sendMessage("[BPS] > Dieser Command kann nur von einem Spieler ausgeführt werden!");

		}
		return false;
	}

}
