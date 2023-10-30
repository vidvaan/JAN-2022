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
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Bean
	public static PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public UserDetailsService users() {
		// The builder will ensure the passwords are encoded before saving in memory
	//	UserBuilder users = User.withDefaultPasswordEncoder();
		
		UserBuilder users = User.builder();
		UserDetails user = users
			.username("balaji")
			.password("$2a$10$sf8K/vCKM3hSvB0W8OzycOSZ1VD/UeHxI.JgniQLopXwYdH3uKM0u")
			.roles("USER")
			.build();
		UserDetails admin = users
			.username("srikanth")
			.password("$2a$10$7CewQish1obRT2VwhEAL0.Tc.ujbSRd/J92Rx3IqX9.W401TJ7/B6")
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
