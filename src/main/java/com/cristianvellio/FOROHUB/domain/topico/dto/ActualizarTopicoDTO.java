package com.cristianvellio.FOROHUB.domain.topico.dto;

import com.cristianvellio.FOROHUB.domain.topico.Estado;

public record ActualizarTopicoDTO(
                String titulo,
                String mensaje,
                Estado estado,
                Long cursoId) {
}