package com.pablojmi.proyecto.model

import javax.persistence.*
@Entity
@Table(name = "producto")

class Producto {


        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Id
        @Column(updatable = false)
        var id : Long? = null
        var name : String? = null
        var percios: String? = null
        var inventarios: Long? = null
        @Column(name="promocion_id")
        var promocionId:Long?=null
        @Column(name="tienda_id")
        var tiendaId:Long?=null



}