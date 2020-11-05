package com.and.demo.webappall.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition(
        info = @Info(
                version = "1.0",
                title = "Dummy System",
                description = "" +
                        "This is just for demo purpose",
                contact = @Contact(
                        name = "Reflectoring",
                        url = "https://reflectoring.io",
                        email = "petros.stergioulas94@gmail.com"
                ),
                license = @License(
                        name = "MIT Licence",
                        url = "https://github.com/thombergs/code-examples/blob/master/LICENSE")),
        servers = @Server(url = "http://localhost:8080")
)
@Configuration
public class OpenAPIConfiguration {

}
