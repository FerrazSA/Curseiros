package br.com.curseiros.main.curso.useCases;

import br.com.curseiros.main.curso.dto.CursoUpdateDTO;
import br.com.curseiros.main.curso.entities.CursoEntity;
import br.com.curseiros.main.curso.repositories.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UpdateCursoUseCase {

    @Autowired
    private CursoRepository cursoRepository;

    public Optional<CursoEntity> execute(Long id, CursoUpdateDTO cursoUpdateDTO) {

        var result = cursoRepository.findById(id)
                .map(curso -> {
                    if(cursoUpdateDTO.name() != null) curso.setName(cursoUpdateDTO.name());
                    if(cursoUpdateDTO.category() != null) curso.setCategory(cursoUpdateDTO.category());
                    if(cursoUpdateDTO.professor() != null) curso.setProfessor(cursoUpdateDTO.professor());

                    return cursoRepository.save(curso);
                });

        return result;


    }
}
