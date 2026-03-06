package com.alurachallenge.foro.domain.topico;

import com.alurachallenge.foro.domain.usuario.Usuario;
import jakarta.persistence.ManyToOne;

import java.time.LocalDate;

public record DatosDetalleTopico(

        Long id,
        String titulo,
        String mensaje,
        LocalDate fecha,
        Boolean estado,
        Usuario autor,
        String curso
) {
}
