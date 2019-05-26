package com.doom.repo.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.doom.model.Rule;
import com.doom.repo.RuleDao;
import com.doom.repo.SqlRepository;
import com.doom.utils.WeaponType;

public class RuleDaoSql implements RuleDao {

	
	Connection connection;
	public RuleDaoSql(SqlRepository repository) {
		this.connection = repository.getConnection();
	}
	
/*	@Override
	public List<Rule> getFightingRules(int offset) {
		String sql = "Select * from rules where isTrainning=false order by difficulty asc offset " + offset;
		return getRules(sql);

	}*/
	
	
	
	@Override
	public Rule getRuleBydifficulty(int level) {

		String sql = "Select * from rules where difficulty=?";
		try {

			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, level);
			ResultSet resultSet = pstmt.executeQuery();
			if(resultSet.next())
				return new Rule(
						resultSet.getInt("difficulty"),
						resultSet.getString("description"), 
						WeaponType.getWeaponCode(resultSet.getString("weaponType")), 
						resultSet.getInt("score")
						);
						
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	
	}
	
	
	

	

}
