package dev.aziz.messaging.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
        info = @Info(
                contact = @Contact(
                        name = "Aziz",
                        email = "abdukarimovtheaziz.com"
                ),
                description = "Documentation for T1 consulting test task",
                title = "OpenApi specification - Azizdev",
                version = "1.0"
        ),
        servers = {
                @Server(
                        description = "Local ENV",
                        url = "http://localhost:7711"
                )
        }
)
public class OpenApiConfig {
}
