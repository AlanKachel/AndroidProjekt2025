import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.moja_aplikacja.utils.Routes




@Composable
fun RegisterPage(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Sign up")



        Button(
            onClick = { navController.navigate(route = Routes.loginPage) },
            modifier = Modifier
                .padding(16.dp)
                .width(390.dp)
                .height(50.dp),
            shape = RoundedCornerShape(15.dp)
        ) {
            Text(text = "Sing up")
        }
    }
}



//@Composable
//fun RegisterPage(navController: NavController) {
//    Column(
//        modifier = Modifier.fillMaxSize(),
//        horizontalAlignment = Alignment.CenterHorizontally,
//        verticalArrangement = Arrangement.Center
//    ) {
//        Text(text = "Sign up")
//        Button(onClick = {navController.navigate(route = Routes.loginPage)},
//            modifier = Modifier
//                .padding(16.dp)
//                .width(390.dp)
//                .height(50.dp),
//            shape = RoundedCornerShape(15.dp),
//            //colors = ButtonColors()
//        ) {
//
//        }
//    }
//}

//Button(onClick = {navController.navigate(Routes.registerPage) }) {