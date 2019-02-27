package com.example.customer;

import org.h2.server.web.WebServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EntityScan(basePackages={"com.example.customer.model"})
public class CustomerAssignmentApplication {

	public static void main(String[] args) {
		 SpringApplication.run(CustomerAssignmentApplication.class, args);
	
		
		
	
	}

	 @Bean
	    ServletRegistrationBean<WebServlet> h2servletRegistration(){
	        ServletRegistrationBean<WebServlet> registrationBean = new ServletRegistrationBean<WebServlet>( new WebServlet());
	        registrationBean.addUrlMappings("/console/*");
	        return registrationBean;
	    }
}

