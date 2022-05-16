package com.example.nombre.unico.academico.nombre.del.proyecto.repository

import com.example.nombre.unico.academico.nombre.del.proyecto.model.Tienda
import org.springframework.data.jpa.repository.JpaRepository

interface TiendaRepository :JpaRepository<Tienda, Long>  {
    fun findByid (id:Long?):Tienda?

}