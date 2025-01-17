package com.cristianvellio.FOROHUB.domain.respuesta.validations.update;

import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cristianvellio.FOROHUB.domain.respuesta.Respuesta;
import com.cristianvellio.FOROHUB.domain.respuesta.dto.ActualizarRespuestaDTO;
import com.cristianvellio.FOROHUB.domain.respuesta.repository.RespuestaRepository;
import com.cristianvellio.FOROHUB.domain.topico.Estado;
import com.cristianvellio.FOROHUB.domain.topico.repository.TopicoRepository;

@Component
public class SolucionDuplicada implements ValidarRespuestaActualizada {

    @Autowired
    private RespuestaRepository respuestaRepository;

    @Autowired
    private TopicoRepository topicoRepository;

    @Override
    public void validate(ActualizarRespuestaDTO data, Long respuestaId) {
        if (data.solucion()) {
            Respuesta respuesta = respuestaRepository.getReferenceById(respuestaId);
            var topicoResuelto = topicoRepository.getReferenceById(respuesta.getTopico().getId());
            if (topicoResuelto.getEstado() == Estado.CLOSED) {
                throw new ValidationException("Este topico ya esta solucionado.");
            }
        }
    }
}