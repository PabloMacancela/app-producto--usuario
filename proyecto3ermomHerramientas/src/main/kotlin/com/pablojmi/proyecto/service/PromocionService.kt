package com.pablojmi.proyecto.service

import com.pablojmi.proyecto.model.Promocion
import com.pablojmi.proyecto.repository.PromocionRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service

class PromocionService {
    @Autowired
    lateinit var promocionRepository: PromocionRepository

    fun list(): List<Promocion> {
        return promocionRepository.findAll()
    }

    fun save (promocion: Promocion):Promocion {

        return promocionRepository.save(promocion)
        }

    fun update(promocion: Promocion): Promocion {
        promocionRepository.findById(promocion.id) ?: throw Exception()

        return  promocionRepository.save(promocion)

    }

    fun updateName(promocion: Promocion): Promocion {

        val  response= promocionRepository.findById(promocion.id)
            ?:throw Exception()
        response.id=promocion.id

        return promocionRepository.save(response)

    }

    fun delete (id:Long): Boolean{
        promocionRepository.deleteById(id)
        return true
    }

    fun getById (id: Long?): Promocion?{
        return promocionRepository.findById(id)
    }


}