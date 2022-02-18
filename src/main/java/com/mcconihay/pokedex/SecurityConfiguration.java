package com.mcconihay.pokedex;

import com.mcconihay.pokedex.Services.TrainerDetailsLoader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	private final TrainerDetailsLoader trainersLoader;

	public SecurityConfiguration(TrainerDetailsLoader trainersLoader) {
		this.trainersLoader = trainersLoader;
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth
				.userDetailsService(trainersLoader) // How to find users by their username
				.passwordEncoder(passwordEncoder()) // How to encode and verify passwords
		;
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
				/* Login configuration */
				.formLogin()
				.loginPage("/login")
				.defaultSuccessUrl("/home") // user's home page, it can be any URL
				.permitAll() // Anyone can go to the login page
				/* Logout configuration */
				.and()
				.logout()
				.logoutSuccessUrl("/") // append a query string value
				/* Pages that can be viewed without having to log in */
				.and()
				.authorizeRequests()
				.antMatchers("/") // anyone can see the home and the ads pages
				.permitAll()
				/* Pages that require authentication */
				.and()
				.authorizeRequests()
				.antMatchers(
						"/home", // only authenticated users can create ads
						"/ads/{id}/edit" // only authenticated users can edit ads
				)
				.authenticated()
		;
	}


}
