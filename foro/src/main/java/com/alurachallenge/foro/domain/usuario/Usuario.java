package com.alurachallenge.foro.domain.usuario;

import com.alurachallenge.foro.domain.topico.Topico;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "usuarios")
@Entity(name = "Usuario")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Boolean activo;
    private String nombre;
    private String correoElectronico;
    private String contrasena;

    @OneToMany
    private Topico topico;

    public Usuario(DatosDetallesUsuario datos){
        this.id = null;
        this.activo = true;
        this.nombre = datos.nombre();
        this.correoElectronico = datos.correoElectronico();
        this.contrasena = datos.contrasena();
        this.topico = datos.topico();
    }
}
