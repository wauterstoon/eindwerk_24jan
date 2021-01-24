package com.example.eindwerk.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.eindwerk.data.local.OphaalAndFields
import com.example.eindwerk.models.Ophaal
import com.example.eindwerk.repos.OphaalRepository

class OphaalDetailViewModel(private val repo:OphaalRepository) : ViewModel(){
    private lateinit var  _ophaal : LiveData<OphaalAndFields>
    val ophaal: LiveData<OphaalAndFields>
        get() = _ophaal

    fun updateOphaal(Id: String){
        _ophaal= repo.getOphaals(Id)

    }



}