package com.rsaladocid.java.examples.queryit.services;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;

import com.rsaladocid.java.examples.queryit.entities.Item;

/**
 * Service to get information about games from IGDB (https://www.igdb.com)
 */
public class IgdbService extends ApiKeyService {

	public IgdbService(String key) {
		super(key);
	}

	@Override
	public List<Item> search(String query) throws IOException {
		List<Item> items = new ArrayList<Item>();

		URL url = new URL("https://api-endpoint.igdb.com/games/?search=" + query + "&fields=id,name,summary,cover");
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.addRequestProperty("user-key", getKey());
		con.addRequestProperty("Accept", "application/json");
		con.addRequestProperty("User-Agent",
				"Mozilla/5.0 (Windows NT 6.1; WOW64; rv:221.0) Gecko/20100101 Firefox/31.0");
		con.setRequestMethod("GET");

		if (con.getResponseCode() == HttpURLConnection.HTTP_OK) {
			JsonReader reader = Json.createReader(con.getInputStream());
			JsonArray root = reader.readArray();

			for (int i = 0; i < root.size(); i++) {
				JsonObject object = root.getJsonObject(i);
				items.add(toItem(object));
			}
		}

		return items;
	}

	@Override
	public Item getItem(String id) throws IOException {
		Item item = new Item(null, null);

		URL url = new URL("https://api-endpoint.igdb.com/games/" + id);
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.addRequestProperty("user-key", getKey());
		con.addRequestProperty("Accept", "application/json");
		con.addRequestProperty("User-Agent",
				"Mozilla/5.0 (Windows NT 6.1; WOW64; rv:221.0) Gecko/20100101 Firefox/31.0");
		con.setRequestMethod("GET");

		if (con.getResponseCode() == HttpURLConnection.HTTP_OK) {
			JsonReader reader = Json.createReader(con.getInputStream());
			JsonArray root = reader.readArray();

			JsonObject object = root.getJsonObject(0);
			item = toItem(object);
		}

		return item;
	}

	@Override
	public String getName() {
		return "igdb";
	}

	@Override
	public String getType() {
		return "game";
	}

	protected Item toItem(JsonObject object) {
		Item item = new Item(String.valueOf(object.getInt("id")), getName());
		item.setType(getType());
		item.setName(object.getString("name"));
		item.setDescription(object.getString("summary", null));

		JsonObject cover = object.getJsonObject("cover");
		if (cover != null) {
			item.setImage(cover.getString("url"));
		}

		return item;
	}

}
