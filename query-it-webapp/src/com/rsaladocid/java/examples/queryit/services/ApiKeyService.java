package com.rsaladocid.java.examples.queryit.services;

/**
 * Service with key authentication to identify and get information about any
 * particular item
 */
public abstract class ApiKeyService implements ItemService {

	/**
	 * The key required to use the service
	 */
	private String key;

	public ApiKeyService(String key) {
		this.key = key;
	}

	public String getKey() {
		return key;
	}

	protected void setKey(String key) {
		this.key = key;
	}

}
