package com.example.eindwerk.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "ophaals")
class OphaalEntity (
    @PrimaryKey val recordid : String
)