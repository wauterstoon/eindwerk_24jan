package com.example.eindwerk.data.local

import androidx.room.Embedded
import androidx.room.Relation

class OphaalAndFields (

    @Embedded
    val ophaal : OphaalEntity,
    @Relation(parentColumn = "recordid", entityColumn = "ophaalId")
    val fields: OphaalFields

)