package doom.com.repo;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.util.Properties;

import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.doom.Helper;
import com.doom.bean.factory.RepositoryBeanFactory;
import com.doom.exception.DoomException;
import com.doom.repo.Repository;
import com.doom.repo.impl.HsqlDBConnector;
import com.doom.repo.impl.UserDaoSql;
import com.doom.utils.Constants;
import com.doom.utils.PropertyKey;

public class RepoFactoryTest {
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	static Repository repo;
	@BeforeClass
	public static void init() {
		repo = RepositoryBeanFactory.getRepo(Helper.getProperties());
	}

	@Test
	public void testProperties() {
		Properties properties = new Properties();
		properties.setProperty(PropertyKey.JDBC_DRIVER, Constants.HQLDB_DRIVER);
		String jdbcDriver = properties.getProperty(PropertyKey.JDBC_DRIVER);
		assertEquals(jdbcDriver,Constants.HQLDB_DRIVER);
		
	}
	
	@Test
	public void testGetRepoRuntimeException() {
		Properties properties = new Properties();
		properties.setProperty(PropertyKey.REPOSITORY_TYPE, Constants.OTHER);
		String repositoryType = properties.getProperty(PropertyKey.REPOSITORY_TYPE);
		thrown.expect(DoomException.class);
		thrown.expectMessage(repositoryType + " Not supported");
		RepositoryBeanFactory.getRepo(properties);
	}
		
	@Test
	public void testGetRepo() {
		Repository repo = RepositoryBeanFactory.getRepo(Helper.getProperties());
		assertThat(repo, instanceOf(HsqlDBConnector.class));
	}
	
	@Test
	public void testGetUserDao() {
		assertThat(RepositoryBeanFactory.getUserDao(repo), instanceOf(UserDaoSql.class));
	}
}
