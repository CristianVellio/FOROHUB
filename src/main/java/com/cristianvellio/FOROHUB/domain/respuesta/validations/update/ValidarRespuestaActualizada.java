package com.cristianvellio.FOROHUB.domain.respuesta.validations.update;

import com.cristianvellio.FOROHUB.domain.respuesta.dto.ActualizarRespuestaDTO;

public interface ValidarRespuestaActualizada {

    void validate(ActualizarRespuestaDTO data, Long respuestaId);
}