package com.example.nombre.unico.academico.nombre.del.proyecto.service

import com.example.nombre.unico.academico.nombre.del.proyecto.model.Tienda
import org.springframework.beans.factory.annotation.Autowired

class TiendaService {

        @Autowired
        lateinit var tiendaService: TiendaService

        fun list ():List<Tienda>{
            return tiendaService.findAll()

        }

    private fun findAll(): List<Tienda> {


}

    fun findById(id: Long?): Nothing? {

    }

