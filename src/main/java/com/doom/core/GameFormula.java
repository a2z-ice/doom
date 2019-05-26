package com.doom.core;

import com.doom.model.User;

public interface GameFormula {
	int goToNextLevel(User player);

	void applyRule(User player);
}
