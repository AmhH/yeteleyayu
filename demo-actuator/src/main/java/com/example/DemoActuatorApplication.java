package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoActuatorApplication/* extends WebSecurityConfigurerAdapter*/ {


	public static void main(String[] args) {
		SpringApplication.run(DemoActuatorApplication.class, args);
	}


	/*@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				.requestMatchers(EndpointRequest.to(HealthEndpoint.class))
				.permitAll()
				.antMatchers("/**")
				.hasRole("USER")
				.and()
				.httpBasic();
	}*/
}
