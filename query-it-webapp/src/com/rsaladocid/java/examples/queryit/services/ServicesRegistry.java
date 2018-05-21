package com.rsaladocid.java.examples.queryit.services;

import java.util.ArrayList;
import java.util.List;

/**
 * Registry with the services used in the app
 */
public class ServicesRegistry {

	/**
	 * Return all services used in the app
	 * 
	 * @return the list of services
	 */
	public List<ItemService> getAllServices() {
		List<ItemService> services = new ArrayList<ItemService>();

		//TODO
		services.add(new GoodreadsService(/* API key */ null));
		services.add(new IgdbService(/* API key */ null));

		return services;
	}

	/**
	 * Returns a service by a given name
	 * 
	 * @param name
	 *            the name of the service
	 * @return the service
	 */
	public ItemService getServiceByName(String name) {
		for (ItemService service : getAllServices()) {
			if (service.getName().equalsIgnoreCase(name)) {
				return service;
			}
		}

		return null;
	}

	/**
	 * Returns the list of services according to a particular item category
	 * 
	 * @param type
	 *            the type of the item
	 * @return the services to get the type of item
	 */
	public List<ItemService> getServicesByType(String type) {
		List<ItemService> services = new ArrayList<ItemService>();

		for (ItemService service : getAllServices()) {
			if (service.getType().equalsIgnoreCase(type)) {
				services.add(service);
			}
		}

		return services;
	}

}
