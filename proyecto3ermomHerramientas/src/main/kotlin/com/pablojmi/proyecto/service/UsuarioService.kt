package com.pablojmi.proyecto.service

import com.pablojmi.proyecto.dto.NuevoProducto
import com.pablojmi.proyecto.model.Usuario
import com.pablojmi.proyecto.repository.PromocionRepository
import com.pablojmi.proyecto.repository.UsuarioRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.server.ResponseStatusException

@Service

class UsuarioService {
    @Autowired
    lateinit var usuarioRepository: UsuarioRepository
    @Autowired
    lateinit var profesorRepository: PromocionRepository



    fun list(): List<Usuario> {
        return usuarioRepository.findAll()
    }

    fun save(usuario: Usuario):Usuario{
        try {
            profesorRepository.findById(usuario.profesorId) ?: throw Exception("Id de promocion no existe")
            return usuarioRepository.save(usuario)
        }catch (ex : Exception){
            throw ResponseStatusException(
                HttpStatus.NOT_FOUND, ex.message, ex)
        }
    }

    fun update(usuario: Usuario): Usuario {
        try {
            usuarioRepository.findById(usuario.id) ?: throw Exception("El id ${usuario.id} el comprador no existe")

            return usuarioRepository.save(usuario)
        }
        catch (ex:Exception){
            throw ResponseStatusException(
                HttpStatus.NOT_FOUND,ex.message,ex)
        }
    }

    fun updateName(usuario: Usuario):Usuario{

        val response= usuarioRepository.findById(usuario.id)
            ?:throw Exception()
        response.username=usuario.username


        return usuarioRepository.save(response)


    }

    fun delete (id:Long): Boolean{
        usuarioRepository.deleteById(id)
        return true
    }

    fun getById (id: Long?):Usuario?{
        return usuarioRepository.findById(id)
    }

    fun getByInventarios (inventarios: Long?): List<Usuario>?{
        return usuarioRepository.getListActiveInventarios(inventarios)
    }

    @Transactional
    fun updateOtherName (NuevoProducto: NuevoProducto): String?{
        val rowsUpdate=usuarioRepository.setOtherName(NuevoProducto.nombre, NuevoProducto.nuevoAlumno)
        return "${rowsUpdate} rows updated"
    }


}