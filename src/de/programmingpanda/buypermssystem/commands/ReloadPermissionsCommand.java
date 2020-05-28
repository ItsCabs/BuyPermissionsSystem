package de.programmingpanda.buypermssystem.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.programmingpanda.buypermssystem.manager.FileManager;
import de.programmingpanda.buypermssystem.utils.Inventorys;

public class ReloadPermissionsCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

		if (sender.hasPermission("bps.reloadpermissions")) {
			FileManager.reloadPermissions();
			Inventorys.fillPermissionsGUI();
			sender.sendMessage((sender instanceof Player) ? "§7[§eBPS§7] §a» §7Das Plugin wurde erfolgreich neu geladen§8!"
														  : "[BPS] > Das Plugin wurde erfolgreich neu geladen!");

			
		} else {
			sender.sendMessage((sender instanceof Player)
					? "§7[§eBPS§7] §a» §7Du hast keine Rechte auf diesen Command§8!"
					: "[BPS] > Du hast keine Rechte auf diesen Command!");

		}

		return false;
	}

}
