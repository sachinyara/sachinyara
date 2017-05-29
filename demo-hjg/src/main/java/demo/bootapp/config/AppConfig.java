package demo.bootapp.config;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.hibernate.dialect.MySQL57InnoDBDialect;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import com.zaxxer.hikari.HikariDataSource;

@SpringBootApplication
@ComponentScan(basePackages={"demo.bootapp.controller","demo.bootapp.repository"})
public class AppConfig {
	@Bean
	CommandLineRunner commandLineRunner(ApplicationContext context){
		return args ->{
			System.out.println("Beans created:-");
			String[] beanNames = context.getBeanDefinitionNames();
			for(String beanName : beanNames)
				System.out.println(beanName);
		};
	}
	
	@Bean
    public PlatformTransactionManager jpaTransactionManager() {
        JpaTransactionManager tm = new JpaTransactionManager();
        tm.setEntityManagerFactory(defaultEntityManagerFactory());
        return tm;
    }
	@Bean
	@Primary
	EntityManager entityManager(){
		return defaultEntityManagerFactory().createEntityManager();
	}
	
	@Bean
	EntityManagerFactory defaultEntityManagerFactory(){
		LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
		factory.setDataSource(dataSource());
		factory.setJpaVendorAdapter(jpaVendorAdapter());
		factory.setPackagesToScan("demo.bootapp.model");
		factory.setPersistenceUnitName("default");
		factory.afterPropertiesSet();
		return factory.getObject();
	}
	
	@Bean
    public JpaVendorAdapter jpaVendorAdapter() {
        HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
        jpaVendorAdapter.setDatabase(Database.MYSQL);
        jpaVendorAdapter.setDatabasePlatform(MySQL57InnoDBDialect.class.getName());
        jpaVendorAdapter.setGenerateDdl(false);
        jpaVendorAdapter.setShowSql(true);
        return jpaVendorAdapter;
    }
	
	@Bean
	@ConfigurationProperties(prefix="spring.datasource")
	@Primary
	public DataSource dataSource() {
		return DataSourceBuilder.create().build();
	}
}
