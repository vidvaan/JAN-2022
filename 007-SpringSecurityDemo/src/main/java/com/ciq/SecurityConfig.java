package com.ciq;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Bean
	public UserDetailsService users() {
		// The builder will ensure the passwords are encoded before saving in memory
		UserBuilder users = User.withDefaultPasswordEncoder();
		UserDetails user = users
			.username("balaji")
			.password("balaji")
			.roles("USER")
			.build();
		UserDetails admin = users
			.username("admin")
			.password("admin")
			.roles("ADMIN","USER")
			.build();
		return new InMemoryUserDetailsManager(user, admin);
	}
	
	
	@Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf(Customizer.withDefaults())
//            .authorizeHttpRequests(authorize -> authorize
//                .anyRequest().authenticated()
//            )
            .authorizeHttpRequests((authorize) -> authorize
    			    .requestMatchers("/public/**").permitAll()
    				.requestMatchers("/user").hasAuthority("ROLE_USER")
    				.requestMatchers("/admin").hasAuthority("ROLE_ADMIN")
    				.anyRequest().authenticated()
    			)
            .httpBasic(Customizer.withDefaults())
            .formLogin(Customizer.withDefaults());
        return http.build();
    }
	
	
//	@Bean
//	SecurityFilterChain web(HttpSecurity http) throws Exception {
//		
//		 
//		  http
//			.authorizeHttpRequests((authorize) -> authorize
//			    .requestMatchers("/home","/welcome","/hello").permitAll()
//				.requestMatchers("/user").hasAuthority("USER")
//				.anyRequest().authenticated()
//				.requestMatchers("/admin").hasAuthority("ADMIN")
//				.anyRequest().authenticated()
//			);
//		  
//		
//
//		return http.build();
//	}

}
