package com.pablojmi.proyecto.model

import javax.persistence.*

@Entity
@Table(name="promocion")

class Promocion {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id:Long?=null
    var nombre: String?=null
    var precio: String?=null
}