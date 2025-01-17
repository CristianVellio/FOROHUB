package com.cristianvellio.FOROHUB.domain.curso.dto;

import com.cristianvellio.FOROHUB.domain.curso.Categoria;

public record ActualizarCursoDTO(String name,
        Categoria categoria, Boolean activo) {

}
