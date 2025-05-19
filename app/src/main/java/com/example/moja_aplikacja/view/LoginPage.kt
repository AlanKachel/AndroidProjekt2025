package com.example.moja_aplikacja.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.moja_aplikacja.R
import com.example.moja_aplikacja.utils.Routes

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

        // Logo
        Image(
            painter = painterResource(id = R.drawable.ikona),
            contentDescription = "Logo",
            modifier = Modifier.size(160.dp)
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Tytuł
        Text(
            text = "Sign in",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF471AA0),
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.Start)
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Email
        OutlinedTextField(
            value = email.value,
            onValueChange = { email.value = it },
            label = { Text("Email or User Name") },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Email,
                    contentDescription = null,
                    tint = Color(0xFF471AA0)
                )
            },
            shape = RoundedCornerShape(20.dp),
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

        // Password
        OutlinedTextField(
            value = password.value,
            onValueChange = { password.value = it },
            label = { Text("Password") },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Lock,
                    contentDescription = null,
                    tint = Color(0xFF471AA0)
                )
            },
            trailingIcon = {
                Icon(
                    imageVector = Icons.Default.Visibility,
                    contentDescription = "Show password",
                    tint = Color(0xFF471AA0)
                )
            },
            visualTransformation = PasswordVisualTransformation(),
            shape = RoundedCornerShape(20.dp),
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

        Spacer(modifier = Modifier.height(16.dp))

        // "Forget Password ?"
        Text(
            text = "Forget Password ?",
            fontSize = 14.sp,
            color = Color(0xFF471AA0),
            modifier = Modifier
                .align(Alignment.End)
                .padding(end = 8.dp)
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Sign in button
        Button(
            onClick = { navController.navigate(Routes.todoListPage) },
            modifier = Modifier
                .fillMaxWidth()
                .height(55.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFB39DDB)),
            shape = RoundedCornerShape(15.dp)
        ) {
            Text("Sign in", color = Color.White, fontSize = 16.sp)
        }

        Spacer(modifier = Modifier.height(200.dp))

        // Sign up link
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
