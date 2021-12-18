package com.example.mvvm_callapp.view.screen

import android.app.Application
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.mvvm_callapp.model.Person
import com.example.mvvm_callapp.viewmodel.PersonViewModel


@Composable
fun AddPersonPage(navController: NavController, application: Application) {

   val viewModel = PersonViewModel(application)

    var name by remember { mutableStateOf("")}
    var surname by remember { mutableStateOf("")}
    var phoneNumber by remember { mutableStateOf("")}


    Column(Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center) {
        Column(
            Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.4f), verticalArrangement = Arrangement.SpaceBetween, horizontalAlignment = Alignment.CenterHorizontally) {

            TextField(value = name, onValueChange = {
                name = it
            }, label = {
                Text(text = "Name")
            } )

            TextField(value = surname, onValueChange = {
                surname = it
            }, label = {
                Text(text = "Surname")
            } )

            TextField(value = phoneNumber, onValueChange = {
                phoneNumber = it
            }, label = {
                Text(text = "Phone Number")
            } )

            Button(onClick = {
                viewModel.addPerson(Person(firstName = name, lastName = surname, phoneNumber = phoneNumber)).also {
                    navController.popBackStack()
                }
            }) {
                Text(text = "Add to Contacts")
            }

        }

    }

}