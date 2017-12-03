package com.egen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.egen")
//@ImportResource("classpath:dispatcher-servlet.xml")
public class SpringBootRestApp {
	public static void main(String[] args) {
        SpringApplication.run(SpringBootRestApp.class, args);
    }
}
