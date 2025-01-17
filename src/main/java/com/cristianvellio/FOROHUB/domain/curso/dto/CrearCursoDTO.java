package com.cristianvellio.FOROHUB.domain.curso.dto;

import com.cristianvellio.FOROHUB.domain.curso.Categoria;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CrearCursoDTO(@NotBlank String name,
        @NotNull Categoria categoria) {

}
