package com.itechart.hris.config;

import java.util.List;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties("com.itechart.hris.cors")
public class AllowedOrigins {
  List<String> allowed;
}
