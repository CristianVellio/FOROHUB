package com.cristianvellio.FOROHUB.domain.usuario.validations.create;

import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cristianvellio.FOROHUB.domain.usuario.dto.CrearUsuarioDTO;
import com.cristianvellio.FOROHUB.domain.usuario.repository.UsuarioRepository;

@Component
public class UsuarioDuplicado implements ValidarCrearUsuario {

    @Autowired
    private UsuarioRepository repository;

    @Override
    public void validate(CrearUsuarioDTO data) {
        var usuarioDuplicado = repository.findByUsername(data.username());
        if (usuarioDuplicado != null) {
            throw new ValidationException("Este usuario ya existe.");
        }

        var emailDuplicado = repository.findByEmail(data.email());
        if (emailDuplicado != null) {
            throw new ValidationException("Este email ya existe.");
        }
    }
}