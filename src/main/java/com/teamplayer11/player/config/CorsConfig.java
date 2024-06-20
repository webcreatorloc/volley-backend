package com.teamplayer11.player.config;

import org.hibernate.annotations.Filters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import static com.teamplayer11.player.VolleyBackendApplication.SEC_ALLOWED_ORIGIN;

@Configuration
public class CorsConfig extends CorsFilter {

    /**
     * Constructor accepting a {@link CorsConfigurationSource} used by the filter
     * to find the {@link CorsConfiguration} to use for each incoming request.
     *
     * @param configSource
     * @see UrlBasedCorsConfigurationSource
     */
    public CorsConfig(CorsConfigurationSource configSource) {
        super(configSource);
    }

    @Bean
    public WebMvcConfigurer corsConfigurer()  {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins(SEC_ALLOWED_ORIGIN) // Enable CORS for the whole application.
                        .allowedMethods(HttpMethod.GET.name(),
                                HttpMethod.POST.name(),
                                HttpMethod.DELETE.name(),
                                HttpMethod.PUT.name(),
                                HttpMethod.OPTIONS.name())
                                //.allowedHeaders(HttpHeaders.CONTENT_TYPE, HttpHeaders.AUTHORIZATION)

                               // .allowedHeaders("*")
                                .allowedHeaders("Content-Type, Authorization, Content-Length, X-Requested-With")

                        .allowCredentials(true);
            }
        };
    }

}

