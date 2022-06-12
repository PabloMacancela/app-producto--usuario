package com.pablojmi.proyecto.model

import javax.persistence.*


@Entity
@Table(name = "Deporte")
class Deporte {


    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null
    var name:String?=null
    var hora: String? = null
    var cancha: String?= null

}