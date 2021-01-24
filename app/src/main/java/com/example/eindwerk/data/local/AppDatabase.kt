package com.example.eindwerk.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.eindwerk.models.Ophaal

@Database(entities = [Ophaal::class,OphaalFields::class],version = 1,exportSchema = false)
abstract class  AppDatabase:RoomDatabase() {

    abstract fun ophaalDao():OphaalDao
    abstract fun ophaalFieldsDao():OphaalFieldsDao

    companion object{
        @Volatile private var  instance : AppDatabase? = null

                fun getDataBase(context: Context): AppDatabase = instance ?: synchronized(this){ instance ?: buildDatabase(context).also{ instance = it}}
        private fun buildDatabase(appContext : Context) = Room.databaseBuilder(appContext, AppDatabase::class.java,"OphaalDB")
                .fallbackToDestructiveMigration()
                .build()
    }
}