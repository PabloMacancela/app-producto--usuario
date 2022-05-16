package com.example.nombre.unico.academico.nombre.del.proyecto.repository

import com.example.nombre.unico.academico.nombre.del.proyecto.model.Producto
import org.springframework.data.jpa.repository.JpaRepository

interface ProductoRepository:JpaRepository< Producto, Long> {
    fun findById(id:Long?):Producto?
    abstract fun delete(id: Long)


}