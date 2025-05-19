package com.example.moja_aplikacja.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
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

    var emailError by remember { mutableStateOf<String?>(null) }
    var passwordError by remember { mutableStateOf<String?>(null) }

    var passwordVisible by remember { mutableStateOf(false) }

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
            modifier = Modifier.size(160.dp)
        )

        Spacer(modifier = Modifier.height(8.dp))

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

        OutlinedTextField(
            value = email.value,
            onValueChange = {
                email.value = it
                emailError = null
            },
            label = { Text("Email or User Name") },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Email,
                    contentDescription = null,
                    tint = Color(0xFF471AA0)
                )
            },
            isError = emailError != null,
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
        if (emailError != null) {
            Text(
                text = emailError ?: "",
                color = Color.Red,
                fontSize = 12.sp,
                modifier = Modifier.align(Alignment.Start)
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        OutlinedTextField(
            value = password.value,
            onValueChange = {
                password.value = it
                passwordError = null
            },
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
                    imageVector = if (passwordVisible) Icons.Default.VisibilityOff else Icons.Default.Visibility,
                    contentDescription = if (passwordVisible) "Hide password" else "Show password",
                    tint = Color(0xFF471AA0),
                    modifier = Modifier.clickable { passwordVisible = !passwordVisible }
                )
            },
            isError = passwordError != null,
            visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
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
        if (passwordError != null) {
            Text(
                text = passwordError ?: "",
                color = Color.Red,
                fontSize = 12.sp,
                modifier = Modifier.align(Alignment.Start)
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Forget Password ?",
            fontSize = 14.sp,
            color = Color(0xFF471AA0),
            modifier = Modifier
                .align(Alignment.End)
                .padding(end = 8.dp)
        )

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = {
                // Walidacja
                var isValid = true

                if (!email.value.contains("@") || !email.value.contains(".")) {
                    emailError = "Invalid email address"
                    isValid = false
                }

                if (password.value.length < 6) {
                    passwordError = "Password must be at least 6 characters"
                    isValid = false
                }

                if (isValid) {
                    navController.navigate(Routes.todoListPage)
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(55.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFB39DDB)),
            shape = RoundedCornerShape(15.dp)
        ) {
            Text("Sign in", color = Color.White, fontSize = 16.sp)
        }

        Spacer(modifier = Modifier.height(200.dp))

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
