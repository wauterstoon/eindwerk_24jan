package com.example.eindwerk.models

import android.os.Parcelable
import com.example.eindwerk.data.local.OphaalFields
import kotlinx.android.parcel.Parcelize
import java.time.DayOfWeek
import java.util.*

@Parcelize
data class OphaalFields (
    val fractie:String,
    val kalender:String,
    val dag:String,
    val datum:String,
    val maand:Int
):Parcelable {
    fun toDatabaseModel(ophaalId:String):OphaalFields{
        return OphaalFields(fractie,kalender,dag,datum,maand,ophaalId)
    }
}