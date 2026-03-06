package com.alurachallenge.foro.domain.usuario;

import com.alurachallenge.foro.domain.topico.Topico;
import jakarta.persistence.OneToMany;

public record DatosDetallesUsuario(

        Long id,
        Boolean activo,
        String nombre,
        String correoElectronico,
        String contrasena,
        Topico topico
) {
}
