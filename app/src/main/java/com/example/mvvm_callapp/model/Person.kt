package com.example.mvvm_callapp.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Person(
    val firstName: String,
    val lastName: String,
    val phoneNumber: String,
    @PrimaryKey(autoGenerate = true)
    val personId: Int? = null
){
    fun infoString(): String{
        return firstName+lastName+phoneNumber
    }

    override fun toString(): String {
        return "[${personId}]  $firstName  $lastName -> $phoneNumber"
    }


}
