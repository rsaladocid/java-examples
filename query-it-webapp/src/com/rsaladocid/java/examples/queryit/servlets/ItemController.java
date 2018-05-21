package com.rsaladocid.java.examples.queryit.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rsaladocid.java.examples.queryit.entities.Item;
import com.rsaladocid.java.examples.queryit.services.ItemService;
import com.rsaladocid.java.examples.queryit.services.ServicesRegistry;

@WebServlet("/item")
public class ItemController extends HttpServlet {

	private static final long serialVersionUID = -8401568415532010800L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String serviceName = req.getParameter("sn");
		String id = req.getParameter("id");

		if (serviceName != null && id != null) {
			ServicesRegistry registry = new ServicesRegistry();
			ItemService service = registry.getServiceByName(serviceName);
			Item item = service.getItem(id);

			req.setAttribute("item", item);
		}

		RequestDispatcher dispatcher = req.getRequestDispatcher("item.jsp");
		dispatcher.include(req, resp);
	}

}
