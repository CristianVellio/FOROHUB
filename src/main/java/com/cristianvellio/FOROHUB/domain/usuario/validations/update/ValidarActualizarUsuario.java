package com.cristianvellio.FOROHUB.domain.usuario.validations.update;

import com.cristianvellio.FOROHUB.domain.usuario.dto.ActualizarUsuarioDTO;

public interface ValidarActualizarUsuario {
    void validate(ActualizarUsuarioDTO data);
}