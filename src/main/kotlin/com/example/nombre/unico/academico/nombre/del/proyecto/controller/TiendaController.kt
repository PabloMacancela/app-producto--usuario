package com.example.nombre.unico.academico.nombre.del.proyecto.controller

import com.example.nombre.unico.academico.nombre.del.proyecto.model.Tienda
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

class TiendaController {
    @RestController
    @RequestMapping
    class StudentController {

        @Autowired
        lateinit var tiendaController: TiendaController

        fun list ():List <Tienda>{
            return tiendaController.list()
        }
    }
}