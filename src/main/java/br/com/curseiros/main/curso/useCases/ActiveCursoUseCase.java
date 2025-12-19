package br.com.curseiros.main.curso.useCases;

import br.com.curseiros.main.curso.entities.CursoEntity;
import br.com.curseiros.main.curso.repositories.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ActiveCursoUseCase {

    @Autowired
    private CursoRepository cursoRepository;

    public Optional<CursoEntity> execute(Long id){

        var curso = cursoRepository.findById(id).map(c -> {
            c.setActive(!c.isActive());
            cursoRepository.save(c);
            return cursoRepository.save(c);
        });
        return curso;
    }
}
