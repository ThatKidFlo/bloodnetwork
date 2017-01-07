package com.upt.cti.bloodnetwork.config;

import javax.sql.DataSource;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableLoadTimeWeaving;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.instrument.classloading.LoadTimeWeaver;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.EclipseLinkJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.upt.cti.bloodnetwork.persistence.PersistenceBeansMarkerInterface;


@Configuration
@ComponentScan(basePackageClasses = PersistenceBeansMarkerInterface.class)
@EnableTransactionManagement
@EnableLoadTimeWeaving
public class PersistenceConfig {
	
	@Bean
	public DataSource dataSource() {
		final BasicDataSource ds = new BasicDataSource();
		ds.setUrl("jdbc:mysql://localhost:3306/bloodnetwork");
		ds.setUsername("root");
		ds.setPassword("root");
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		
		return ds;
	}
	
	@Bean
	public JpaVendorAdapter jpaVendorAdapter() {
		EclipseLinkJpaVendorAdapter adapter = new EclipseLinkJpaVendorAdapter();
		adapter.setDatabasePlatform("MYSQL");
		adapter.setShowSql(true);
		adapter.setGenerateDdl(true);
		
		return adapter;
	}
	
	@Bean
	public PlatformTransactionManager platformTransactionManager(DataSource dataSource) {
		final JpaTransactionManager ptm = new JpaTransactionManager();
		ptm.setDataSource(dataSource);
		return ptm;
	}
	
	@Bean
	public PersistenceExceptionTranslationPostProcessor petpp() {
		return new PersistenceExceptionTranslationPostProcessor();
	}
	
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource, LoadTimeWeaver loadTimeWeaver, JpaVendorAdapter jpaVendorAdapter) {
		final LocalContainerEntityManagerFactoryBean emfb = new LocalContainerEntityManagerFactoryBean();
		
		emfb.setDataSource(dataSource);
		emfb.setJpaVendorAdapter(jpaVendorAdapter);
		emfb.setLoadTimeWeaver(loadTimeWeaver);
		
		return emfb;
	}
}
