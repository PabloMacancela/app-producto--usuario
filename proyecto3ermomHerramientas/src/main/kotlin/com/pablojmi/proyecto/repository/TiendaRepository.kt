package com.pablojmi.proyecto.repository

import com.pablojmi.proyecto.model.Tienda
import org.springframework.data.jpa.repository.JpaRepository

interface TiendaRepository: JpaRepository<Tienda,Long> {


    fun findById(id:Long?):Tienda?
}