package com.heating.system.keycloak.config;

import com.heating.system.keycloak.config.properties.KeycloakProperties;
import feign.RequestInterceptor;
import feign.codec.Encoder;
import feign.form.FormEncoder;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.openfeign.support.SpringEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;

import static org.springframework.beans.factory.config.BeanDefinition.SCOPE_PROTOTYPE;

@RequiredArgsConstructor
public class FeignConfig {


    private final ObjectFactory<HttpMessageConverters> messageConverters;
    private final KeycloakProperties keycloakProperties;

    @Bean
    @Primary
    @Scope(SCOPE_PROTOTYPE)
    public Encoder feignFormEncoder() {
        return new FormEncoder(new SpringEncoder(this.messageConverters));
    }

    @Bean
    public RequestInterceptor bearerTokenRequestInterceptor() {
        return template -> template.header("Authorization", keycloakProperties.getAccessToken());
    }
}
