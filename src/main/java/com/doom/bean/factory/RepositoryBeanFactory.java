package com.doom.bean.factory;

import java.util.Properties;

import com.doom.exception.DoomException;
import com.doom.repo.Repository;
import com.doom.repo.RuleDao;
import com.doom.repo.SqlRepository;
import com.doom.repo.UserDao;
import com.doom.repo.impl.HsqlDBConnector;
import com.doom.repo.impl.RuleDaoSql;
import com.doom.repo.impl.UserDaoSql;
import com.doom.utils.Constants;
import com.doom.utils.PropertyKey;

public class RepositoryBeanFactory {

	
	
	public static Repository getRepo(Properties properties) {
		
		String repositoryType = properties.getProperty(PropertyKey.REPOSITORY_TYPE);
		if(Constants.REPOSITORY_TYPE_SQL.equals(repositoryType)) {
			return getSqlRepo(properties);
		}
		throw new DoomException(repositoryType + " Not supported");
	}
	
	
	
	public static SqlRepository getSqlRepo(Properties properties) {
		
		String jdbcDriver = properties.getProperty(PropertyKey.JDBC_DRIVER);
		if(Constants.HQLDB_DRIVER.equals(jdbcDriver)) {
			return HsqlDBConnector.getRepository(properties);
		}
		
		throw new DoomException(jdbcDriver + " Not supported");
		
	}
	
	public static UserDao getUserDao(Repository repo) {
		
		if(isSqlRepo(repo)) {
			return new UserDaoSql((SqlRepository) repo);
		}
		
		throw new DoomException("Repository type not yet supported");
	}
	
	public static RuleDao getRuleDao(Repository repo) {
		if(isSqlRepo(repo)) {
			return new RuleDaoSql((SqlRepository) repo);
		}
		
		throw new DoomException("Repository type not yet supported");
		
	}
	
	private static boolean isSqlRepo(Repository repo ) {
		return  repo instanceof SqlRepository;
	}
	
	
	
}
