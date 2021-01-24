package com.example.eindwerk.utils

data class Resource <out T>(val status: Status,val data:T?,val message: String?){
    companion object{
        fun <T> succes(data:T):Resource<T>{
            return  Resource(Status.SUCCES,data,null)
        }
        fun <T> error(message: String,data:T? = null):Resource<T>{
            return  Resource(Status.ERROR,data,message)
        }
        fun <T> loading(data:T? = null):Resource<T>{
            return  Resource(Status.LOADING,data,null)
        }
    }
}