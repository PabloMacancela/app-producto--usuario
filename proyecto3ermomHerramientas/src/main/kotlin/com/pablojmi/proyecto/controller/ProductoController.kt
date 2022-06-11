package com.pablojmi.proyecto.controller

import com.pablojmi.proyecto.dto.NuevoProducto
import com.pablojmi.proyecto.model.Producto
import com.pablojmi.proyecto.service.ProductoService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/producto")

class ProductoController {
    @Autowired
    lateinit var productoService: ProductoService

    @GetMapping

            fun List(): List<Producto> {
                return  productoService.list()
    }
    @GetMapping("/inventarios/{inventarios}")
    fun listByInventarios (@PathVariable("inventarios") inventarios: Long): List<Producto>? {
        return productoService.getByInventarios(inventarios)
    }

    @PostMapping
    fun save (@RequestBody producto: Producto): Producto {
        return  productoService.save(producto)
    }

    @PostMapping("/change/name")
    fun updateOtherName (@RequestBody nuevoProducto: NuevoProducto): String?{
        return productoService.updateOtherName(nuevoProducto)
    }
    @PutMapping
    fun update (@RequestBody producto: Producto): Producto {
        return productoService.update(producto)

    }

    @PatchMapping
    fun updateName(@RequestBody producto: Producto): Producto {
        return productoService.updateName(producto)

    }

    @DeleteMapping("/delete/{id}")
    fun delete (@PathVariable("id") id: Long): Boolean{
        return productoService.delete(id )
    }

    @GetMapping("/{id}")
    fun listById (@PathVariable("id") id: Long): Producto?{
        return productoService.getById(id)
    }





}