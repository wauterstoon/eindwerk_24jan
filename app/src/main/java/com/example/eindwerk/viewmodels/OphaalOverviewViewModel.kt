package com.example.eindwerk.viewmodels


import androidx.lifecycle.ViewModel
import com.example.eindwerk.repos.OphaalRepository


class OphaalOverviewViewModel(private var repo: OphaalRepository):ViewModel() {
   val ophaals = repo.getOphaals()


}