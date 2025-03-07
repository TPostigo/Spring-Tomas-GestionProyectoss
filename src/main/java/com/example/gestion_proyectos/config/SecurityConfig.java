package com.example.gestion_proyectos.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/css/**", "/js/**", "/login", "/error").permitAll()
                .anyRequest().authenticated()
            )
            .formLogin(form -> form
            .loginPage("/login")              
            .defaultSuccessUrl("/proyectos", true)  //  La URL a la que se redirige después de iniciar sesión correctamente
            .permitAll()

        )
            .logout(logout -> logout.permitAll())
            .httpBasic(Customizer.withDefaults());

        return http.build();
    }
}
