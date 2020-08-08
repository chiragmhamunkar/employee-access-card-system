package com.example.accesscard;

import com.example.accesscard.simulation.data.DataLoader;
import lombok.extern.slf4j.Slf4j;
import org.h2.server.web.WebServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@Slf4j
@SpringBootApplication
public class EmployeeAccessCardApplication {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(EmployeeAccessCardApplication.class, args);

		feedData(context);
	}

	//CM: This is just to load some sample data. We should not call this method in PROD
	private static void feedData(ApplicationContext context) {
		log.info("************ Feeding system with sample data ***************");
		DataLoader dataLoader = context.getBean(DataLoader.class);
		dataLoader.loadLocations();
		dataLoader.loadCards();
		dataLoader.loadEmployees();
		dataLoader.loadAccessCards();
		log.info("************ DONE **************");
	}

	@Bean
	public ServletRegistrationBean h2servletRegistration(){
		ServletRegistrationBean registrationBean = new ServletRegistrationBean( new WebServlet());
		registrationBean.addUrlMappings("/console/*");
		return registrationBean;
	}
	
}
