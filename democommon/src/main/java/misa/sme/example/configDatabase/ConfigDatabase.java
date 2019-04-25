package misa.sme.example.configDatabase;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigDatabase {
	
	@Bean
	public  SessionFactory  createSessionFactory() {
		  org.hibernate.cfg.Configuration configuration = new org.hibernate.cfg.Configuration();
		  configuration.setProperty("hibernate.connection.driver_class",
			      "org.mariadb.jdbc.Driver");
			  configuration.setProperty("hibernate.connection.url",
			      "jdbc:mariadb://db_container:3306/test?createDatabaseIfNotExist=true");
			  configuration.setProperty("hibernate.connection.username", "root");
			  configuration.setProperty("hibernate.connection.password", "misasme");
			  configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5InnoDBDialect");
			  configuration.setProperty("hibernate.hbm2ddl.auto","update");
			  configuration.setProperty("hibernate.show_sql", "false");
			  configuration.setProperty("hibernate.connection.pool_size", "100");
			  configuration.setProperty("hibernate.connection.characterEncoding", "utf8");
			  configuration.setProperty("hibernate.connection.useUnicode", "true");
			  configuration.setProperty("hibernate.enable_lazy_load_no_trans", "true");
		  StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
		      .applySettings(configuration.getProperties());
		  return  configuration.buildSessionFactory(builder.build());
		
	}
	
}
