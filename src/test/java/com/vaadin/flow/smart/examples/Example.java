package com.vaadin.flow.smart.examples;

import com.vaadin.flow.component.page.AppShellConfigurator;
import com.vaadin.flow.theme.Theme;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * The entry point of the Spring Boot application.
 * Use the @PWA annotation make the application installable on phones, tablets
 * and some desktop browsers.
 *
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.vaadin.flow.smart"})
@Theme(value = "vaadin-smart-components")
public class Example implements AppShellConfigurator {

    public static void main(String[] args) {
        SpringApplication.run(Example.class, args);
    }

}
