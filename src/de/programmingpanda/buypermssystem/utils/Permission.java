package de.programmingpanda.buypermssystem.utils;

import org.bukkit.Material;

public class Permission {

	private String permission;
	private int price;
	private Material item;
	private String rang;
	private String world;
	private String server;

	public Permission(String permission, int price, String item, String rang, String server, String world) {
		setPermission(permission);
		setPrice(price);
		setItem((Material.getMaterial(item) == null) ? Material.STONE : Material.getMaterial(item));
		setRang(rang);
		setServer(server);
		setWorld(world);

	}

	public String getPermission() {
		return this.permission;
	}

	public void setPermission(String permission) {
		this.permission = permission;
	}

	public int getPrice() {
		return this.price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getRang() {
		return this.rang;
	}

	public void setRang(String rang) {
		this.rang = rang;
	}

	public String getWorld() {
		return this.world;
	}

	public void setWorld(String world) {
		this.world = world;
	}

	public Material getItem() {
		return this.item;
	}

	public void setItem(Material item) {
		this.item = item;
	}

	public String getServer() {
		return this.server;
	}

	public void setServer(String server) {
		this.server = server;
	}

}
