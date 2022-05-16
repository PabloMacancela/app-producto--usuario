package com.example.nombre.unico.academico.nombre.del.proyecto.controller

import com.example.nombre.unico.academico.nombre.del.proyecto.model.Producto
import com.example.nombre.unico.academico.nombre.del.proyecto.service.ProductoService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/producto")
    class ProductoController {
    @Autowired
    lateinit var productoservice: ProductoService

    @GetMapping
    fun List(): List<Producto> {
        return productoservice.list()

    }

    @GetMapping
    fun ListByid (@PathVariable("id")producto : List<Producto>{
        return productoservice.list()!in

    }

    @PostMapping
    fun save(@RequestBody student: Producto): Producto {
        return productoservice.save(student)
    }

    @PutMapping
    fun update(@RequestBody producto: Producto) {
        productoservice.update(producto)
    }

    @DeleteMapping( "/delete/{id}")
    fun delete(@PathVariable("id") id: Long): Boolean {
        return productoservice.delete(id)

    }
}








