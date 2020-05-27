package de.programmingpanda.buypermssystem.commands;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.programmingpanda.buypermssystem.manager.FileManager;
import de.programmingpanda.buypermssystem.utils.Permission;

public class AddPermissionCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (sender.hasPermission("bps.addpermission")) {
			if (args.length == 6) {
				String permissionString = args[0];
				int price = Integer.valueOf(args[1]);
				String item = args[2];
				String rang = args[3];
				String[] worlds = args[4].substring(args[4].indexOf("[") + 1, args[4].indexOf("]")).split(",");
				List<String> worldsList = new ArrayList<String>();
				worldsList = Arrays.asList(worlds);
				String server = args[5];
				Permission permission = new Permission(permissionString, price, item, rang, server, worldsList);
				FileManager.addPermission(permission);

			} else {

				sender.sendMessage((!(sender instanceof Player))
						? "§7[§eBPS§7] §a» §7Wrong Command Usage.(/addp permission price item rang"
								+ "				 [world1,world2,world3...] server§8!"
						: "[BPS] > Permissions Config wurde gespeichert und neu geladen!");

			}
		}

		return false;
	}

}
