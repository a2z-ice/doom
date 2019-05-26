package com.doom.core;

import com.doom.model.Rule;
import com.doom.model.User;
import com.doom.repo.RuleDao;
import com.doom.service.UIService;
import com.doom.utils.Constants;

public class DoomFormula implements GameFormula {

	final int BONUS_LIFE_SCORE = 1;
	final int LIFE_INCRESED_BY = 1;
	final int LEVEL_INCREMENT_BY_ONE = 1;
	final int LIFE_DECRESED_BY = 1;

	RuleDao ruleDao;
	UIService ui;
	Control control;

	public DoomFormula(RuleDao ruleDao, UIService ui) {
		this.ruleDao = ruleDao;
		this.ui = ui;
	}

	@Override
	public void applyRule(User player) {

		Rule rule = ruleDao.getRuleBydifficulty(player.getLevel());
		if (rule == null) {
			player.setFinish(true);
		} else {
			StringBuilder sb = new StringBuilder();

			if(player.isTrainnee()) {
				sb.append(" Correct weapon is ***" + rule.getWeaponType() + "***");
			}
			ui.displayRuleMessaage(rule.getDescription() + sb.toString());
		}

	}

	@Override
	public int goToNextLevel(User player) {

		Rule rule = ruleDao.getRuleBydifficulty(player.getLevel());

		if (player.getWeapon() == rule.getWeaponType()) {
			ui.displayCorrectweaponMessage();

			player.setScore(player.getScore() + rule.getScore());
			player.setLevel(player.getLevel() + LEVEL_INCREMENT_BY_ONE);

			if (player.getScore() >= BONUS_LIFE_SCORE) {
				player.setLife(player.getLife() + LIFE_INCRESED_BY);
			}
			return Constants.GO_TO_NEXT_LEVEL;

		} else if (player.getLife() < 1) {
			ui.displayLostMessage();
			return Constants.GAME_OVER;
		} else {
			ui.displayInCorrectAnswerMessage();
			player.setLife(player.getLife() - LIFE_DECRESED_BY);
			return Constants.STAY_IN_SAME_LEVEL;
		}

	}

}
