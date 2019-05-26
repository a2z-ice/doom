package doom.com.repo.impl;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.doom.Helper;
import com.doom.bean.factory.RepositoryBeanFactory;
import com.doom.model.User;
import com.doom.repo.SqlRepository;
import com.doom.repo.UserDao;
import com.doom.repo.impl.UserDaoSql;

public class UserDaoHqlTest {

	static SqlRepository repo;
	
	@BeforeClass
	public static void init() {
		repo = RepositoryBeanFactory.getSqlRepo(Helper.getProperties());
	}
	
	@AfterClass
	public static void clear() {
		deleteUser();
	}
	
	@Test
	public void saveUserTest() {
		UserDao daoHql = new UserDaoSql(repo);
		User user = new User("test");
		daoHql.saveUser(user);
		assertTrue(user.getId() > 0);
	}
	
	@Test
	public void getUsersTest() {
		UserDao daoHql = new UserDaoSql(repo);
		assertTrue(daoHql.getUsers().size()>0);
	}
	
	@Test
	public void findUserByNameTest() {
		UserDao daoHql = new UserDaoSql(repo);
		User user = daoHql.findUserByName("test");
		assertNotNull(user);
		
	}
	
	public static void deleteUser() {
		UserDao daoHql = new UserDaoSql(repo);
		daoHql.deleteUser("test");
		
	}
}
