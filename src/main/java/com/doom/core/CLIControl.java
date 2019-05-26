package com.doom.core;

import com.doom.model.User;
import com.doom.service.UIService;
import com.doom.service.UserManagementService;
import com.doom.utils.Constants;
import com.doom.utils.WeaponType;

public class CLIControl implements Control {
	
	private UIService ui;
	User user;
	UserManagementService userManager;
	GameFormula gameFormula;
	
	
	public CLIControl(UIService ui, User user,UserManagementService usermanager,GameFormula gameFormula) {
		this.ui = ui;
		this.user = user;
		this.userManager = usermanager;
		this.gameFormula = gameFormula;
		
	}
	
	@Override
	public boolean explore() {
		
		gameFormula.applyRule(user);
		if(user.isFinish()) {
			ui.missionComplete();
			return false;
		}

		ui.printInstructions();
		
		String cmd = ui.readUserInputString();
		if (cmd.equalsIgnoreCase("QUIT") || cmd.equalsIgnoreCase("Q")) {
			return false;
		} else {
			switch (cmd.toUpperCase()) {
				case "KNIFE":
				case "K":
					return goToNextLevel(cmd); 
				case "SNIPER":
				case "S":
					return goToNextLevel(cmd);
				case "PISTOL":
				case "P":
					return goToNextLevel(cmd);
				case "SAVE":
					return saveUserState(user);
				default:
					ui.displayExploreError();
			}
		}

		System.out.flush();
		return true;
	}

	@Override
	public boolean goToNextLevel(String weapon) {
		user.setWeapon(WeaponType.getWeaponCode(weapon));
		int result = gameFormula.goToNextLevel(user);
		return result == Constants.GO_TO_NEXT_LEVEL || result == Constants.STAY_IN_SAME_LEVEL;
	}
	
	public boolean saveUserState(User user) {
		userManager.saveUser(user);
		return false;
	}
	
	@Override
	public void startFighting() {
		
		System.out.println(user.getName() + " Go Go Go !!!");
		boolean finish = false;

		while (!finish) {
			if (!explore()) {
				if(user.isTrainnee()) {
					userManager.removeUserById(user.getId());
				}
				gotoMainManu();
				break;
			}
		}		
	}
	
	private void gotoMainManu() {
		user = userManager.selectUser();
		startFighting();
	}

	
}
