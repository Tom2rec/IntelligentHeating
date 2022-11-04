package com.heating.system.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.media.StringSchema;
import org.springdoc.core.SpringDocUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.time.LocalTime;

@Configuration
public class OpenApiConfiguration {

    @Bean
    public OpenAPI springTennisOpenAPI() {
        SpringDocUtils.getConfig().replaceWithSchema(LocalTime.class, new StringSchema().example("18:00:00"));
        return new OpenAPI()
                .info(new Info().title("Heating System")
                        .description("Heating System")
                        .version("v0.0.1"));
    }
}
