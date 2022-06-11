package com.pablojmi.proyecto.controller

import com.pablojmi.proyecto.dto.NuevoProducto
import com.pablojmi.proyecto.model.Usuario
import com.pablojmi.proyecto.service.UsuarioService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/usuario")

class UsuarioController {

    @Autowired
    lateinit var usuarioService: UsuarioService

    @GetMapping

    fun List(): List<Usuario> {
        return  usuarioService.list()
    }
    @GetMapping("/inventarios/{inventarios}")
    fun listByInventarios (@PathVariable("inventarios") inventarios: Long): List<Usuario>? {
        return usuarioService.getByInventarios(inventarios)
    }

    @PostMapping
    fun save (@RequestBody usuario: Usuario): Usuario {
        return  usuarioService.save(usuario)
    }

    @PostMapping("/change/name")
    fun updateOtherName (@RequestBody NuevoProducto: NuevoProducto): String?{
        return usuarioService.updateOtherName(NuevoProducto)
    }
    @PutMapping
    fun update (@RequestBody usuario: Usuario): Usuario{
        return usuarioService.update(usuario)

    }

    @PatchMapping
    fun updateName(@RequestBody usuario: Usuario): Usuario {
        return usuarioService.updateName(usuario)

    }

    @DeleteMapping("/delete/{id}")
    fun delete (@PathVariable("id") id: Long): Boolean{
        return usuarioService.delete(id )
    }

    @GetMapping("/{id}")
    fun listById (@PathVariable("id") id: Long): Usuario?{
        return usuarioService.getById(id)
    }
}