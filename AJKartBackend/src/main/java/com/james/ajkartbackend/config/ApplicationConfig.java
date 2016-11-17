package com.james.ajkartbackend.config;

import java.util.Properties;

import javax.sql.DataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.james.ajkartbackend.model.Category;
import com.james.ajkartbackend.model.Product;
import com.james.ajkartbackend.model.Supplier;
import com.james.ajkartbackend.model.User;


@Configuration
@ComponentScan(basePackages="com.james.ajkartbackend")
@EnableTransactionManagement
public class ApplicationConfig {
		
	@Autowired
	@Bean(name="dataSource")
	public DataSource getDataSource()
	{
		System.out.println("get Datasourcemethod called");
		DriverManagerDataSource  dataSource=new DriverManagerDataSource();
		dataSource.setDriverClassName("org.h2.Driver");
		dataSource.setUsername("james");
		dataSource.setPassword("james@123");
		dataSource.setUrl("jdbc:h2:tcp://localhost/~/backend");
		return dataSource;
	}
	private  Properties getHibernateProperties()
	{
		Properties properties=new Properties();
		properties.setProperty("hibernate.show_sql", "true");
		properties.setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		properties.setProperty("hibernate.hbm2ddl.auto", "update");
		return properties;
	}
	@Autowired
	@Bean(name="sessionFactory")
	public SessionFactory getSessionFactory(DataSource dataSource)
	{
		LocalSessionFactoryBuilder localSessionFactoryBuilder=new LocalSessionFactoryBuilder(dataSource);
		localSessionFactoryBuilder.addProperties(getHibernateProperties());
		localSessionFactoryBuilder.addAnnotatedClass(Category.class);
		localSessionFactoryBuilder.addAnnotatedClass(Product.class);
		localSessionFactoryBuilder.addAnnotatedClass(Supplier.class);
		localSessionFactoryBuilder.addAnnotatedClass(User.class);
		return localSessionFactoryBuilder.buildSessionFactory();
	}
	@Autowired
	@Bean(name="transactionManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory)
	{
		HibernateTransactionManager hibernateTransactionManager=new HibernateTransactionManager(sessionFactory);
		return hibernateTransactionManager;
		
	}
}
	
	
	

	

	
  






