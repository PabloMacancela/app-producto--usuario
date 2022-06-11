package com.pablojmi.proyecto.controller

import com.pablojmi.proyecto.model.Tienda
import com.pablojmi.proyecto.service.TiendaService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/tienda")

class TiendaController {
    @Autowired
    lateinit var tiendaService: TiendaService
    @GetMapping

    fun List(): List<Tienda>{
        return tiendaService.list()

    }
    @PostMapping
    fun save (@RequestBody tienda: Tienda) {
        tiendaService.save(tienda)
    }

    @PutMapping
    fun update (@RequestBody tienda: Tienda): Tienda{
        return tiendaService.update(tienda)
    }
    @PatchMapping
    fun updateName( @RequestBody tienda: Tienda) {
        return  tiendaService.updateName(tienda)
    }
    @DeleteMapping("/delete/{id}")
    fun delete (@PathVariable("id") id: Long): Boolean{
        return tiendaService.delete(id )
    }

    @GetMapping("/{id}")
    fun listById (@PathVariable("id") id: Long): Tienda?{
        return tiendaService.getById(id)
    }

}