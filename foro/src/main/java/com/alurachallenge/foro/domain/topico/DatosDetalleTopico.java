package com.alurachallenge.foro.domain.topico;

import com.alurachallenge.foro.domain.usuario.Usuario;

import java.time.LocalDate;

public record DatosDetalleTopico(

        Long id,
        String titulo,
        String mensaje,
        LocalDate fecha,
        Boolean estado,
        String autor,
        String curso
) {
    public DatosDetalleTopico(Topico topico){
        this
        (topico.getId(),
        topico.getTitulo(),
        topico.getMensaje(),
        topico.getFecha(),
        topico.getEstado(),
        topico.getAutor().getNombre(),
        topico.getCurso()
        );
    }
}
