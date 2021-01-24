package com.example.eindwerk.data.local

import androidx.room.Insert
import androidx.room.OnConflictStrategy

interface OphaalFieldsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(list: List<OphaalFields>)
}