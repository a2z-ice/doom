package com.doom.repo;

import com.doom.model.Rule;

public interface RuleDao {

	Rule getRuleBydifficulty(int level);

}
