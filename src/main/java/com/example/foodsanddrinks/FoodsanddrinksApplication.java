package com.example.foodsanddrinks;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.security.OAuthFlow;
import io.swagger.v3.oas.annotations.security.OAuthFlows;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SecurityScheme(
        type = SecuritySchemeType.OAUTH2,
        name = "oauth2",
        description = "KeyCloak FoodsAndDrink",
        flows = @OAuthFlows(
                implicit = @OAuthFlow(
                        authorizationUrl = "http://Bences-MacBook-Pro.local:6080/auth/realms/foodanddrinks/protocol/openid-connect/auth"
                        + "?client_id=account"
                        + "&redirect_uri=http://Bences-MacBook-Pro.local:8080/foods/swagger-ui/oauth2-redirect.html"
                        + "&response_type=code"
                        + "&scope=openid")
        )
)

@SecurityScheme(
        type = SecuritySchemeType.APIKEY,
        name = "apikey",
        paramName = "Authorization",
        description = "KeyCloak FoodsAndDrink",
        in = SecuritySchemeIn.HEADER)


@SecurityScheme(
        type = SecuritySchemeType.OPENIDCONNECT,
        name = "openid",
        description = "KeyCloak FoodsAndDrink",
        openIdConnectUrl = "http://Bences-MacBook-Pro.local:6080/auth/realms/foodanddrinks/.well-known/openid-configuration"
)

@OpenAPIDefinition(
        servers = {
                @Server(url = "http://Bences-MacBook-Pro.local:8080/foods", description = "local dev")
        },

        info = @Info(
                title = "Foods And Drinks API",
                version = "v1",
                description = "description = \"YFoods And Drinks for Graphical User Interface ."
        )
)


@Configuration
//@EnableAutoConfiguration
//@ComponentScan()
@SpringBootApplication
public class FoodsanddrinksApplication {

    public static void main(String[] args) {
        SpringApplication.run(FoodsanddrinksApplication.class, args);
    }

}
