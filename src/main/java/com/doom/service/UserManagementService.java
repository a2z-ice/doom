package com.doom.service;

import com.doom.model.User;

public interface UserManagementService {
	public User selectUser();
	public User addUser();
	public void saveUser(User player);
	User startTraining();
	User addUserTrainee();
	void removeUserById(int id);

}
