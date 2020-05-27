package de.programmingpanda.buypermssystem.utils;

import java.util.Arrays;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class EasyItem {

	public static ItemStack easyItem;
	private ItemMeta easyItemMeta;

	public EasyItem(Material material, Integer amount) {
		easyItem = new ItemStack(material, amount);
		easyItemMeta = easyItem.getItemMeta();

	}
	
	@SuppressWarnings("deprecation")
	public EasyItem(Material material, Integer amount, byte b) {
		easyItem = new ItemStack(material, amount, b);
		easyItemMeta = easyItem.getItemMeta();

	}

	public EasyItem setName(String displayName) {
		easyItemMeta.setDisplayName(displayName);

		return this;

	}
	
	

	public EasyItem setLore(String... lore) {

		easyItemMeta.setLore(Arrays.asList(lore));

		return this;

	}

	@SuppressWarnings("deprecation")
	public EasyItem setColor(short id) {
		easyItem.getData().setData((byte) id);
		return this;
		
	}

	public ItemStack build() {
		easyItem.setItemMeta(easyItemMeta);
		return easyItem;

	}

	public EasyItem setNameToNull() {
		easyItemMeta.setDisplayName(" ");

		return this;

	}

}
