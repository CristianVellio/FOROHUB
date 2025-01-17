package com.cristianvellio.FOROHUB.domain.respuesta.validations.create;

import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cristianvellio.FOROHUB.domain.respuesta.dto.CrearRespuestaDTO;
import com.cristianvellio.FOROHUB.domain.usuario.repository.UsuarioRepository;

@Component
public class RespuestaUsuarioValida implements ValidarRespuestaCreada {

    @Autowired
    private UsuarioRepository repository;

    @Override
    public void validate(CrearRespuestaDTO data) {
        var usuarioExiste = repository.existsById(data.usuarioId());

        if (!usuarioExiste) {
            throw new ValidationException("Este usuario no existe");
        }

        var usuarioHabilitado = repository.findById(data.usuarioId()).get().isEnabled();

        if (!usuarioHabilitado) {
            throw new ValidationException("Este usuario no esta habilitado");
        }
    }
}