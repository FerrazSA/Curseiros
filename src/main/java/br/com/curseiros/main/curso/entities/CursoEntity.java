package br.com.curseiros.main.curso.entities;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "curso")
public class CursoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Schema(example = "Curso de desenvolvimento em java iniciante", requiredMode = Schema.RequiredMode.REQUIRED)
    private String name;
    @NotBlank
    @Schema(example = "Programação", requiredMode = Schema.RequiredMode.REQUIRED)
    private String category;
    @NotBlank
    @Schema(example = "Juvenal", requiredMode = Schema.RequiredMode.REQUIRED)
    private String professor;

    @Schema(example = "true")
    private boolean active;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;
}
