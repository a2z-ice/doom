package com.doom.model;

import com.doom.utils.WeaponType;

public class User {
	
	int id;
	String name;
	int level;
	int life;
	int score;
	boolean trainnee;
	WeaponType weapon;
	boolean finish;
	
	public User(String name, int level, int bonusLife, int score, boolean trainee) {
		this.name = name;
		this.level = level;
		this.life = bonusLife;
		this.score = score;
		this.trainnee = trainee;
	
	}
	
	public User(String name) {
		this.name = name;
		this.level = 1;
		this.life=3;
		this.score = 0;

	}
	
	public User(boolean trainee) {
		this.name = "Trainee";
		this.level = 1;
		this.life=100;
		this.score = 0;
		this.trainnee = trainee;

	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	
	public int getLife() {
		return life;
	}

	public void setLife(int life) {
		this.life = life;
	}

	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public WeaponType getWeapon() {
		return weapon;
	}

	public void setWeapon(WeaponType weapon) {
		this.weapon = weapon;
	}

	public boolean isTrainnee() {
		return trainnee;
	}

	public void setTrainnee(boolean trainnee) {
		this.trainnee = trainnee;
	}

	public boolean isFinish() {
		return finish;
	}

	public void setFinish(boolean finish) {
		this.finish = finish;
	}

}
