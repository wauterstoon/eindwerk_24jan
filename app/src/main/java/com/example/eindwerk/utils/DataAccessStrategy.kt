package com.example.eindwerk.utils

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import androidx.lifecycle.map
import kotlinx.coroutines.Dispatchers
import okhttp3.Dispatcher

fun <T,A>performGetOperation(
        databaseQuery:() -> LiveData<T>,
        networkCall:suspend() -> Resource<A>,
        saveCallResult: suspend (A) -> Unit
) : LiveData<Resource<T>> = liveData(Dispatchers.IO) {
    emit(Resource.loading())
    val source = databaseQuery.invoke().map { Resource.succes(it) }
    emitSource(source)

    val responseStatus = networkCall.invoke()
    if (responseStatus.status == Status.SUCCES){
        saveCallResult(responseStatus.data!!)
    }
    else  if (responseStatus.status == Status.ERROR)
    {
        emit(Resource.error(responseStatus.message!!))
        emitSource(source)
    }


}