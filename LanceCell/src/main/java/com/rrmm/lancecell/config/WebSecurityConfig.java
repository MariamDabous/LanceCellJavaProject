package com.rrmm.lancecell.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
@Configuration
public class WebSecurityConfig {
	
	private UserDetailsService userDetailsService;
	// Add BCrypt Bean
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	protected SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		
		http.
	        authorizeRequests()
	            .antMatchers("/css/**", "/js/**", "/admin/registration","/owners/**", "/projects/**", "/programmers/**","/","/*","/webjars/**").permitAll()
	            .antMatchers("/admin/**").access("hasRole('ADMIN')")
	            .anyRequest().authenticated()
	            .and()
	        .formLogin()
	            .loginPage("/admin/login")
	            .permitAll()
	            .and()
	            .logout(logout -> logout
	                    .logoutUrl("/admin/logout")
	                    .addLogoutHandler(new SecurityContextLogoutHandler()));
		
		return http.build();
	}
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
    }
}