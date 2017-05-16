package br.com.evolution.patrimonio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Controller;

@SpringBootApplication
@Controller
public class Configuracao {
	

	public static void main(String[] args) {
		SpringApplication.run(Configuracao.class, args);
	}
	
	
	@Bean
	DataSource getDataSource(){
		DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
		//driverManagerDataSource.setDriverClassName("org.h2.Driver");
		driverManagerDataSource.setUrl("jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1");
		//driverManagerDataSource.setUsername("sa");
		//driverManagerDataSource.setPassword("");
		
		criaDB(driverManagerDataSource);
		return driverManagerDataSource;
	}


	private void criaDB(DriverManagerDataSource driverManagerDataSource) {
		Connection c = null;
		PreparedStatement stmt = null;
		try {
			c = driverManagerDataSource.getConnection();
	        stmt = c.prepareStatement("CREATE TABLE USUARIO (id INT PRIMARY KEY, nome VARCHAR(64), senha VARCHAR(64), email VARCHAR(64))");
	        stmt.execute();
	        
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				stmt.close();
				c.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
	}

}
