package com.cristianvellio.FOROHUB.domain.topico.validations.create;

import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cristianvellio.FOROHUB.domain.curso.repository.CursoRepository;
import com.cristianvellio.FOROHUB.domain.topico.dto.CrearTopicoDTO;

@Component
public class ValidarCursoCreado implements ValidarTopicoCreado {

    @Autowired
    private CursoRepository repository;

    @Override
    public void validate(CrearTopicoDTO data) {
        var ExisteCurso = repository.existsById(data.cursoId());
        if (!ExisteCurso) {
            throw new ValidationException("Este curso no existe.");
        }

        var cursoHabilitado = repository.findById(data.cursoId()).get().getActivo();
        if (!cursoHabilitado) {
            throw new ValidationException("Este curso no esta disponible en este momento.");
        }
    }
}