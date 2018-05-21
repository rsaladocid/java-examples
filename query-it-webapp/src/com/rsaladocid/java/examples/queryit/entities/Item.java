package com.rsaladocid.java.examples.queryit.entities;

/**
 * This class contains the basic information about any thing that can be founded
 * in the app. An item is intended to be created by services
 */
public class Item {

	/*
	 * Note: The aggregation of the id and serviceName attributes are used to
	 * universally identify an item
	 */

	/**
	 * Identifier of an item within a particular service. Many items could have the
	 * same id (but different serviceName)
	 */
	private String id;

	/**
	 * The name of the service to which the item belongs
	 */
	private String serviceName;

	/**
	 * Category of the item, e.g. game, book, movie
	 */
	private String type;

	/**
	 * The name of the item
	 */
	private String name;

	/**
	 * Brief description about the item
	 */
	private String description;

	/**
	 * The url of the item image
	 */
	private String image;

	public Item(String id, String serviceName) {
		this.id = id;
		this.serviceName = serviceName;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getServiceName() {
		return serviceName;
	}

	@Override
	public String toString() {
		return "(" + getServiceName() + "#" + getType() + ") " + getId() + " - " + getName() + " - ";
	}

	protected void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	protected void setId(String id) {
		this.id = id;
	}

}
