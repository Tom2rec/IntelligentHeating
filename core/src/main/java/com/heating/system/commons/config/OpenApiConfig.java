package com.heating.system.commons.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.media.StringSchema;
import org.springdoc.core.SpringDocUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalTime;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI springHeatingSystemOpenAPI() {
        SpringDocUtils.getConfig().replaceWithSchema(LocalTime.class, new StringSchema().example("18:00:00"));
        return new OpenAPI()
                .info(new Info().title("Heating System")
                        .description("Heating System")
                        .version("v0.0.1"));
    }
}
