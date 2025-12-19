package br.com.curseiros.main.curso.controllers;

import br.com.curseiros.main.curso.dto.CursoUpdateDTO;
import br.com.curseiros.main.curso.entities.CursoEntity;
import br.com.curseiros.main.curso.useCases.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cursos")
public class CursoController {

    @Autowired
    private CreateCursoUseCase createCursoUseCase;

    @Autowired
    private ListCursoUseCase listCursoUseCase;

    @Autowired
    private UpdateCursoUseCase updateCursoUseCase;

    @Autowired
    private DeleteCursoUseCase deleteCursoUseCase;

    @Autowired
    private ActiveCursoUseCase activeCursoUseCase;

    @PostMapping("/")
    public ResponseEntity<Object> create(@Valid @RequestBody CursoEntity curso) {
        try {

            var result = createCursoUseCase.execute(curso);
            return ResponseEntity.ok(result);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(e.getMessage());
        }
    }

    @GetMapping("/")
    public ResponseEntity<Object> getAll() {
        try {

            var result = listCursoUseCase.execute();
            return ResponseEntity.ok(result);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@RequestBody CursoUpdateDTO cursoUpdateDTO, @PathVariable Long id) {
        try {
            var result = updateCursoUseCase.execute(id, cursoUpdateDTO);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id) {
        try{
            deleteCursoUseCase.execute(id);
            return ResponseEntity.ok("Curso deletado com sucesso!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PatchMapping("/{id}/active")
    public ResponseEntity<Object> toggleActivate(@PathVariable Long id) {
        try {
            var result = activeCursoUseCase.execute(id);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
