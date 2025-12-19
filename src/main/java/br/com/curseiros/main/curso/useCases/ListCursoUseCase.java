package br.com.curseiros.main.curso.useCases;

import br.com.curseiros.main.curso.entities.CursoEntity;
import br.com.curseiros.main.curso.repositories.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListCursoUseCase {

    @Autowired
    private CursoRepository cursoRepository;

    public List<CursoEntity> execute(){
        List<CursoEntity> listCursos = cursoRepository.findAll();
        return listCursos;
    }
}
