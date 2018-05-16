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

@WebServlet("/profile")
public class ProfileController extends HttpServlet {

	private static final long serialVersionUID = -3166499333950766655L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		
		if (session.getAttribute("user") == null) {
			resp.sendRedirect("login");
		} else {
			RequestDispatcher dispatcher = req.getRequestDispatcher("profile.jsp");
			dispatcher.include(req, resp);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String name = req.getParameter("name");
		String bio = req.getParameter("bio");
		String avatar = req.getParameter("avatar");
		String site = req.getParameter("site");
		
		try {
			HttpSession session = req.getSession();
			User user = (User) session.getAttribute("user");
			user.setUsername(username.equals("") ? null : username);
			user.setName(name.equals("") ? null : name);
			user.setBio(bio.equals("") ? null : bio);
			user.setAvatar(avatar.equals("") ? null : avatar);
			user.setSite(site.equals("") ? null : site);
			
			UserDao dao = new UserDaoJdbc("jdbc:sqlite:" + getClass().getClassLoader().getResource("usermanagement.db"), "root", "root");
			dao.update(user);
			
			resp.sendRedirect("profile");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
