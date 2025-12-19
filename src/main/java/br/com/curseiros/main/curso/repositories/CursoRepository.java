package br.com.curseiros.main.curso.repositories;

import br.com.curseiros.main.curso.entities.CursoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CursoRepository extends JpaRepository<CursoEntity, Long> {
    Optional<CursoEntity> findByName(String name);
}
