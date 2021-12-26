package com.example.mvvm_callapp.view.screen

import android.app.Application
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import com.example.mvvm_callapp.viewmodel.PersonViewModel

@Composable
fun SearchPage(application: Application) {
    var searchText by remember { mutableStateOf("") }
    val viewModel = PersonViewModel(application)
    val list = viewModel.personList.observeAsState(emptyList())

    Column(Modifier.fillMaxSize()) {
        TextField(modifier = Modifier.fillMaxWidth(), value = searchText, onValueChange = {
            searchText = it
        }, trailingIcon = {
            Icon(Icons.Default.Search, contentDescription = "search Icon")
        }, label = {
            Text(text = "Search")
        }, singleLine = true)


        Column(Modifier.fillMaxSize()) {
            ListView(list = list.value.filter { p ->
                p.infoString().lowercase().contains(
                    searchText.subSequence(
                        0,
                        searchText.length
                    )
                )
            }, personViewModel = viewModel)
        }
    }
}