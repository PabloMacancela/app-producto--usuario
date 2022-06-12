package com.pablojmi.proyecto.service

import com.pablojmi.proyecto.model.Deporte
import com.pablojmi.proyecto.model.DeporteView
import com.pablojmi.proyecto.repository.DeporteRepository
import com.pablojmi.proyecto.repository.DeporteViewRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.server.ResponseStatusException

class DeporteService {

    @Autowired
    lateinit var deporteRepository: DeporteRepository

    @Autowired
    lateinit var deporteViewRepository: DeporteViewRepository

    fun list():List<Deporte>{
        return deporteRepository.findAll()
    }

    fun getById(id:Long?): Deporte?{
        return deporteRepository.findById(id)
    }

    fun getByDeport(name: String?):List<Deporte>?{
        return deporteRepository.getListadeDeport(name)
    }

    fun getFrecuenciaHora(): List<DeporteView>{
        return deporteViewRepository.findAll()

    }

    fun save(deporte: Deporte): Deporte {
        try {
            deporte.name?.takeIf { it.trim().isNotEmpty() }
                ?: throw Exception("Descripcion no debe ser vacio")
            return deporteRepository.save(deporte)
        } catch (ex: Exception){
            throw ResponseStatusException(
                HttpStatus.NOT_FOUND, ex.message, ex
            )
        }
    }

    fun update ( deporte: Deporte): Deporte {
        deporteRepository.findById(deporte.id)?: throw Exception()
        return deporteRepository.save(deporte)
    }

    fun updateName(deporte: Deporte): Deporte{
        try {
            val response = deporteRepository.findById(deporte.id)
                ?: throw Exception("El id ${deporte.id} del usuario no existe")
            response.apply {
                this.name = deporte.name
            }
            return deporteRepository.save(deporte)
        }
        catch (ex: Exception){
            throw ResponseStatusException(
                HttpStatus.NOT_FOUND, ex.message, ex
            )
        }

    }


    fun delete (id:Long): Boolean{
        deporteRepository.deleteById(id)
        return true
    }


}
