package com.example.mvvm_callapp.view

import androidx.compose.material.FloatingActionButton
import androidx.compose.material.FloatingActionButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun Fab(navController: NavController) {
    FloatingActionButton(
        onClick = { navController.navigate("add_person_page") },
        elevation = FloatingActionButtonDefaults.elevation(),
        backgroundColor = MaterialTheme.colors.primary
    ) {
        Icon(Icons.Default.Add, contentDescription = "Add Person")
    }
}
