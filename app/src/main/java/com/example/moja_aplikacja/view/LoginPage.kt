package com.example.moja_aplikacja.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
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
import com.example.moja_aplikacja.utils.Routes
import androidx.compose.material3.TextField
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import com.example.moja_aplikacja.R
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.ui.text.style.TextAlign


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginPage(navController: NavController) {
    val email = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(16.dp))


        Image(
            painter = painterResource(id = R.drawable.ikona),
            contentDescription = "Logo",
            modifier = Modifier
                .size(160.dp)
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Sign in",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF471AA0),
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.Start) // 👈 wyrównanie do lewej
        )


        Spacer(modifier = Modifier.height(24.dp))


        OutlinedTextField(
            value = email.value,
            onValueChange = { email.value = it },
            label = { Text("Email or User Name") },
            shape = RoundedCornerShape(20.dp), // 👉 większe zaokrąglenie
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color(0xFF471AA0),
                unfocusedBorderColor = Color(0xFF471AA0),
                cursorColor = Color(0xFF471AA0),
                focusedContainerColor = Color(0xFFF4EDF9),
                unfocusedContainerColor = Color(0xFFF4EDF9)
            ),
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
        )


        Spacer(modifier = Modifier.height(40.dp))


        OutlinedTextField(
            value = password.value,
            onValueChange = { password.value = it },
            label = { Text("Password") },
            shape = RoundedCornerShape(20.dp), // 👉 większe zaokrąglenie
            visualTransformation = PasswordVisualTransformation(),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color(0xFF471AA0),
                unfocusedBorderColor = Color(0xFF471AA0),
                cursorColor = Color(0xFF471AA0),
                focusedContainerColor = Color(0xFFF4EDF9),
                unfocusedContainerColor = Color(0xFFF4EDF9)
            ),
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
        )



        Spacer(modifier = Modifier.height(16.dp)) // niżej "Forget Password"

        Text(
            text = "Forget Password ?",
            fontSize = 14.sp,
            color = Color(0xFF471AA0),
            modifier = Modifier
                .align(Alignment.End)
                .padding(end = 8.dp)
        )

        Spacer(modifier = Modifier.height(24.dp)) // odstęp od przycisku

        Button(
            onClick = { navController.navigate(Routes.todoListPage) },
            modifier = Modifier
                .fillMaxWidth()
                .height(55.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFB39DDB)), // jasno fioletowy
            shape = RoundedCornerShape(15.dp)
        ) {
            Text("Sign in", color = Color.White, fontSize = 16.sp)
        }

        Spacer(modifier = Modifier.height(200.dp)) // więcej luzu na dole

        Row {
            Text(text = "Don’t have account ?", color = Color.Gray)
            Spacer(modifier = Modifier.width(4.dp))
            Text(
                text = "Sign Up",
                color = Color(0xFF471AA0),
                fontWeight = FontWeight.Bold,
                modifier = Modifier.clickable {
                    navController.navigate(Routes.registerPage)
                }
            )
        }

    }
}
