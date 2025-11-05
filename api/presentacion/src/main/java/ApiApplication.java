package festivosco.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(
    scanBasePackages = {
        "festivosco.api.dominio",
        "festivosco.api.infraestructura",
        "festivosco.api.core",
        "festivosco.api.aplicacion",
        "festivosco.api.presentacion"
    }
)
public class ApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(ApiApplication.class, args);
    }
}
