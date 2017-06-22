package com.airtel.online.cash.card.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;

@Configuration
public class DaoConfig {

	@Value("${plan.jndi.name}")
	private String dataSourceJndiName;
	
	private DataSource dataSource;
	
	private JdbcTemplate jdbcTemplate;
	
	@Bean(destroyMethod = "")
	public DataSource getDatasource() {
		JndiDataSourceLookup dsLookup = new JndiDataSourceLookup();
		dsLookup.setResourceRef(false);
		dataSource = dsLookup.getDataSource(dataSourceJndiName);
		return dataSource;
	}
	
	@Bean
	public JdbcTemplate jdbcTemplate() {
		jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(getDatasource());
		return jdbcTemplate;
	}
}
