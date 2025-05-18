package com.example.moja_aplikacja

import RegisterPage
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.moja_aplikacja.utils.Routes
import com.example.moja_aplikacja.view.LoginPage
import com.example.moja_aplikacja.viewmodel.TodoViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {  // uruchomienie ekranu
        super.onCreate(savedInstanceState)
        val todoViewModel = ViewModelProvider(owner = this)[TodoViewModel::class.java]
        enableEdgeToEdge()
        setContent { //ustawienie widoku
            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = Routes.loginPage, builder = {
                composable(Routes.loginPage) {
                    LoginPage(navController)
                }
                composable(Routes.registerPage) {
                    RegisterPage(navController)
                }
            })
        }
    }
}

