package br.com.curseiros.main.curso.controllers;

import br.com.curseiros.main.curso.dto.CursoCreateDTO;
import br.com.curseiros.main.curso.dto.CursoUpdateDTO;
import br.com.curseiros.main.curso.entities.CursoEntity;
import br.com.curseiros.main.curso.useCases.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cursos")
@Tag(name = "Cursos", description = "Ações e informações de cursos")
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
    @Operation(summary = "Cadastro de um novo curso",
    description = "Requisição para criar um novo curso dentro do banco de dados")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {
                    @Content(schema = @Schema(implementation = CursoEntity.class))
            }),
            @ApiResponse(responseCode = "400", description = "Curso já cadastrado no sistema")
    })
    public ResponseEntity<Object> create(@Valid @RequestBody CursoCreateDTO cursoCreateDTO) {
        try {

            var result = createCursoUseCase.execute(cursoCreateDTO);
            return ResponseEntity.ok(result);

        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/")
    @Operation(summary = "Listando todos os cursos cadastrados",
            description = "Requisição para listar todos os cursos cadastrados sendo eles ativos ou não")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {
                    @Content(array = @ArraySchema(schema = @Schema(implementation = CursoEntity.class))),
            })
    })
    public ResponseEntity<Object> getAll() {
        try {

            var result = listCursoUseCase.execute();
            return ResponseEntity.ok(result);

        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizando um curso",
            description = "Requisição para atualizar a informação de um curso, porém sem deixar atualizar o status de active")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {
                    @Content(schema = @Schema(implementation = CursoUpdateDTO.class))
            })
    })
    public ResponseEntity<Object> update(@RequestBody CursoUpdateDTO cursoUpdateDTO, @PathVariable Long id) {
        try {
            var result = updateCursoUseCase.execute(id, cursoUpdateDTO);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Remoção de um curso",
            description = "Requisição para remover um curso baseado no ID enviado")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Curso deletado com sucesso!")
    })
    public ResponseEntity<Object> delete(@PathVariable Long id) {
        try{
            deleteCursoUseCase.execute(id);
            return ResponseEntity.ok("Curso deletado com sucesso!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PatchMapping("/{id}/active")
    @Operation(summary = "Alteração de status ativo",
            description = "Requisição para alterar o status de ativado de um curso")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {
                    @Content(schema = @Schema(implementation = CursoEntity.class))
            })
    })
    public ResponseEntity<Object> toggleActivate(@PathVariable Long id) {
        try {
            var result = activeCursoUseCase.execute(id);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
