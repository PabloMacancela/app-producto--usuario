package com.example.nombre.unico.academico.nombre.del.proyecto.service

import com.example.nombre.unico.academico.nombre.del.proyecto.model.Producto
import com.example.nombre.unico.academico.nombre.del.proyecto.model.Usuario
import com.example.nombre.unico.academico.nombre.del.proyecto.repository.ProductoRepository
import com.example.nombre.unico.academico.nombre.del.proyecto.repository.UsuarioRepository
import org.springframework.beans.factory.annotation.Autowired

class UsuarioService {
    @Autowired
    lateinit var usuarioRepository: UsuarioRepository

    fun list() :List<Usuario>{
        return usuarioRepository.findAll()
    }

    fun save (usuario: Usuario){
        val usuario = null
    }
}