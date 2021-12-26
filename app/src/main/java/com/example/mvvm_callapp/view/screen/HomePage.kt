package com.example.mvvm_callapp.view.screen

import android.app.Application
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Warning
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.mvvm_callapp.model.Person
import com.example.mvvm_callapp.view.Fab
import com.example.mvvm_callapp.view.ListItemView
import com.example.mvvm_callapp.viewmodel.PersonViewModel

@Composable
fun HomePage(navController: NavController, application: Application) {
    val personViewModel = PersonViewModel(application)
    val list = personViewModel.personList.observeAsState(initial = emptyList())

    Scaffold(
        Modifier.fillMaxSize(),
        floatingActionButton = { Fab(navController = navController) }) {
            Column(
                Modifier
                    .fillMaxSize()
                    .padding(top = 16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                if (list.value.isEmpty()) EmptyListView() else ListView(list = list.value, personViewModel)
            }

        }
    }


@Composable
fun EmptyListView() {
    Column(verticalArrangement = Arrangement.SpaceEvenly, horizontalAlignment = Alignment.CenterHorizontally) {
        Icon(Icons.Default.Warning, contentDescription ="warn", tint = MaterialTheme.colors.secondary , modifier = Modifier.size(38.dp) )
        Text(text = "You don't have any contacts.", style = MaterialTheme.typography.h6)
        Text(text = "Try to add someone !", style = MaterialTheme.typography.h5, color = MaterialTheme.colors.primary)
    }
}

@Composable
fun ListView(list: List<Person>, personViewModel: PersonViewModel) {
    LazyColumn(Modifier.fillMaxSize()) {
        items(list.size) { index ->
            ListItemView(person = list.get(index = index), personViewModel = personViewModel )
        }
    }
}


