package com.aj.james.backendproject.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.aj.james.backendproject.model.Category;
import com.aj.james.backendproject.model.Product;
import com.aj.james.backendproject.model.Suppliers;
import com.aj.james.backendproject.model.User;

@Configuration
@ComponentScan("com.aj.james.backendproject")
@EnableTransactionManagement
public class ApplicationConfig {
	
		
	
	
	    @Autowired
	    @Bean(name = "dataSource")
	    public DataSource getDataSource() {
	    	
	   System.out.println("Hitting th eDB");
	    BasicDataSource dataSource = new BasicDataSource();
	    dataSource.setDriverClassName("org.h2.Driver");
	    dataSource.setUrl("jdbc:h2:tcp://localhost/~/backend");
	    dataSource.setUsername("james");
	    dataSource.setPassword("james@123");
	   
	    return dataSource;
	    }
	    
	    
	    private Properties getHibernateProperties() {
	    	System.out.println("Hitting the Hibernate");
	    Properties properties = new Properties();
	    properties.put("hibernate.show_sql", "true");
	    properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
	    properties.put("hbm2ddl.auto", "update");	   
	    return properties;
	    }
	    
	    @Autowired
	    @Bean(name = "sessionFactory")
	    public SessionFactory getSessionFactory(DataSource dataSource) {
	    	System.out.println("Hitting th session");
	    LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
	    sessionBuilder.addProperties(getHibernateProperties());
	    sessionBuilder.addAnnotatedClasses(Category.class);
	    sessionBuilder.addAnnotatedClasses(Suppliers.class);
	    sessionBuilder.addAnnotatedClasses(User.class);
	    sessionBuilder.addAnnotatedClasses(Product.class);
	   
	    return sessionBuilder.buildSessionFactory();
	    }
	    
	@Autowired
	@Bean(name = "transactionManager")
	public HibernateTransactionManager getTransactionManager(
	SessionFactory sessionFactory) {
		System.out.println("Hitting th transaction");
	HibernateTransactionManager transactionManager = new HibernateTransactionManager(
	sessionFactory);

	return transactionManager;
	
	}
}    
	   





