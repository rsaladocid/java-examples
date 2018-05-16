package com.rsaladocid.java.examples.usermanagement.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.rsaladocid.java.examples.usermanagement.model.User;

public class UserDaoJdbc implements UserDao {
	
	private Connection connection = null;
	
	public UserDaoJdbc(String url, String user, String password) throws SQLException {
		try {
			Class.forName("org.sqlite.JDBC");
			setConnection(DriverManager.getConnection(url, user, password));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void register(User user) {
		String sql = "INSERT INTO users"
				+ "(mail, password) " + "VALUES"
				+ "(?,?)";
		
		try {
			PreparedStatement statement = getConnection().prepareStatement(sql);
			
			statement.setString(1, user.getMail());
			statement.setString(2, user.getPassword());
			
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public User validate(String mail, String password) {
		User user = null;
		String sql = "SELECT * FROM users WHERE mail = ? AND password = ?";
		
		try {
			PreparedStatement statement = getConnection().prepareStatement(sql);
			
			statement.setString(1, mail);
			statement.setString(2, password);
			
			ResultSet result = statement.executeQuery();
			
			while (result.next()) {
				user = new User(result.getString("mail"), result.getString("password"));
				user.setUsername(result.getString("username"));
				user.setName(result.getString("name"));
				user.setBio(result.getString("bio"));
				user.setAvatar(result.getString("avatar"));
				user.setSite(result.getString("site"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return user;
	}

	@Override
	public void update(User user) {
		String sql = "UPDATE users SET "
				+ "username = ?, name = ?,"
				+ "bio = ?, avatar = ?, site = ? "
				+ "WHERE mail = ? AND password = ?";
		
		try {
			PreparedStatement statement = getConnection().prepareStatement(sql);
			
			statement.setString(1, user.getUsername());
			statement.setString(2, user.getName());
			statement.setString(3, user.getBio());
			statement.setString(4, user.getAvatar());
			statement.setString(5, user.getSite());
			statement.setString(6, user.getMail());
			statement.setString(7, user.getPassword());
			
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(String mail) {
		String sql = "DELETE FROM users WHERE mail = ?";
		
		try {
			PreparedStatement statement = getConnection().prepareStatement(sql);
			
			statement.setString(1, mail);
			
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	protected Connection getConnection() {
		return connection;
	}

	protected void setConnection(Connection connection) {
		this.connection = connection;
	}

}
