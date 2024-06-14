package com.example.demo.config;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
public class CorsConfig  implements WebMvcConfigurer    {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**")
                .allowedOrigins("http://localhost:4200/") // Update this with your Angular app's URL
                .allowedMethods("GET", "POST", "PUT", "DELETE") // Add the HTTP methods you want to allow
                .allowedHeaders("*"); // Allow all headers
    }
}
