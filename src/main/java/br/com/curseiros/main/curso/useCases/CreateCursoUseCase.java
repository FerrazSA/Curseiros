package br.com.curseiros.main.curso.useCases;

import br.com.curseiros.exceptions.CursoFoundException;
import br.com.curseiros.main.curso.dto.CursoCreateDTO;
import br.com.curseiros.main.curso.entities.CursoEntity;
import br.com.curseiros.main.curso.repositories.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateCursoUseCase {

    @Autowired
    private CursoRepository cursoRepository;

    public CursoEntity execute(CursoCreateDTO cursoCreateDTO) {
        cursoRepository
                .findByName(cursoCreateDTO.name())
                .ifPresent((user) -> {
                    throw new CursoFoundException();
                });
        var curso = CursoEntity.builder()
                .name(cursoCreateDTO.name())
                .category(cursoCreateDTO.category())
                .professor(cursoCreateDTO.professor())
                .active(true)
                .build();

        return cursoRepository.save(curso);
    }
}
