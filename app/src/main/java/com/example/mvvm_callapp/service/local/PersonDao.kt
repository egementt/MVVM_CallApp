package com.example.mvvm_callapp.service.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.mvvm_callapp.model.Person

@Dao
interface PersonDao {

    @Query("SELECT * FROM person")
     fun getAll(): LiveData<List<Person>>

    @Query("SELECT * FROM person WHERE firstName LIKE :first AND " + "lastName LIKE :last LIMIT 3")
    suspend fun findByName(first: String, last: String): Person

    @Insert
    suspend fun insertPerson(person: Person)

    @Delete
    suspend fun delete(person: Person)
}