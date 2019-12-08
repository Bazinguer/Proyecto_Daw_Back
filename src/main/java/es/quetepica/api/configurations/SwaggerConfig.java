package es.quetepica.api.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());
    }

    // http://localhost:8080/api/v0/swagger-ui.html
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("Proxecto DAW")
                .description("Proxecto final do FP de Desarrollo de Aplicacións Web. Back-end con Tecnoloxías de Código Aberto (SPRING)."
                        + "https://github.com/.....").build();
    }

}
