package com.cristianvellio.FOROHUB.domain.usuario.validations.create;

import com.cristianvellio.FOROHUB.domain.usuario.dto.CrearUsuarioDTO;

public interface ValidarCrearUsuario {
    void validate(CrearUsuarioDTO data);
}