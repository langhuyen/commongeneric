package misa.sme.example.common;

import java.sql.Connection;
import java.sql.DriverManager;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class ConnectDatabase {

	@Value(value="{database.class}")
	private String classDriver;
	@Value(value="{database.url}")
	private String url;
	@Value(value="{database.username}")
	private String username;
	@Value(value="{database.password}")
	private String password;
	
	
	@Bean
	@Scope("request")
	public Connection getConnection() {
		try {
			Class.forName(classDriver);
		    return  DriverManager.getConnection(url,username, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
