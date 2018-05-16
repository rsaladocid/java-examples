package com.rsaladocid.java.examples.usermanagement.dao;

import com.rsaladocid.java.examples.usermanagement.model.User;

public interface UserDao {
	
	public void register(User user);
	public User validate(String mail, String password);
	public void update(User user);
	public void delete(String mail);

}
