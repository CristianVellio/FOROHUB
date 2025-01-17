package com.cristianvellio.FOROHUB.domain.respuesta.validations.create;

import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cristianvellio.FOROHUB.domain.respuesta.dto.CrearRespuestaDTO;
import com.cristianvellio.FOROHUB.domain.topico.Estado;
import com.cristianvellio.FOROHUB.domain.topico.repository.TopicoRepository;

@Component
public class RespuestaTopicoValida implements ValidarRespuestaCreada {

    @Autowired
    private TopicoRepository repository;

    @Override
    public void validate(CrearRespuestaDTO data) {
        var topicoExiste = repository.existsById(data.topicoId());

        if (!topicoExiste) {
            throw new ValidationException("Este topico no existe.");
        }

        var topicoAbierto = repository.findById(data.topicoId()).get().getEstado();

        if (topicoAbierto != Estado.OPEN) {
            throw new ValidationException("Este topico no esta abierto.");
        }

    }
}