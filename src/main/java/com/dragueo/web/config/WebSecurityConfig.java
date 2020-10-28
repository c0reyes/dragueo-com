package com.dragueo.web.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@EnableWebSecurity
public class WebSecurityConfig {
	@Value("${http.auth.user}")
	private String httpUser;
	
	@Value("${http.auth.pass}")
	private String httpPass;
	
	@Value("${http.auth.admin.user}")
	private String adminUser;
	
	@Value("${http.auth.admin.pass}")
	private String adminPass;
	
	@Bean
	public UserDetailsService userDetailsService() throws Exception {
		InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        
		manager.createUser(User
				.withUsername(httpUser)
				.password(encoder().encode(httpPass))
				.roles("USER").build());
        
        manager.createUser(User
                .withUsername(adminUser)
                .password(encoder().encode(adminPass))
                .roles("ADMIN").build());
        
        return manager;
	}
	
	@Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }
	
	@Configuration
	@Order(1)
	public static class ApiWebSecurityConfiguration extends WebSecurityConfigurerAdapter {
		protected void configure(HttpSecurity http) throws Exception {
		    http.antMatcher("/api/v1/dragtree/add")
		    	.authorizeRequests()
		    	.anyRequest()
		    	.hasRole("USER")
		    	.and()
	            .httpBasic();
		}
	}
	
	@Configuration
	public static class FormLoginSecurityConfiguration extends WebSecurityConfigurerAdapter {
		@Override
		protected void configure(HttpSecurity http) throws Exception {
		    http.authorizeRequests()
		    	.antMatchers("/admin/**").hasRole("ADMIN")
		    	.and()
		    	.formLogin()
		    	.loginPage("/admin/login").permitAll()
		    	.defaultSuccessUrl("/admin/")
	            .and()
	            .logout()
	            .logoutUrl("/admin/logout")
	            .logoutSuccessUrl("/admin/login?logout")
	            .deleteCookies("JSESSIONID")
	            .invalidateHttpSession(true);
		}
	}
}