package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.vaadin.spring.session.redis.VaadinSessionRewriteFilter;

import javax.servlet.Filter;

@SpringBootApplication
@EnableRedisHttpSession
// @ServletComponentScan("org.vaadin.spring.session.redis") // alternative to defining the vaadinSessionRewriteFilter bean
public class VaadinSpringSessionDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(VaadinSpringSessionDemoApplication.class, args);
    }

    @Bean
    public Filter vaadinSessionRewriteFilter() {
        return new VaadinSessionRewriteFilter();
    }

}
