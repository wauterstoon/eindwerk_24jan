package com.example.eindwerk.repos

import android.content.Context
import com.example.eindwerk.data.local.AppDatabase
import com.example.eindwerk.data.local.OphaalsLocalDatasSource
import com.example.eindwerk.data.remote.GhentApi.apiService
import com.example.eindwerk.data.remote.GhentApiService
import com.example.eindwerk.data.remote.OphaalsRemoteDataSource

class ReposUtils {
    companion object{
        fun createOphaalRepo(context: Context): OphaalRepository{
            val database = AppDatabase.getDataBase(context)
            val localDataSource = OphaalsLocalDatasSource(database.ophaalDao(),database.ophaalFieldsDao())
            val remoteDataSource = OphaalsRemoteDataSource(GhentApiService.apiservice)

            return OphaalRepository(localDataSource,remoteDataSource)
        }
    }
}