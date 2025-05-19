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
import com.example.moja_aplikacja.utils.Routes

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterPage(navController: NavController) {
    val name = remember { mutableStateOf("") }
    val email = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }
    val confirmPassword = remember { mutableStateOf("") }

    Box(modifier = Modifier.fillMaxSize()) {

        // Dekoracyjny obrazek w prawym górnym rogu
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
            // Back
            Text(
                text = "← Back",
                color = Color(0xFF471AA0),
                modifier = Modifier
                    .align(Alignment.Start)
                    .clickable { navController.navigate(Routes.loginPage) }
            )

            Spacer(modifier = Modifier.height(160.dp))

            // Tytuł
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

            // Full name
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

            // Email
            OutlinedTextField(
                value = email.value,
                onValueChange = { email.value = it },
                label = { Text("Email") },
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

            Spacer(modifier = Modifier.height(30.dp))

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

            Spacer(modifier = Modifier.height(30.dp))

            // Confirm Password
            OutlinedTextField(
                value = confirmPassword.value,
                onValueChange = { confirmPassword.value = it },
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

            Spacer(modifier = Modifier.height(90.dp))

            // Sign Up button
            Button(
                onClick = { /* obsługa rejestracji */ },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(55.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFCEB6F2)),
                shape = RoundedCornerShape(15.dp)
            ) {
                Text("Sign Up", color = Color.White, fontSize = 16.sp)
            }

            Spacer(modifier = Modifier.height(90.dp))

            // Already have an account
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
