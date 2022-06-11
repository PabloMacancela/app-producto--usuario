package com.pablojmi.proyecto.controller

import com.pablojmi.proyecto.model.Promocion
import com.pablojmi.proyecto.service.PromocionService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/promocion")

class PromocionController {
    @Autowired
    lateinit var promocionService: PromocionService

    @GetMapping
    fun list(): List<Promocion>{
        return promocionService.list()
    }
    @PostMapping
    fun save (@RequestBody promocion: Promocion): Promocion{
        return promocionService.save(promocion)
    }
   @PutMapping
    fun update (@RequestBody promocion: Promocion):Promocion{
        return promocionService.update(promocion)
   }
    @PatchMapping
    fun updateName(@RequestBody promocion: Promocion): Promocion{
        return promocionService.updateName(promocion)
    }
    @DeleteMapping("/delete/{id}")
    fun delete (@PathVariable("id") id: Long): Boolean{
        return promocionService.delete(id )
    }
    @GetMapping("/{id}")
    fun listById (@PathVariable("id") id: Long): Promocion?{
        return promocionService.getById(id)
    }

}