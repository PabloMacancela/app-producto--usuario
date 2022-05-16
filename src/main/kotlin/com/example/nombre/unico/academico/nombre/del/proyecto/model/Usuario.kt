package com.example.nombre.unico.academico.nombre.del.proyecto.model

import javax.persistence.*
@Entity
@Table(name = "usuario")

class Usuario {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id : Long? = null
    var name : String? = null
}