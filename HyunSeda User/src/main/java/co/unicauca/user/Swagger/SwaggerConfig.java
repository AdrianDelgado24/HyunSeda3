package co.unicauca.user.Swagger;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
@OpenAPIDefinition

public class SwaggerConfig {
    /**
     * Configuración de Swagger para la documentación de la API.
     *
     * @return Una instancia de OpenAPI configurada.
     */
    @Bean
    public OpenAPI api(){
        return new OpenAPI().info(new Info().title("Microservicio Usuario"));
    }

}
