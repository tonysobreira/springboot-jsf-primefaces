package com.example.demo;

import java.util.Arrays;
import java.util.Date;

import javax.faces.webapp.FacesServlet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

import com.example.demo.model.Flight;
import com.example.demo.repository.FlightRepository;
import com.sun.faces.config.ConfigureListener;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	@Autowired
	private FlightRepository flightRepository;
	
	@Value("${heroku.var.1}")
	private String herokuVar1;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public ServletRegistrationBean facesServletRegistration() {
		ServletRegistrationBean registration = new ServletRegistrationBean<>(new FacesServlet(), "*.xhtml");
		registration.setLoadOnStartup(1);
		return registration;
	}

	@Bean
	public ServletContextInitializer servletContextInitializer() {
		return servletContext -> {
			servletContext.setInitParameter("com.sun.faces.forceLoadConfiguration", Boolean.TRUE.toString());
			servletContext.setInitParameter("primefaces.THEME", "nova-light");
		};
	}

	@Bean
	public ServletListenerRegistrationBean<ConfigureListener> jsfConfigureListener() {
		return new ServletListenerRegistrationBean<>(new ConfigureListener());
	}

	@Override
	public void run(String... args) throws Exception {
		Flight f1 = new Flight(null, "Airline 1", "Airport 1 from", "Airport 1 to", new Date(), new Date(), new Date());
		Flight f2 = new Flight(null, "Airline 2", "Airport 2 from", "Airport 2 to", new Date(), new Date(), new Date());
		Flight f3 = new Flight(null, "Airline 3", "Airport 3 from", "Airport 3 to", new Date(), new Date(), new Date());
		Flight f4 = new Flight(null, herokuVar1, herokuVar1, herokuVar1, new Date(), new Date(), new Date());
		flightRepository.saveAll(Arrays.asList(f1, f2, f3, f4));
	}

}
