package com.doom.service;

import java.util.List;

import com.doom.model.User;


public interface UIService {
	void printStory();
	void printInstructions();
	void displayExploreError();
	String readUserInputString();
	int readUserInputInt();
	void displayUsers(List<User> users);
	void displayInvalidOptionMessage();
	void confirmUserDeletion();
	void userIntroMessage();
	void exitMessage();
	void missionComplete();
	void displayLostMessage();
	void displayCorrectweaponMessage();
	void displayInCorrectAnswerMessage();
	void displayInvalidSelectionError();
	void traningSessionMessage();
	void displayRuleMessaage(String message);
	void destroy();
}
