package com.vinicius.businesscard.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.vinicius.businesscard.data.BusinessCard
import com.vinicius.businesscard.data.BusinessCardRepository

//QUINTO PASSO PARA A IMPLEMENTAÇÃO DO ROOM
class MainViewModel(private val businessCardRepository: BusinessCardRepository) : ViewModel() {

    fun insert(businessCard: BusinessCard) {
        businessCardRepository.insert(businessCard)
    }

    fun getAll(): LiveData<List<BusinessCard>> {
        return businessCardRepository.getAll()
    }
}

//SEXTO PASSO PARA A IMPLEMENTAÇÃO DO ROOM (INJEÇÃO DE DEPENDENCIA)
class MainViewModelFactory(private val repository: BusinessCardRepository) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return MainViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
