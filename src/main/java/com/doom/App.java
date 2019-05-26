package com.doom;

import com.doom.bean.factory.RepositoryBeanFactory;
import com.doom.core.CLIControl;
import com.doom.core.Control;
import com.doom.core.DoomFormula;
import com.doom.core.GameFormula;
import com.doom.exception.DoomException;
import com.doom.model.User;
import com.doom.repo.Repository;
import com.doom.repo.UserDao;
import com.doom.service.UIService;
import com.doom.service.UserManagementService;
import com.doom.service.impl.CLIConsole;
import com.doom.service.impl.UserManagementCosole;

public class App {
	public static void main(String[] args) {
		try (Repository repo = RepositoryBeanFactory.getRepo(Helper.getProperties())) {
			UIService ui = new CLIConsole();
			ui.printStory();
			UserDao userDao = RepositoryBeanFactory.getUserDao(repo);
			UserManagementService usermanager = new UserManagementCosole(userDao, ui);
			GameFormula gameFormula = new DoomFormula(RepositoryBeanFactory.getRuleDao(repo), ui);
			User player = usermanager.selectUser();
			Control control = new CLIControl(ui, player, usermanager, gameFormula);
			control.startFighting();
		} catch(DoomException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	
}