package com.company.library;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
        info = @Info(
                title = "Library",
                version = "1-version",
                description = "Java backend 7 Students Project",
                license = @License(name = "Library License"),
                contact = @Contact(
                        name = "Kamol Turaqulov",
                        url = "https://t.me/Kamol2103",
                        email = "turakulovkamol2103@gmail.com"
                )

        ),
		servers = @Server(url = "http://localhost:8080")
)
        public class LibraryApplication{

        public static void main(String[]args) {
        SpringApplication.run(LibraryApplication.class,args);
        }

        }
