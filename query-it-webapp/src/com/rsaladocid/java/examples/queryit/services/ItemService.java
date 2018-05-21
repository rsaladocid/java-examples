package com.rsaladocid.java.examples.queryit.services;

import java.io.IOException;
import java.util.List;

import com.rsaladocid.java.examples.queryit.entities.Item;

/**
 * Service to identify and get information about any particular item
 */
public interface ItemService {

	/**
	 * Find items whose name, description or another attribute match with a
	 * particular text
	 * 
	 * @param query
	 *            the text to find
	 * @return the list of items that fit the query
	 * @throws IOException
	 */
	public List<Item> search(String query) throws IOException;

	/**
	 * Find the item with a particular id
	 * 
	 * @param id
	 *            the id to find
	 * @return the item
	 * @throws IOException
	 */
	public Item getItem(String id) throws IOException;

	/**
	 * Returns the name of the service. Note: this name has to be unique, i.e.
	 * another service must not have the same name
	 * 
	 * @return the name of the service
	 */
	public String getName();

	/**
	 * Return the category of the items obtained by this service
	 * 
	 * @return the type of the service items
	 */
	public String getType();

}
