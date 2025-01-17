package com.cristianvellio.FOROHUB.domain.topico.dto;

import java.time.LocalDateTime;

import com.cristianvellio.FOROHUB.domain.curso.Categoria;
import com.cristianvellio.FOROHUB.domain.topico.Estado;
import com.cristianvellio.FOROHUB.domain.topico.Topico;

public record DetallesTopicoDTO(
        Long id,
        String titulo,
        String mensaje,
        LocalDateTime fechaCreacion,
        LocalDateTime ultimaActualizacion,
        Estado estado,
        String usuario,
        String curso,
        Categoria categoriaCurso

) {

    public DetallesTopicoDTO(Topico topico) {
        this(topico.getId(),
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getFechaCreacion(),
                topico.getUltimaActualizacion(),
                topico.getEstado(),
                topico.getUsuario().getUsername(),
                topico.getCurso().getName(),
                topico.getCurso().getCategoria());
    }

}