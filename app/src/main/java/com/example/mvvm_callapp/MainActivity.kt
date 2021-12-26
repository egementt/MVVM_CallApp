package com.example.mvvm_callapp


import android.app.Application
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.mvvm_callapp.ui.theme.MVVM_CallAppTheme
import com.example.mvvm_callapp.view.screen.AddPersonPage
import com.example.mvvm_callapp.view.screen.HomePage
import com.example.mvvm_callapp.view.screen.SearchPage

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MVVM_CallAppTheme {
                val navController = rememberNavController()
                val backStackState = navController.currentBackStackEntryAsState()
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = {
                        TopAppBar(
                            title = { Text("Call App") },
                            actions = {
                                if (backStackState.value?.destination?.route != "search_page"){
                                    IconButton(onClick = { navController.navigate("search_page")
                                    }) {
                                        Icon(
                                            Icons.Filled.Search,
                                            contentDescription = "Localized description"
                                        )
                                    }

                                }
                            }
                        )
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
        composable(
            "search_page",
        ) {
            SearchPage(application)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MVVM_CallAppTheme {

    }
}