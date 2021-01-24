package com.example.eindwerk.data.local

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.eindwerk.models.Ophaal

@Dao
interface OphaalDao {
    @Transaction
    @Query("select * from ophaals")
    fun getAllOphaals():LiveData<List<OphaalAndFields>>

    @Transaction
    @Query("select * from ophaals where recordid =:id" )
    fun getOphaals(id:String):LiveData<OphaalAndFields>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(list: List<OphaalEntity>)



}