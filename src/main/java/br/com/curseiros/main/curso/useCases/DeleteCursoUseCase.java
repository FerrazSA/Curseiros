package br.com.curseiros.main.curso.useCases;

import br.com.curseiros.main.curso.repositories.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteCursoUseCase {

    @Autowired
    private CursoRepository cursoRepository;

    public void execute(Long id){
        cursoRepository.deleteById(id);
    }
}
