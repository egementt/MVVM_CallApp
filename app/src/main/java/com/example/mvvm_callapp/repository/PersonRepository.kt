package com.example.mvvm_callapp.repository

import androidx.lifecycle.LiveData
import com.example.mvvm_callapp.model.Person
import com.example.mvvm_callapp.service.local.PersonDao

class PersonRepository(private val personDao: PersonDao) {

    fun getAllPerson(): LiveData<List<Person>> = personDao.getAll()

    suspend fun insertPerson(person: Person) = personDao.insertPerson(person)

    suspend fun deletePerson(person: Person) = personDao.delete(person)

}