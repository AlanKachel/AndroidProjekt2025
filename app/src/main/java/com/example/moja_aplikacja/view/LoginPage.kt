package com.example.aplikacja.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.aplikacja.utils.Routes
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.text.input.TextFieldValue
import com.example.moja_aplikacja.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginPage(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 32.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Image(
            painter = painterResource(R.drawable.ikona), contentDescription = "Logoapk",
            modifier = Modifier
                .size(200.dp)
                .padding(bottom = 16.dp)
        )
//        Text(
//            text = "elo",
//            fontSize = 100.sp,
//            fontWeight =FontWeight.Bold,
//            color = Color.Green
//        )
        val email = remember { mutableStateOf(TextFieldValue("")) }

        TextField(
            value = email.value,
            onValueChange = { email.value = it },
            label = { Text("Email") },
            colors = TextFieldDefaults.textFieldColors()
        )

        Text(
            text = "Sign up",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF471AA0),
            modifier = Modifier
                .align(Alignment.Start)
                .padding(start = 19.dp)
                .padding(top = 8.dp)
        )

        Button(
            onClick = { navController.navigate(Routes.registerPage) },
            modifier = Modifier
                .padding(100.dp)
                .width(390.dp)
                .height(50.dp),
            shape = RoundedCornerShape(15)
        ) {
            Text(text = "Sign in")

        }
    }
}