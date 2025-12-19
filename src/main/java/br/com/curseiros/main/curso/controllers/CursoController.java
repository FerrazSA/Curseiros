package br.com.curseiros.main.curso.controllers;

import br.com.curseiros.main.curso.entities.CursoEntity;
import br.com.curseiros.main.curso.useCases.CreateCursoUseCase;
import br.com.curseiros.main.curso.useCases.ListCursoUseCase;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cursos")
public class CursoController {

    @Autowired
    private CreateCursoUseCase createCursoUseCase;

    @Autowired
    private ListCursoUseCase listCursoUseCase;

    @PostMapping("/")
    public ResponseEntity<Object> create(@Valid @RequestBody CursoEntity curso) {
        try {

            var result = createCursoUseCase.execute(curso);
            return ResponseEntity.ok(result);

        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/")
    public ResponseEntity<Object> getAll() {
        try {

            var result = listCursoUseCase.execute();
            return ResponseEntity.ok(result);

        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
