package com.vinicius.businesscard.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

//SEGUNDO PASSO PARA A IMPLEMENTAÇÃO DO ROOM

@Dao
interface BusinessCardDao {

    @Query("SELECT * FROM BusinessCard")
    fun getAll():LiveData<List<BusinessCard>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(businessCard: BusinessCard)
}