package com.example.eindwerk.models

import android.os.Parcelable
import com.example.eindwerk.data.local.OphaalEntity
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Ophaal (
    val recordid:String,
    val fields: OphaalFields
):Parcelable{
    fun toDatabaseModel():OphaalEntity
    {return  OphaalEntity(recordid)
    }
}