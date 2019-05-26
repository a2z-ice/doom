package com.doom.repo;

import java.sql.Connection;

public interface SqlRepository extends Repository {
	Connection getConnection();
	
}
