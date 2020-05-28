package de.programmingpanda.buypermssystem.commands;

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
				String world = args[4];
				String server = args[5];
				Permission permission = new Permission(permissionString, permissionString, price, item, rang, server, world);
				FileManager.addPermission(permission);

			} else {

				sender.sendMessage(((sender instanceof Player))
						? "§7[§eBPS§7] §a» §7Wrong Command Usage.(/addp permission price item rang"
								+ " world server)§8!"
						: "[BPS] > Wrong Command Usage(/addp permission price item rang world server!)");

			}
		}

		return false;
	}

}
