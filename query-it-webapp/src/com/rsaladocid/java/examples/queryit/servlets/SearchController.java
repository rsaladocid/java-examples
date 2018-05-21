package com.rsaladocid.java.examples.queryit.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rsaladocid.java.examples.queryit.entities.Item;
import com.rsaladocid.java.examples.queryit.services.ItemService;
import com.rsaladocid.java.examples.queryit.services.ServicesRegistry;

@WebServlet("/search")
public class SearchController extends HttpServlet {

	private static final long serialVersionUID = -8996169540738188733L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String query = req.getParameter("query");

		if (query != null) {
			List<Item> items = new ArrayList<Item>();

			ServicesRegistry registry = new ServicesRegistry();
			List<ItemService> services = registry.getAllServices();

			for (ItemService service : services) {
				items.addAll(service.search(query));
			}

			req.setAttribute("items", items);
		}

		RequestDispatcher dispatcher = req.getRequestDispatcher("index.jsp");
		dispatcher.include(req, resp);
	}

}
