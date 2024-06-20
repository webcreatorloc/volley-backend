
package com.teamplayer11.player.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

import static com.teamplayer11.player.VolleyBackendApplication.SEC_ALLOWED_ORIGIN;
@EnableWebSecurity
@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .csrf(httpSecurityCsrfConfigurer -> {httpSecurityCsrfConfigurer.disable();})  // Disable CSRF for simplicity
                .cors(Customizer.withDefaults())
                .authorizeHttpRequests(registry -> {
                    registry.requestMatchers("/**").permitAll();
                    registry.requestMatchers("/players").hasRole("USER");
                    registry.anyRequest().authenticated();
                })
                .httpBasic(Customizer.withDefaults())
                .build();
    }

    // Used to generate the encrypted password: https://bcrypt-generator.com/
    // generate a
    // you can define the password in the application.yaml
    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails normalUser = User.builder()
                .username("gc") //1234 - to login you need to enter this e not the generatec encoded password
                .password("$2a$12$NJkSSlJGiSMqxSaJ02C.Xucb.y2N/yGFzBasRCSeLUU1PezLWCIPi")
                .roles("USER")
                .build();
        return new InMemoryUserDetailsManager(normalUser);
    }

   @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(8);
    }

    /*@Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList(SEC_ALLOWED_ORIGIN));
        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        configuration.setAllowedHeaders(Arrays.asList("*"));
        configuration.setAllowCredentials(true);
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }*/

}

