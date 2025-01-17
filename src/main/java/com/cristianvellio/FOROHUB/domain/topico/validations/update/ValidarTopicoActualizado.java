package com.cristianvellio.FOROHUB.domain.topico.validations.update;

import com.cristianvellio.FOROHUB.domain.topico.dto.ActualizarTopicoDTO;

public interface ValidarTopicoActualizado {
    void validate(ActualizarTopicoDTO data);
}