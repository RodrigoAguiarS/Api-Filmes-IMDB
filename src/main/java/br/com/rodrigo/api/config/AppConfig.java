package br.com.rodrigo.api.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Configuration
@Data
public class AppConfig {

    @Value("${base.url}")
    private String baseUrl;  
}
