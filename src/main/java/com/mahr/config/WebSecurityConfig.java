package com.mahr.config;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.firewall.StrictHttpFirewall;

@Configuration
public class WebSecurityConfig {

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (request) -> request.ignoring().requestMatchers("/hola");
    }
    
    @Bean
    public InMemoryUserDetailsManager userDetailsService() {
        /*UserDetails user = User.withDefaultPasswordEncoder()
            .username("user")
            .password("password")
            .roles("USER")
            .build();
        return new InMemoryUserDetailsManager(user);*/
        
    	List<UserDetails> users = new ArrayList<UserDetails>();
    	List<GrantedAuthority> list = new ArrayList<>();
    	list.add(new SimpleGrantedAuthority("add"));
    	
		UserDetails firstUser = User.withDefaultPasswordEncoder().username("admin").password("admin").authorities(list).build();
		UserDetails secondUser = User.withDefaultPasswordEncoder().username("user").password("user").authorities(list).build();

		users.add(firstUser);
		users.add(secondUser);
		
        return new InMemoryUserDetailsManager((Collection<UserDetails>) users) {
		};
    }
    
    @Bean
    public StrictHttpFirewall httpFirewall() {
        StrictHttpFirewall firewall = new StrictHttpFirewall();
//        Pattern allowed = Pattern.compile("[\\p{IsAssigned}&&[^\\p{IsControl}]]*");
//        Pattern userAgent = ...;
//        firewall.setAllowedHeaderValues((header) -> allowed.matcher(header).matches() || userAgent.matcher(header).matches());
        firewall.setAllowBackSlash(true);//permite la barra invertida
        firewall.setAllowSemicolon(true);//permite el punto y coma
        firewall.setAllowUrlEncodedSlash(true);
        return firewall;
    }
	
}
