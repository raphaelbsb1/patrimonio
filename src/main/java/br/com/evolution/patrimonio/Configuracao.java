package br.com.evolution.patrimonio;

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
		driverManagerDataSource.setDriverClassName("org.h2.Driver");
		driverManagerDataSource.setUrl("jdbc:h2:mem:");
		driverManagerDataSource.setUsername("sa");
		driverManagerDataSource.setPassword("");
		return driverManagerDataSource;
	}

}
