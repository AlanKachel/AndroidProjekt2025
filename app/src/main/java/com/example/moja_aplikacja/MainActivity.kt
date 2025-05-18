package com.example.aplikacja

import RegisterPage
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.aplikacja.ui.theme.AplikacjaTheme
import com.example.aplikacja.utils.Routes
import com.example.aplikacja.view.LoginPage
import com.example.aplikacja.viewmodel.TodoViewModel

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

