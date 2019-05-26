package com.doom.repo.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.doom.model.User;
import com.doom.repo.SqlRepository;
import com.doom.repo.UserDao;

public class UserDaoSql implements UserDao {

	private Connection connection;

	public UserDaoSql(SqlRepository repository) {
		this.connection = repository.getConnection();
	}
	
	public void saveUser(User user) {

		String sql = "insert into users(name,level,life,score,trainee) values(?,?,?,?,?)";
		try {
			PreparedStatement pstmt = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, user.getName());
			pstmt.setInt(2, user.getLevel());
			pstmt.setInt(3, user.getLife());
			pstmt.setInt(4, user.getScore());
			pstmt.setBoolean(5, user.isTrainnee());
			int updated = pstmt.executeUpdate();
			
			if (updated == 1) {
			    ResultSet generatedKeys = pstmt.getGeneratedKeys();
			    if (generatedKeys.next()) {
			        user.setId( generatedKeys.getInt(1));
			    }
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}	
	

	@Override
	public List<User> getUsers() {
		String sql = "Select * from users";
		List<User> users = new ArrayList<>();
		try {

			ResultSet resultSet = connection.createStatement().executeQuery(sql);
			while (resultSet.next()) {
				users.add(new User(
						resultSet.getString("name"), 
						resultSet.getInt("level"),
						resultSet.getInt("life"), 
						resultSet.getInt("score"),
						resultSet.getBoolean("trainee")
						));
			}
			return users;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
	}
	
	@Override
	public void deleteUser(String player) {
		String sql = "delete from users where name=?";
		try {
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, player);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void deleteUserById(int id) {
		String sql = "delete from users where id=?";
		try {
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public User findUserByName(String name) {
		String sql = "Select * from users where name=?";
		try {

			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, name);
			ResultSet resultSet = pstmt.executeQuery();
			if(resultSet.next())
				return new User(
						resultSet.getString("name"), 
						resultSet.getInt("level"),
						resultSet.getInt("life"), 
						resultSet.getInt("score"),
						resultSet.getBoolean("trainee")
						);
						
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}


	@Override
	public void updateUser(User player) {
		String sql = "update users set score=?, life=?,level=? where name=?";
		try {
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, player.getScore());
			pstmt.setInt(2, player.getLife());
			pstmt.setInt(3, player.getLevel());
			pstmt.setString(4, player.getName());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
}
