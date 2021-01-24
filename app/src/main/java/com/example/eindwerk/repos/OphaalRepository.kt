package com.example.eindwerk.repos

import com.example.eindwerk.data.local.OphaalsLocalDatasSource
import com.example.eindwerk.data.remote.OphaalsRemoteDataSource
import com.example.eindwerk.utils.performGetOperation

class OphaalRepository(private val ophaalsLocalDatasSource: OphaalsLocalDatasSource,private val remoteDataSource: OphaalsRemoteDataSource) {


fun getOphaals()= performGetOperation(
        databaseQuery = {ophaalsLocalDatasSource.getOphaals()},
        networkCall = {OphaalsRemoteDataSource.getOphaal()},
        saveCallResult = {ophaalsLocalDatasSource.saveOphaal(it.records)}
)

   // fun getOphaal(id:String) = OphaalsLocalDatasSource.getOphaal(id)


}