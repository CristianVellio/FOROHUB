package com.cristianvellio.FOROHUB.domain.usuario.dto;

import com.cristianvellio.FOROHUB.domain.usuario.Role;

public record ActualizarUsuarioDTO(
                String password,
                Role role,
                String nombre,
                String apellido,
                String email,
                Boolean enabled) {
}