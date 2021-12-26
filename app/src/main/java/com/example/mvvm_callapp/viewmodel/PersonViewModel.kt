package com.example.mvvm_callapp.viewmodel

import android.app.Application
import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.mvvm_callapp.repository.PersonRepository
import com.example.mvvm_callapp.model.Person
import com.example.mvvm_callapp.service.local.PersonDatabase
import com.example.mvvm_callapp.util.Constants
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch

class PersonViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: PersonRepository
    var personList: LiveData<List<Person>>


    init {
        val personDb = PersonDatabase.getPersonDatabase(application)?.personDao()
        repository = personDb?.let { PersonRepository(personDao = it) }!!
        personList = repository.getAllPerson()
    }


    fun addPerson(person: Person) {
        viewModelScope.launch {
            repository.insertPerson(person)
        }
        Log.d(Constants.LOG_TAG_DB, "${person.firstName} added to contacts.")
    }


    fun deletePerson(person: Person) {
        viewModelScope.launch {
            repository.deletePerson(person)
        }
    }


}