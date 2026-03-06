package com.alurachallenge.foro.controller;

import com.alurachallenge.foro.domain.usuario.DatosDetallesUsuario;
import com.alurachallenge.foro.domain.usuario.DatosRegistroUsuario;
import com.alurachallenge.foro.domain.usuario.Usuario;
import com.alurachallenge.foro.domain.usuario.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/registro/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository repository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @PostMapping
    @Transactional
    public ResponseEntity registrar(@RequestBody @Valid DatosRegistroUsuario datos) {
        // 1. Hashear la contraseña
        String passwordHasheada = passwordEncoder.encode(datos.contrasena());

        // 2. Crear el usuario con la contraseña cifrada
        var usuario = new Usuario(datos, passwordHasheada);

        // 3. Guardar en la DB
        repository.save(usuario);

        return ResponseEntity.ok(new DatosDetallesUsuario(usuario));
    }
}