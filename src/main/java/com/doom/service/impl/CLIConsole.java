package com.doom.service.impl;

import java.util.List;
import java.util.Scanner;

import com.doom.model.Rule;
import com.doom.model.User;
import com.doom.service.UIService;

public class CLIConsole implements UIService {

	Scanner scan = new Scanner(System.in);

	boolean exit;
	
	@Override
	public void printStory() {
		System.out.println("You are going to enter a doom house.\n" + "There are so many rooms in this palace.\n"
				+ "Some people are in captive those rooms, surrounded by monsters\n" 
				+ "Shoot/kill monster by selecting appropriate weapon.");
		System.out.println("\n--------------------------------------\n");

		System.out.flush();
	}

	@Override
	public void printInstructions() {
		System.out.println("\nSelect right weapon to kill monster?\n" 
					+ "Type KNIFE(K/k),SNIPER(S/s),PISTOL(P/p)" 
					+ "\nQuit/Q/q to exit and SAVE to save level then<return>");

	}


	@Override
	public void displayExploreError() {
		System.err.println("Invalid input.Only K/S/P/Q are allowed");
	}
	@Override
	public void displayInvalidSelectionError() {
		System.err.println("Invalid input.Please choose from above number ");
	}
	@Override
	public String readUserInputString() {
		String input = scan.nextLine();
		return input;
	}

	@Override
	public int readUserInputInt() {
		int input = scan.nextInt();
		scan.nextLine();
		return input;
	}

	@Override
	public void destroy() {
		scan.close();
	}
	
	@Override
	public void displayUsers(List<User> users) {
		printHeader();
		int i = 0;
		for (User user : users) {
			System.out.println(++i + ")   " + user.getName() + "\t" + user.getLevel() + "\t" + user.getLife());
		}
		System.out.println(++i + ")   Create New Character");
		System.out.println(++i + ")   Delete A Character");
		System.out.println(++i + ")   Learn by Fighting");
		System.out.println(++i + ")   Exit");
		System.out.flush();
	}

	private void printHeader() {
		System.out.println("Select any number from the following menu and then press <return>:");
		System.out.println("----------------------------------");
		System.out.println("\tName\tLevel\tLife");
		System.out.println("----------------------------------");
		System.out.flush();
	}

	@Override
	public void displayInvalidOptionMessage() {
		System.out.println("Invalid option.Try again");
	}

	@Override
	public void traningSessionMessage() {
		System.out.println("You are in training session.");
	}
	
	@Override
	public void confirmUserDeletion() {
		System.out.println("To confirm deletion - enter the name of cararecter.To cancel - enter #cancel");
	}

	@Override
	public void userIntroMessage() {
		System.out.println("What is your name?");
	}

	@Override
	public void exitMessage() {
		System.out.println("Goodbye!");
	}

	@Override
	public void displayLostMessage() {
		System.out.println("You died.You lost the game");
	}


	@Override
	public void displayCorrectweaponMessage() {
		System.out.println(">>>>>>>>>>Correct weapon! You have got one Monster down.");
	}

	@Override
	public void displayInCorrectAnswerMessage() {
		System.out.println(">>>>>>>>>>Wrong weapon selection! Try again");
	}

	public boolean isExit() {
		return exit;
	}

	public void setExit(boolean exit) {
		this.exit = exit;
	}

	@Override
	public void missionComplete() {
		System.out.println("\n\n\nCongratulations mission accomplished\\n\\n\\n");
		
	}

	@Override
	public void displayRuleMessaage(String rule) {
		System.out.println("----------------------------------");
		System.out.println("** Hints: " + rule);
		System.out.println("----------------------------------");
		
	}
}
