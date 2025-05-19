import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.moja_aplikacja.utils.Routes



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterPage(navController: NavController) {
    val name = remember { mutableStateOf("") }
    val email = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }
    val confirmPassword = remember { mutableStateOf("") }

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

        Spacer(modifier = Modifier.height(30.dp))

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

        // Przycisk rejestracji
        Button(
            onClick = { /* obsługa rejestracji */ },
            modifier = Modifier
                .fillMaxWidth()
                .height(55.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFCEB6F2)), // jasno fioletowy
            shape = RoundedCornerShape(15.dp)
        ) {
            Text("Sign Up", color = Color.White, fontSize = 16.sp)
        }

        Spacer(modifier = Modifier.height(200.dp))

        // Odnośnik do logowania
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
