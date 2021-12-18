package com.example.mvvm_callapp.service.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.mvvm_callapp.model.Person

@Database(entities = [Person::class], version = 2)
abstract class PersonDatabase: RoomDatabase() {

    abstract fun personDao() : PersonDao

    companion object{
        private var instance: PersonDatabase? = null

        fun getPersonDatabase(context: Context): PersonDatabase? {

            if (instance == null){
                instance = Room.databaseBuilder(
                    context,
                    PersonDatabase::class.java,
                    "person.db"
                ).fallbackToDestructiveMigration()
                    .build()
            }
            return instance
        }
    }
}