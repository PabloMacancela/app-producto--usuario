package com.pablojmi.proyecto.repository

import com.pablojmi.proyecto.model.Promocion
import org.springframework.data.jpa.repository.JpaRepository

interface PromocionRepository:JpaRepository<Promocion,Long> {
    fun findById(id:Long?):Promocion?
}

