package com.doom.model;

import com.doom.utils.WeaponType;

public class Rule {
	private int difficulty;
	private String description;
	private WeaponType weaponType;
	private boolean trainning;
	private int score;
	
	public Rule(int difficulty, String description, WeaponType weaponType, int score) {
		this.difficulty = difficulty;
		this.description = description;
		this.weaponType = weaponType;
		this.score = score;
	}
	
	public int getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(int difficulty) {
		this.difficulty = difficulty;
	}

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public WeaponType getWeaponType() {
		return weaponType;
	}
	public void setWeaponType(WeaponType weaponType) {
		this.weaponType = weaponType;
	}
	
	public boolean isTrainning() {
		return trainning;
	}
	public void setTrainning(boolean trainning) {
		this.trainning = trainning;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
}
