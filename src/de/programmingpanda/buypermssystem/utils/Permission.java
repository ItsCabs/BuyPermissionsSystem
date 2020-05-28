package de.programmingpanda.buypermssystem.utils;

import org.bukkit.Material;

public class Permission {

	private String permission;
	private String displayName;
	private int price;
	private Material item;
	private String group;
	private String world;
	private String server;

	public Permission(String permission, String displayName, int price, String item, String group, String server,String world) {
		setPermission(permission);
		setDisplayName(displayName);
		setPrice(price);
		setItem((Material.getMaterial(item) == null) ? Material.STONE : Material.getMaterial(item));
		setGroup(group);
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

	public String getGroup() {
		return this.group;
	}

	public void setGroup(String group) {
		this.group = group;
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

	public String getDisplayName() {
		return this.displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

}
