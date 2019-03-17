package com.mpqh.preauth.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@Profile(value = {"preauth"})
public class PreauthSecurityConfig extends WebSecurityConfigurerAdapter {

	private static Logger log = LoggerFactory.getLogger(PreauthSecurityConfig.class);


	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		    .antMatchers("/").permitAll()
		    .antMatchers("/h2_console/**").permitAll();

		http.csrf().disable();
		http.headers().frameOptions().disable();
	}

	
	
}
