package com.doom.repo;

import java.util.List;

import com.doom.model.User;

public interface UserDao {
	List<User> getUsers();
	void saveUser(User user);
	void deleteUser(String player);
	User findUserByName(String name);
	void updateUser(User player);
	void deleteUserById(int id);

}
