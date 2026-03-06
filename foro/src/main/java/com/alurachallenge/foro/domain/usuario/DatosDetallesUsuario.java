package com.alurachallenge.foro.domain.usuario;

import com.alurachallenge.foro.domain.topico.Topico;
import jakarta.persistence.OneToMany;

public record DatosDetallesUsuario(Long id, String nombre, String email) {
    public DatosDetallesUsuario(Usuario usuario) {
        this(usuario.getId(), usuario.getNombre(), usuario.getEmail());
    }
}
