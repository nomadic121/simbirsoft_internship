package org.nomadic121.chat.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("org.nomadic121")
@EntityScan(basePackages = "org.nomadic121.chat.models")
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

}



