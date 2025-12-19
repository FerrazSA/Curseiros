package br.com.curseiros.main;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Gestão de Cursos",
        description = "API responsável pela gestão de cursos, fazendo o CRUD dos dados no banco de dados",
        version = "1.0"))
public class CurseirosApplication {

    public static void main(String[] args) {
        SpringApplication.run(CurseirosApplication.class, args);
    }

}
