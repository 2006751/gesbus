package br.univesp.pi.gesbus;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class ConfigCORS implements WebMvcConfigurer {

	@Override
    public void addCorsMappings(CorsRegistry registry) {

        registry.addMapping("/**")  ;
    }
}