package com.jaw.UcbBankApp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;




@EnableWebSecurity
@EnableScheduling
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userDetailsService;

	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests().antMatchers("/").permitAll()
		//.antMatchers("/actuator").permitAll()
		//.antMatchers("/actuator/loggers").permitAll()
		//.antMatchers("/actuator/caches").permitAll()
		//.antMatchers("/actuator/info").permitAll()
		//.antMatchers("/actuator/health").permitAll()
				.antMatchers(HttpMethod.POST, "/bank/users").permitAll()
				.antMatchers(HttpMethod.POST, "/bank/users/saveEnroll").permitAll()
				.antMatchers(HttpMethod.PUT, "/bank/users/*").permitAll()
				.antMatchers(HttpMethod.GET, "/bank/users/*").permitAll()
				.antMatchers(HttpMethod.GET, "/bank/users/id").permitAll()
				.antMatchers(HttpMethod.GET, "/bank/users").permitAll()
				.anyRequest().authenticated();
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}

	@Bean
	@Scheduled(cron ="${geo.util.GeoBinCronExpression}" )
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	/* public JerseyConfig() {
	        register(UserController. class);
	    }*/
	 
}
