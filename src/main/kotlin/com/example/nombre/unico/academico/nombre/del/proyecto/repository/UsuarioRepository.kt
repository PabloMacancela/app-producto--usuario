package com.example.nombre.unico.academico.nombre.del.proyecto.repository

import com.example.nombre.unico.academico.nombre.del.proyecto.model.Usuario
import org.springframework.data.jpa.repository.JpaRepository

interface UsuarioRepository: JpaRepository<Usuario,Long> {
    abstract fun finAll(): List<Usuario>
}