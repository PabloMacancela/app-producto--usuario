package com.example.nombre.unico.academico.nombre.del.proyecto.controller

import com.example.nombre.unico.academico.nombre.del.proyecto.model.Usuario
import com.example.nombre.unico.academico.nombre.del.proyecto.service.UsuarioService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/usuario")

class UsuarioController {
    @Autowired
    lateinit var Usuarioservice: UsuarioService
    @GetMapping
    fun List(): List<Usuario> {
        return  Usuarioservice.list()
    }
}