package com.summit.drproject;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;

import com.summit.drproject.service.UserDetailsServiceImpl;
import com.summit.drproject.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private AuthenticationSuccessHandler successHandler;
	
	 @Bean
	    public UserDetailsService userDetailsService() {
	        return new UserDetailsServiceImpl();
	    }
	
	 @Bean
	    public BCryptPasswordEncoder passwordEncoder() {
	        return new BCryptPasswordEncoder();
	    }
	 
	  @Bean
	    public DaoAuthenticationProvider authenticationProvider() {
	        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
	        authProvider.setUserDetailsService(userDetailsService());	        
	        authProvider.setPasswordEncoder(passwordEncoder()); 
	        
	        return authProvider;
	    }
	  
	  @Override
	    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	        auth.authenticationProvider(authenticationProvider());
	  }
	  
	  @Override
	    protected void configure(HttpSecurity http) throws Exception {
	        http.csrf().disable().authorizeRequests()
	        .antMatchers("/", "/login", "/register").permitAll()
	        .antMatchers("/logout").authenticated()
	        .antMatchers("/user").hasAnyRole("USER")
			.antMatchers("/admin").hasAnyRole("ADMIN")
	            .and()
	            .formLogin().loginPage("/login").permitAll().failureUrl("/login-error")
				.successHandler(successHandler).permitAll()
	            .and()
	            .logout().logoutUrl("/logout").logoutSuccessUrl("/login?logout")
	            .invalidateHttpSession(true)        // set invalidation state when logout
                .deleteCookies("JSESSIONID")
	            //logoutSuccessHandler(new CustomLogoutSuccessHandler()).permitAll()
	            .and()
	            .exceptionHandling().accessDeniedPage("/403")
	            ;
	    }
	
	
}