package com.rsaladocid.java.examples.queryit.services;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.rsaladocid.java.examples.queryit.entities.Item;

/**
 * Service to get information about books from Goodreads
 * (https://www.goodreads.com)
 */
public class GoodreadsService extends ApiKeyService {

	public GoodreadsService(String key) {
		super(key);
	}

	@Override
	public List<Item> search(String query) throws IOException {
		List<Item> items = new ArrayList<Item>();

		URL url = new URL("https://www.goodreads.com/search/index.xml?key=" + getKey() + "&q=" + query);
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("GET");

		if (con.getResponseCode() == HttpURLConnection.HTTP_OK) {
			try {
				Document response = DocumentBuilderFactory.newInstance().newDocumentBuilder()
						.parse(con.getInputStream());

				NodeList nodes = response.getElementsByTagName("best_book");
				for (int i = 0; i < nodes.getLength(); i++) {
					items.add(toItem(nodes.item(i)));
				}
			} catch (SAXException e) {
				e.printStackTrace();
			} catch (ParserConfigurationException e) {
				e.printStackTrace();
			}
		}

		return items;
	}

	@Override
	public Item getItem(String id) throws IOException {
		Item item = new Item(null, null);

		URL url = new URL("https://www.goodreads.com/book/show/" + id + ".xml?key=" + getKey());
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("GET");

		if (con.getResponseCode() == HttpURLConnection.HTTP_OK) {
			try {
				Document response = DocumentBuilderFactory.newInstance().newDocumentBuilder()
						.parse(con.getInputStream());

				NodeList nodes = response.getElementsByTagName("book");
				item = toItem(nodes.item(0));
			} catch (SAXException e) {
				e.printStackTrace();
			} catch (ParserConfigurationException e) {
				e.printStackTrace();
			}
		}

		return item;
	}

	@Override
	public String getName() {
		return "goodreads";
	}

	@Override
	public String getType() {
		return "book";
	}

	protected Item toItem(Node node) {
		String id = null;
		String name = null;
		String image = null;
		String description = null;

		NodeList children = node.getChildNodes();
		for (int i = 0; i < children.getLength(); i++) {
			if (children.item(i).getNodeName() == "id") {
				id = children.item(i).getTextContent();
			} else if (children.item(i).getNodeName() == "title") {
				name = children.item(i).getTextContent();
			} else if (children.item(i).getNodeName() == "image_url") {
				image = children.item(i).getTextContent();
			} else if (children.item(i).getNodeName() == "description") {
				description = children.item(i).getTextContent();
			}
		}

		Item item = new Item(id, getName());
		item.setType(getType());
		item.setName(name);
		item.setImage(image);
		item.setDescription(description);

		return item;
	}

}
