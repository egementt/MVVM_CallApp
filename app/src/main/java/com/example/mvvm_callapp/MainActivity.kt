package com.example.mvvm_callapp

import android.app.Application
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mvvm_callapp.view.screen.AddPersonPage
import com.example.mvvm_callapp.view.screen.HomePage
import com.example.mvvm_callapp.view.screen.TopBar

import com.example.mvvm_callapp.ui.theme.MVVM_CallAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MVVM_CallAppTheme {
                val navController = rememberNavController()
                 Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = {
                            TopBar(title = "Contact App")
                    }) {
                     Navigation(navController = navController, this.application)
                }

                
            }
        }
    }
}



@Composable
fun Navigation(navController: NavHostController, application: Application) {
    NavHost(navController, "home_page") {
        composable("home_page") {
            HomePage(navController = navController, application)
        }
        composable("add_person_page") {
            AddPersonPage(navController, application)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MVVM_CallAppTheme {

    }
}