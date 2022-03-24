package com.vinicius.businesscard.data

import androidx.room.Entity
import androidx.room.PrimaryKey
//PRIMEIRO PASSO PARA IMPLEMENTAÇÃO DO ROOM
@Entity
data class BusinessCard(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String,
    val company: String,
    val phoneNumber: String,
    val email: String,
    val backgroundUser: String
)
