package com.rs.dao;
import java.util.List;

import com.rs.models.User;

public interface UserDao {
	
	List<User> getAllUsers();
	
	User getUserByUsername(String username);
	
	User getUserById(int id);
	
	void createUser(User u);
	
	void updateUser(User u);
	
	void deleteUser(User u);

}
