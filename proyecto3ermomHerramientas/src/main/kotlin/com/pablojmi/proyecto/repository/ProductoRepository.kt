package com.pablojmi.proyecto.repository

import com.pablojmi.proyecto.model.Producto
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface ProductoRepository: JpaRepository<Producto,Long> {
    fun findById(id:Long?):Producto?


    @Query(nativeQuery = true)
    fun getListActiveInventarios (@Param("Inventarios") Inventarios:Long?) : List<Producto>?

    @Modifying
    @Query(nativeQuery=true)
    fun setOtherName (@Param("name")  name:String?, @Param("newName")  newName:String?) : Integer?


}
