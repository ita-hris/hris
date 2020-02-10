package com.itechart.hris.config;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Slf4j
@Configuration
public class CorsConfiguration {

  @Autowired AllowedOrigins allowedOrigins;

  @Bean
  public WebMvcConfigurer corsConfigurer() {
    return new WebMvcConfigurer() {
      @Override
      public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").allowedOrigins(provideOrigins());
      }
    };
  }

  private String[] provideOrigins() {
    final Optional<List<String>> maybeOrigins = Optional.ofNullable(allowedOrigins.getAllowed());
    return maybeOrigins.orElse(Collections.emptyList()).toArray(new String[0]);
  }
}
