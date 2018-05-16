package com.rsaladocid.java.examples.usermanagement.controllers;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rsaladocid.java.examples.usermanagement.dao.UserDao;
import com.rsaladocid.java.examples.usermanagement.dao.UserDaoJdbc;
import com.rsaladocid.java.examples.usermanagement.model.User;

@WebServlet("/delete")
public class DeleteController extends HttpServlet {

	private static final long serialVersionUID = -3499239454594235169L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		
		if (session.getAttribute("user") == null) {
			resp.sendRedirect("login");
		} else {
			try {				
				User user = (User) session.getAttribute("user");
				
				UserDao dao = new UserDaoJdbc("jdbc:sqlite:" + getClass().getClassLoader().getResource("usermanagement.db"), "root", "root");
				dao.delete(user.getMail());
				
				resp.sendRedirect("logout");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
