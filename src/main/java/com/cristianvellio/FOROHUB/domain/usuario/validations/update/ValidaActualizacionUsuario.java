package com.cristianvellio.FOROHUB.domain.usuario.validations.update;

import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cristianvellio.FOROHUB.domain.usuario.dto.ActualizarUsuarioDTO;
import com.cristianvellio.FOROHUB.domain.usuario.repository.UsuarioRepository;

@Component
public class ValidaActualizacionUsuario implements ValidarActualizarUsuario {

    @Autowired
    private UsuarioRepository repository;

    @Override
    public void validate(ActualizarUsuarioDTO data) {
        if (data.email() != null) {
            var emailDuplicado = repository.findByEmail(data.email());
            if (emailDuplicado != null) {
                throw new ValidationException("Este email ya esta en uso");
            }
        }
    }
}