package com.example.nombre.unico.academico.nombre.del.proyecto.service

import com.example.nombre.unico.academico.nombre.del.proyecto.model.Producto
import com.example.nombre.unico.academico.nombre.del.proyecto.repository.ProductoRepository
import org.apache.coyote.Response
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.server.ResponseStatusException
import java.util.*
import kotlin.system.exitProcess

@Service
class ProductoService {

    @Autowired
    lateinit var productoRepository: ProductoRepository
    lateinit var tiendaService: TiendaService

    @GetMapping
    fun list(): List<Producto> {
        return productoRepository.findAll()

    }

    fun save(producto: Producto): Producto {
        try {
            tiendaService.findById(producto.id) ?: throw Exception ("Id persona no encontrada")
            return productoRepository.save(producto)
        }catch (ex : Exception){
            throw ResponseStatusException(
                    HttpStatus.NOT_FOUND, ex.message, ex)
        }

    }

    //update tb set name: 'java' where id=5
    fun update(producto: Producto): Producto {
        try{

        productoRepository.findById(1)
                ?: throw Exception("El id ${producto.id} el producto no existe" )
        return productoRepository.save(producto)
        }

        catch(ex:Exception){

        throw ResponseStatusException(
               HttpStatus.NOT_FOUND, ex.message, ex)
        }
    }

    fun updateName(producto: Producto): Producto {

        val response = productoRepository.findById(1)
                ?: throw Exception()

        response.apply {
            var name = producto.name
            return productoRepository.save(producto)

        }
        }
        fun delete (id: Long): Boolean{
            productoRepository.delete(id)
            return true

        }
    fun getByid (id: Long?): Producto? {
        return productoRepository.findById(id)
    }


    }





