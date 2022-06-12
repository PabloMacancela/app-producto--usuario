package com.pablojmi.proyecto.repository

import com.pablojmi.proyecto.model.Deporte
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface DeporteRepository: JpaRepository<Deporte, Long> {

    fun findById(id: Long?): Deporte?

    @Query(nativeQuery = true)
    fun getListadeDeport(@Param("name") name: String?):List <Deporte>?


    @Modifying
    @Query(nativeQuery = true)
    fun setOtherdeportes(@Param("cancha") cancha: String?, @Param("frecuencia") frecuencia: String?): Integer?;