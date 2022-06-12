package com.pablojmi.proyecto.controller


import com.pablojmi.proyecto.model.Deporte
import com.pablojmi.proyecto.model.DeporteView
import com.pablojmi.proyecto.service.DeporteService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

class DeporteController {

    @RestController
    @RequestMapping("/deporte")
    class DeporteController {

        @Autowired
        lateinit var deporteService: DeporteService

        @GetMapping
        fun list(): List<Deporte>{
            return deporteService.list()
        }

        @GetMapping("/{id}")
        fun listById (@PathVariable("id") id: Long): Deporte?{
            return deporteService.getById(id)
        }


        @GetMapping("/name/{name}")
        fun listByNombresDeport(@PathVariable("name") name:String): List<Deporte>?{
            return deporteService.getByDeport(name)
        }
        @GetMapping("/frecuencia/hora")
        fun getFrecuenciaHora (): List<DeporteView>?{
            return deporteService.getFrecuenciaHora()
        }


        @PostMapping
        fun save(@RequestBody deporte: Deporte): Deporte{
            return deporteService.save(deporte)
        }

        @PutMapping
        fun update(@RequestBody deporte: Deporte): Deporte{
            return deporteService.update(deporte)
        }

        @PatchMapping
        fun updateName(@RequestBody deporte: Deporte): Deporte{
            return deporteService.updateName(deporte)
        }

        @DeleteMapping("/delete/{id}")
        fun delete (@PathVariable("id") id: Long):Boolean{
            return deporteService.delete(id)
        }


    }
}