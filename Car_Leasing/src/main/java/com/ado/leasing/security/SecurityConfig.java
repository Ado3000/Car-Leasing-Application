package com.ado.leasing.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;	
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@ComponentScan("com.ado.leasing.service")
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	UserDetailsService userDetailsService;
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}


	 @Override
	 protected void configure(HttpSecurity http) throws Exception {
		   http.authorizeRequests().antMatchers("/admin/**")
			.access("hasRole('ROLE_ADMIN')").and().formLogin()
			.usernameParameter("id")
			.passwordParameter("password")
			.and().csrf()
			.and().exceptionHandling().accessDeniedPage("/403");
		   
		   http.authorizeRequests().antMatchers("/welcome")
			.access("hasRole('ROLE_USER')").and().formLogin()
			.usernameParameter("id")
			.passwordParameter("password")
			.and().csrf()
			.and().exceptionHandling().accessDeniedPage("/403");

	 }
	 
	 @Bean
		public PasswordEncoder passwordEncoder(){
			PasswordEncoder encoder = new BCryptPasswordEncoder();
			return encoder;
		}


}
