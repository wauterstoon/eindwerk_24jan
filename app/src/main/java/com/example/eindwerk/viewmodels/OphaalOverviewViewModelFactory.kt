package com.example.eindwerk.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.eindwerk.data.remote.GhentApi.apiService
import com.example.eindwerk.data.remote.GhentApiService
import com.example.eindwerk.repos.OphaalRepository

class OphaalOverviewViewModelFactory(private val repository: OphaalRepository):ViewModelProvider.Factory {

    override fun <T: ViewModel?> create(modelClass: Class<T>):T{
        if (modelClass.isAssignableFrom(OphaalOverviewViewModel::class.java)){
            return OphaalOverviewViewModel(repository) as T
        }
        throw  IllegalArgumentException("unkown viewmodel class")
    }

}