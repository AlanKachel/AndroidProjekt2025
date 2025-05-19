import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
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
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.VisualTransformation
import com.example.moja_aplikacja.utils.AuthPreferences
import com.example.moja_aplikacja.utils.Routes
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterPage(navController: NavController) {
    AuthPreferences.setLoggedIn(LocalContext.current, true)
    val name = remember { mutableStateOf("") }
    val email = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }
    val confirmPassword = remember { mutableStateOf("") }
    val context = LocalContext.current

    var emailError by remember { mutableStateOf<String?>(null) }
    var passwordError by remember { mutableStateOf<String?>(null) }
    var confirmPasswordError by remember { mutableStateOf<String?>(null) }

    var passwordVisible by remember { mutableStateOf(false) }
    var confirmPasswordVisible by remember { mutableStateOf(false) }

    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.circle),
            contentDescription = null,
            modifier = Modifier
                .size(180.dp)
                .align(Alignment.TopEnd)
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "← Back",
                color = Color(0xFF471AA0),
                modifier = Modifier
                    .align(Alignment.Start)
                    .clickable { navController.navigate(Routes.loginPage) }

            )

            Spacer(modifier = Modifier.height(160.dp))

            Text(
                text = "Sign Up",
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF471AA0),
                modifier = Modifier
                    .align(Alignment.Start)
                    .fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(35.dp))

            OutlinedTextField(
                value = name.value,
                onValueChange = { name.value = it },
                label = { Text("Full Name") },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Person,
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

            Spacer(modifier = Modifier.height(30.dp))

            OutlinedTextField(
                value = email.value,
                onValueChange = {
                    email.value = it
                    emailError = null
                },
                label = { Text("Email") },
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
                Text(emailError!!, color = Color.Red, fontSize = 12.sp, modifier = Modifier.align(Alignment.Start))
            }

            Spacer(modifier = Modifier.height(30.dp))

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
                        contentDescription = "Toggle password",
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
                Text(passwordError!!, color = Color.Red, fontSize = 12.sp, modifier = Modifier.align(Alignment.Start))
            }

            Spacer(modifier = Modifier.height(30.dp))

            OutlinedTextField(
                value = confirmPassword.value,
                onValueChange = {
                    confirmPassword.value = it
                    confirmPasswordError = null
                },
                label = { Text("Confirm Password") },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Lock,
                        contentDescription = null,
                        tint = Color(0xFF471AA0)
                    )
                },
                trailingIcon = {
                    Icon(
                        imageVector = if (confirmPasswordVisible) Icons.Default.VisibilityOff else Icons.Default.Visibility,
                        contentDescription = "Toggle password",
                        tint = Color(0xFF471AA0),
                        modifier = Modifier.clickable { confirmPasswordVisible = !confirmPasswordVisible }
                    )
                },
                isError = confirmPasswordError != null,
                visualTransformation = if (confirmPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
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
            if (confirmPasswordError != null) {
                Text(confirmPasswordError!!, color = Color.Red, fontSize = 12.sp, modifier = Modifier.align(Alignment.Start))
            }

            Spacer(modifier = Modifier.height(90.dp))

            Button(
                onClick = {
                    var isValid = true

                    if (!email.value.contains("@") || !email.value.contains(".")) {
                        emailError = "Invalid email address"
                        isValid = false
                    }

                    if (password.value.length < 6) {
                        passwordError = "Password must be at least 6 characters"
                        isValid = false
                    }

                    if (confirmPassword.value != password.value) {
                        confirmPasswordError = "Passwords do not match"
                        isValid = false
                    }

                    if (isValid) {
                        Firebase.auth.createUserWithEmailAndPassword(email.value, password.value)
                            .addOnCompleteListener { task ->
                                if (task.isSuccessful) {
                                    // Sukces: użytkownik dodany
                                    navController.navigate(Routes.todoListPage)
                                    AuthPreferences.setLoggedIn(context, true)
                                } else {
                                    // Błąd (np. email już zajęty)
                                    emailError = task.exception?.message
                                }
                            }
                    }
                }
                ,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(55.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFCEB6F2)),
                shape = RoundedCornerShape(15.dp)
            ) {
                Text("Sign Up", color = Color.White, fontSize = 16.sp)
            }

            Spacer(modifier = Modifier.height(50.dp))

            Row {
                Text(text = "Already have an account ?", color = Color.Gray)
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = "Sign In",
                    color = Color(0xFF471AA0),
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.clickable {
                        navController.navigate(Routes.loginPage)
                    }
                )
            }
        }
    }
}
