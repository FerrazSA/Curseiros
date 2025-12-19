package br.com.curseiros.main.curso.useCases;

import br.com.curseiros.exceptions.CursoFoundException;
import br.com.curseiros.main.curso.entities.CursoEntity;
import br.com.curseiros.main.curso.repositories.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateCursoUseCase {

    @Autowired
    private CursoRepository cursoRepository;

    public CursoEntity execute(CursoEntity curso) {
        cursoRepository
                .findByName(curso.getName())
                .ifPresent((user) -> {
                    throw new CursoFoundException();
                });

        return cursoRepository.save(curso);
    }
}
