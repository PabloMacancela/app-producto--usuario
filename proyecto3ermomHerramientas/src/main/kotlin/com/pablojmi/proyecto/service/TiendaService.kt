package com.pablojmi.proyecto.service

import com.pablojmi.proyecto.model.Tienda
import com.pablojmi.proyecto.repository.TiendaRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service

class TiendaService {
    @Autowired
    lateinit var tiendaRepository: TiendaRepository

    fun list():List<Tienda>{
        return tiendaRepository.findAll()
    }

    fun save (tienda: Tienda):Tienda {
        return tiendaRepository.save(tienda)
    }
    fun update(tienda: Tienda): Tienda {
        tiendaRepository.findById(tienda.id)

        return  tiendaRepository.save(tienda)
    }
    fun updateName(tienda: Tienda) {
        val response=tiendaRepository.findById(tienda.id)
            ?:throw Exception()
        response.nombre=tienda.nombre

    }

    fun delete(id: Long): Boolean{
        tiendaRepository.deleteById(id)
        return true
    }

    fun getById (id: Long?): Tienda?{
        return tiendaRepository.findById(id)
    }

}