package com.hackerrank.user.persistence;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@ConfigurationProperties(prefix = "spring.datasource.hikari")
public class CompanyDatasourceConfig extends HikariConfig {

	@Bean
	public DataSource apiReadWriteDatasource() {
		return new HikariDataSource(this);
	}
}
