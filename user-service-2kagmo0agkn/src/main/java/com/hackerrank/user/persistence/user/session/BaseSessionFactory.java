package com.hackerrank.user.persistence.user.session;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;

import javax.sql.DataSource;

import org.apache.ibatis.builder.xml.XMLMapperBuilder;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.session.TransactionIsolationLevel;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.stereotype.Repository;

@Repository
public abstract class BaseSessionFactory implements SqlSessionFactory {
	protected DataSource datasource;

	protected SqlSessionFactory factory;

	public SqlSession openSession() {
		return factory.openSession();
	}

	public SqlSession openSession(boolean autoCommit) {
		return factory.openSession(autoCommit);
	}

	public Configuration getConfiguration() {
		throw new UnsupportedOperationException("not supported");
	}

	public SqlSession openSession(Connection connection) {
		throw new UnsupportedOperationException("not supported");
	}

	public SqlSession openSession(TransactionIsolationLevel level) {
		return factory.openSession(level);
	}

	public SqlSession openSession(ExecutorType execType) {
		return factory.openSession(execType);
	}

	public SqlSession openSession(ExecutorType execType, boolean autoCommit) {
		return factory.openSession(execType, autoCommit);
	}

	public SqlSession openSession(ExecutorType execType, TransactionIsolationLevel level) {
		return factory.openSession(execType, level);
	}

	public SqlSession openSession(ExecutorType execType, Connection connection) {
		throw new UnsupportedOperationException("not supported");
	}

	protected abstract DataSource createDataSource();

	protected SqlSessionFactory createFactory() throws IOException {
		if (datasource == null) {
			datasource = createDataSource();
		}

		TransactionFactory transactionFactory = new JdbcTransactionFactory();
		Environment environment = new Environment("development", transactionFactory, datasource);
		Configuration configuration = new Configuration(environment);

		bindMappers(configuration);

		return new SqlSessionFactoryBuilder().build(configuration);
	}

	private void bindMappers(Configuration configuration) throws IOException {
		ClassLoader classLoader = getClass().getClassLoader();
		ResourcePatternResolver resourcePatternResolver = new PathMatchingResourcePatternResolver(classLoader);
		Resource[] resources = resourcePatternResolver.getResources("classpath*:/com/hackerrank/**/mapper/*.xml");

		for (Resource resource : resources) {
			InputStream inputStream = resource.getInputStream();
			XMLMapperBuilder xmlMapperBuilder = new XMLMapperBuilder(inputStream, configuration, resource.getFilename(), configuration.getSqlFragments());
			xmlMapperBuilder.parse();
		}
	}
}