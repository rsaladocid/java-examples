package com.rsaladocid.java.examples.usermanagement.controllers;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rsaladocid.java.examples.usermanagement.dao.UserDao;
import com.rsaladocid.java.examples.usermanagement.dao.UserDaoJdbc;
import com.rsaladocid.java.examples.usermanagement.model.User;

@WebServlet("/login")
public class LoginController extends HttpServlet {
	
	private static final long serialVersionUID = -4687275834027779340L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {	
		RequestDispatcher dispatcher = req.getRequestDispatcher("login.html");
		dispatcher.include(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String password = req.getParameter("password");

		try {
			UserDao dao = new UserDaoJdbc("jdbc:sqlite:" + getClass().getClassLoader().getResource("usermanagement.db"), "root", "root");
			User user = dao.validate(email, password);

			HttpSession session = req.getSession();
			session.setAttribute("user", user);
			
			resp.sendRedirect("home");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
