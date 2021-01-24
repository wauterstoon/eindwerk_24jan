package com.example.eindwerk.data.local

import com.example.eindwerk.models.Ophaal

class OphaalsLocalDatasSource(private val ophaalDao: OphaalDao,private var ophaalFieldsDao: OphaalFieldsDao) {

    fun getOphaals() = ophaalDao.getAllOphaals()
    fun getOphaal(id:String) = ophaalDao.getOphaals(id)
    fun saveOphaal(list : List<Ophaal>){
        val ophaalList = ArrayList<OphaalEntity>()
        list.forEach {  ophaal -> ophaalList.add(ophaal.toDatabaseModel())}
    ophaalDao.insertAll(ophaalList)
        val fieldsList = ArrayList<OphaalFields>()
        list.forEach{ophaal -> fieldsList.add(ophaal.fields.toDatabaseModel(ophaal.recordid))}

        ophaalFieldsDao.insertAll(fieldsList)
    }

}