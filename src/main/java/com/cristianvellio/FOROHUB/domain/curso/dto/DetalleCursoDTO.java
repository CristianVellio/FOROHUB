package com.cristianvellio.FOROHUB.domain.curso.dto;

import com.cristianvellio.FOROHUB.domain.curso.Categoria;
import com.cristianvellio.FOROHUB.domain.curso.Curso;

public record DetalleCursoDTO(Long id,
        String name,
        Categoria categoria,
        Boolean activo) {

    public DetalleCursoDTO(Curso curso) {
        this(
                curso.getId(),
                curso.getName(),
                curso.getCategoria(),
                curso.getActivo());
    }
}
