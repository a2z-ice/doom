package com.doom.service.impl;

import java.util.List;

import com.doom.exception.DoomException;
import com.doom.model.User;
import com.doom.repo.UserDao;
import com.doom.service.UIService;
import com.doom.service.UserManagementService;

public class UserManagementCosole implements  UserManagementService {

	UserDao userdao;
	UIService ui;

	public UserManagementCosole(UserDao userDao, UIService ui) {
		this.userdao = userDao;
		this.ui=ui;
	}

	public User selectUser() {
		List<User> users = userdao.getUsers();
		if (users != null && users.size() > 0) {
			ui.displayUsers(users);
			
			int selected = ui.readUserInputInt();
			
			if (selected > 0 && selected <= users.size()) {
				return users.get(selected - 1);
			} else if(selected == users.size() + 2){
				deleteUser();
				return selectUser();
			} else if (selected == users.size() + 3) {
				return startTraining();
				
			} else if (selected == users.size() + 4) {
				throw new DoomException("Good bye!!");
			} else if(selected == users.size() + 1){
				return addUser();
			} else {
				ui.displayInvalidOptionMessage();
			}
		}
		return addUser();
	}
	
	@Override
	public User startTraining() {
		ui.traningSessionMessage();
		return addUserTrainee();
		
	}

	private void deleteUser() {
		ui.confirmUserDeletion();
		String name = ui.readUserInputString();
		userdao.deleteUser(name);
	}

	@Override
	public User addUser() {
		ui.userIntroMessage();
		String name = ui.readUserInputString();
		User selectedUser = new User(name);
		userdao.saveUser(selectedUser);
		return selectedUser;
	}
	
	@Override
	public User addUserTrainee() {
		User selectedUser = new User(true);
		userdao.saveUser(selectedUser);
		return selectedUser;
	}

	@Override
	public void saveUser(User player) {
		userdao.updateUser(player);
		ui.exitMessage();
	}

	@Override
	public void removeUserById(int id) {
		userdao.deleteUserById(id);
	}

}
