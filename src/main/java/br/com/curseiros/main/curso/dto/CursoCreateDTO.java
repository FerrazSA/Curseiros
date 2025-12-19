package br.com.curseiros.main.curso.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

public record CursoCreateDTO(@Schema(example = "Designer descomplicado", requiredMode = Schema.RequiredMode.REQUIRED)
                            @NotBlank String name,
                            @Schema(example = "Design", requiredMode = Schema.RequiredMode.REQUIRED)
                            @NotBlank String category,
                            @Schema(example = "André Campos", requiredMode = Schema.RequiredMode.REQUIRED)
                            @NotBlank String professor) {
}
