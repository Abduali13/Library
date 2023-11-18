package com.company.library.config;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public GroupedOpenApi groupedBookApi() {
        return GroupedOpenApi
                .builder()
                .group("Book")
                .pathsToMatch("/books/**")
                .build();
    }

    @Bean
    public GroupedOpenApi groupedCardApi() {
        return GroupedOpenApi
                .builder()
                .group("Card")
                .pathsToMatch("/cards/**")
                .build();
    }

    @Bean
    public GroupedOpenApi groupedAuthorApi() {
        return GroupedOpenApi
                .builder()
                .group("Author")
                .pathsToMatch("/authors/**")
                .build();
    }

    @Bean
    public GroupedOpenApi groupedGenderApi() {
        return GroupedOpenApi
                .builder()
                .group("Gender")
                .pathsToMatch("/genders/**")
                .build();
    }

    @Bean
    public GroupedOpenApi groupedGoalApi() {
        return GroupedOpenApi
                .builder()
                .group("Goal")
                .pathsToMatch("/goals/**")
                .build();
    }

    @Bean
    public GroupedOpenApi groupedImageApi() {
        return GroupedOpenApi
                .builder()
                .group("Image")
                .pathsToMatch("/images/**")
                .build();
    }

    @Bean
    public GroupedOpenApi groupedOrdersBookApi() {
        return GroupedOpenApi
                .builder()
                .group("OrdersBook")
                .pathsToMatch("/orderBook/**")
                .build();
    }

    @Bean
    public GroupedOpenApi groupedOrdersApi() {
        return GroupedOpenApi
                .builder()
                .group("Orders")
                .pathsToMatch("/orders/**")
                .build();
    }


    @Bean
    public GroupedOpenApi groupedPublisherApi() {
        return GroupedOpenApi
                .builder()
                .group("Publisher")
                .pathsToMatch("/publishers/**")
                .build();
    }

    @Bean
    public GroupedOpenApi groupedUserApi() {
        return GroupedOpenApi
                .builder()
                .group("User")
                .pathsToMatch("/users/**")
                .build();
    }
}
