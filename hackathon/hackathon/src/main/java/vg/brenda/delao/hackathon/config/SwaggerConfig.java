package vg.brenda.delao.hackathon.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class SwaggerConfig implements WebMvcConfigurer {

@Bean
public OpenAPI apiInfo() {
return new OpenAPI()
.addServersItem(new Server()
.url("http://localhost:8080/")
.description("Local server"))
.info(new Info()
.title("Hackathon Valle Reg API")
.description("API REST para la gestión de estudiantes del proyecto Hackathon")
.license(new License()
.name("Valle Grande")
.url("https://vallegrande.edu.pe"))
.version("1.0.0")
);
}

@Override
public void addCorsMappings(CorsRegistry registry) {
registry.addMapping("/**")
.allowedOrigins("*") // Permite todas las peticiones de cualquier origen
.allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Métodos permitidos
.allowedHeaders("*"); // Permitir todos los headers
}
}
