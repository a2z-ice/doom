package com.doom.utils;

import com.doom.exception.DoomException;

public enum WeaponType {
	KNIFE("K"),
	SNIPER("S"),
	PISTOL("P");
	private String shortCode;
	
	WeaponType(String shortCode ) {
		this.shortCode = shortCode;
	}
	
	public static WeaponType getWeaponCode(String weapon) {
		for(WeaponType type : WeaponType.values()) {
			if(type.shortCode.equalsIgnoreCase(weapon) || type.toString().equalsIgnoreCase(weapon)) {
				return type;
			}
		}
		
		throw new DoomException("weapon not supported");
	}
}
