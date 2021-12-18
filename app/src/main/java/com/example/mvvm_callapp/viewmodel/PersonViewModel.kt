package com.example.mvvm_callapp.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.mvvm_callapp.repository.PersonRepository
import com.example.mvvm_callapp.model.Person
import com.example.mvvm_callapp.service.local.PersonDatabase
import com.example.mvvm_callapp.util.Constants
import kotlinx.coroutines.launch

class PersonViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: PersonRepository
    var personList : LiveData<List<Person>>

    init {
        val personDb = PersonDatabase.getPersonDatabase(application)?.personDao()
        repository = personDb?.let { PersonRepository(personDao = it) }!!
        personList = repository.getAllPerson()
    }

    fun addPerson(person: Person){
        viewModelScope.launch {
            repository.insertPerson(person)
        }
        Log.d(Constants.LOG_TAG_DB, "${person.firstName} added to contacts.")
    }

    fun deletePerson(person: Person){
        viewModelScope.launch {
            repository.deletePerson(person)
        }
    }

    fun findByName(first: String, last: String){
        viewModelScope.launch {
            repository.findByName(first, last)
        }
    }
}