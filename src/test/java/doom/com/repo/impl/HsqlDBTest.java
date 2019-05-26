package doom.com.repo.impl;

import static org.junit.Assert.assertNotNull;

import java.sql.Connection;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.doom.Helper;
import com.doom.bean.factory.RepositoryBeanFactory;
import com.doom.repo.SqlRepository;

public class HsqlDBTest {

	static Connection dbConnection;
	static SqlRepository repo;
	
	@BeforeClass
	public static void init() {
		repo = RepositoryBeanFactory.getSqlRepo(Helper.getProperties());
		dbConnection = repo.getConnection();	
	}
	
	
	@Test
	public void testConnection() {
		assertNotNull(dbConnection);
	}
}
