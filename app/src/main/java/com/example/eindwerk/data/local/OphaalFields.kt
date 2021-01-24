package com.example.eindwerk.data.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey


@Entity(tableName = "ophaalFields",foreignKeys = arrayOf(ForeignKey(
        entity = OphaalEntity::class,
        parentColumns = arrayOf("recordid"),
        childColumns = arrayOf("ophaalId"),
        onDelete = ForeignKey.CASCADE
)))
class OphaalFields (
    val fractie:String,
    val kalender:String,
    val dag:String,
    val datum:String,
    val maand:Int,
@ColumnInfo(name = "ophaalId",index = true)
    val ophaalId: String?
)
{
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}