package com.alurachallenge.foro.domain.topico;

import com.alurachallenge.foro.domain.usuario.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Table(name = "topicos")
@Entity(name = "Topico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensaje;
    private LocalDate fecha;
    private Boolean estado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id")
    private Usuario autor;
    private String curso;

    public Topico(DatosDetalleTopico datos){
        this.id = null;
        this.titulo = datos.titulo();
        this.mensaje = datos.mensaje();
        this.fecha = LocalDate.now();
        this.estado = true;
        this.autor = datos.autor();
        this.curso = datos.curso();
    }

}
