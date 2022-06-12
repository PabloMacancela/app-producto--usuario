package com.pablojmi.proyecto.service

import com.pablojmi.proyecto.dto.NuevoProducto
import com.pablojmi.proyecto.model.Producto
import com.pablojmi.proyecto.repository.ProductoRepository
import com.pablojmi.proyecto.repository.PromocionRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.server.ResponseStatusException


@Service


class ProductoService {
    @Autowired
    lateinit var productoRepository: ProductoRepository
    @Autowired
    lateinit var promocionRepository: PromocionRepository



    fun list(): List<Producto> {
        return productoRepository.findAll()
    }

    fun save(producto: Producto):Producto{
        try {
            promocionRepository.findById(producto.promocionId) ?: throw Exception("Id de promocion no existe")
            return productoRepository.save(producto)
        }catch (ex : Exception){
            throw ResponseStatusException(
                HttpStatus.NOT_FOUND, ex.message, ex)
        }
    }

    fun update(producto: Producto): Producto {
        try {
            productoRepository.findById(producto.id) ?: throw Exception("El id ${producto.id} el producto no existe")

            return productoRepository.save(producto)
        }
        catch (ex:Exception){
            throw ResponseStatusException(
                HttpStatus.NOT_FOUND,ex.message,ex)
        }
    }

    fun updateName(producto: Producto):Producto{

      val response= productoRepository.findById(producto.id)
              ?:throw Exception()
        response.name=producto.name


        return productoRepository.save(response)


    }

    fun delete (id:Long): Boolean{
        productoRepository.deleteById(id)
        return true
    }

    fun getById (id: Long?):Producto?{
        return productoRepository.findById(id)
    }

    fun getByInventarios (inventarios: Long?): List<Producto>?{
        return productoRepository.getListActiveInventarios(inventarios)
    }

    @Transactional
    fun updateOtherName (NuevoProducto:NuevoProducto): String?{
        val rowsUpdate=productoRepository.setOtherName(NuevoProducto.nombre, NuevoProducto.nuevoAlumno)
        return "${rowsUpdate} rows updated"
    }




}