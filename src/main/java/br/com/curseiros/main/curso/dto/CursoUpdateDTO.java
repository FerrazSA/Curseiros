package br.com.curseiros.main.curso.dto;

import io.swagger.v3.oas.annotations.media.Schema;

public record CursoUpdateDTO(@Schema(example = "Do básico ao avançado em PowerBI")
                             String name,
                             @Schema(example = "Dados")
                             String category,
                             @Schema(example = "Maria Clara")
                             String professor) {
}
