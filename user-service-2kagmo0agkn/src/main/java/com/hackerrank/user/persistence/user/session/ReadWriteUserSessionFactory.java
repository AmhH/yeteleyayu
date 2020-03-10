package com.hackerrank.user.persistence.user.session;

import java.io.IOException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ReadWriteUserSessionFactory extends BaseSessionFactory {
	private final DataSource apiReadWriteDatasource;

	@Autowired
	public ReadWriteUserSessionFactory(DataSource apiReadWriteDatasource) throws IOException {
		this.apiReadWriteDatasource = apiReadWriteDatasource;

		if (factory == null) {
			factory = createFactory();
		}
	}

	protected DataSource createDataSource() {
		return apiReadWriteDatasource;
	}
}
