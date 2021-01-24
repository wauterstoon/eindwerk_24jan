package com.example.eindwerk.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.eindwerk.repos.OphaalRepository

class OphaalDetailViewModelRepositoryFactory(private val repository: OphaalRepository): ViewModelProvider.Factory {

    override fun <T: ViewModel?> create(modelClass: Class<T>):T{
        if (modelClass.isAssignableFrom(OphaalDetailViewModelRepositoryFactory::class.java)){
            return OphaalDetailViewModelRepositoryFactory(repository) as T
        }
        throw  IllegalArgumentException("unkown viewmodel class")
    }
}