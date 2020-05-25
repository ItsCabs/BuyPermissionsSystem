package de.programmingpanda.buypermssystem.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.programmingpanda.buypermssystem.manager.FileManager;

public class ReloadPermissionsCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

		// §7[§eBPS§7] §a» §7Die Permissions Config wurde erfolgreich gespeichert und
		// neu geladen§8!

		if (sender.hasPermission("bps.reloadpermissions")) {
			FileManager.reloadPermissions();
			sender.sendMessage((sender instanceof Player) ? "§7[§eBPS§7] §a» §7Permissions Config wurde gespeichert und neu geladen§8!"
					: "[BPS] > Permissions Config wurde gespeichert und neu geladen!");

		}

		return false;
	}

}
