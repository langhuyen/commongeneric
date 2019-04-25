package misa.sme.example.common;

import java.sql.Connection;
import java.sql.DriverManager;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class ConnectDatabase {

	@Value("${database.class}")
	private String classDriver;
	@Value("${database.url}")
	private String url;
	@Value("${database.username}")
	private String username;
	@Value("${database.password}")
	private String password;
	
	
	@Bean
	public Connection getConnection() {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
		    return  DriverManager.getConnection(url,username, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
