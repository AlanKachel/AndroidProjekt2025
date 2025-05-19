package com.example.moja_aplikacja.view

import android.content.Intent
import android.net.Uri
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.moja_aplikacja.R
import com.example.moja_aplikacja.model.Todo
import com.example.moja_aplikacja.utils.AuthPreferences
import com.example.moja_aplikacja.utils.Routes
import com.example.moja_aplikacja.viewmodel.TodoViewModel
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import java.text.SimpleDateFormat
import java.util.*

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun TodoListPage(navController: NavController, viewModel: TodoViewModel) {
    val context = LocalContext.current
    val todoList by viewModel.todoList.observeAsState()
    var inputText by remember { mutableStateOf("") }
    var itemBeingEdited by remember { mutableStateOf<Todo?>(null) }
    var editText by remember { mutableStateOf("") }

    Column(modifier = Modifier.fillMaxSize().padding(8.dp)) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(onClick = {
                Firebase.auth.signOut()
                AuthPreferences.setLoggedIn(context, false)
                navController.navigate(Routes.loginPage) {
                    popUpTo(0)
                }
            }) {
                Text("Wyloguj")
            }

            OutlinedTextField(
                modifier = Modifier.weight(1f),
                value = inputText,
                onValueChange = { inputText = it },
                placeholder = { Text("Wpisz zadanie") }
            )

            Spacer(modifier = Modifier.width(8.dp))

            Button(
                onClick = {
                    if (inputText.isNotBlank()) {
                        viewModel.addTodo(inputText)
                        inputText = ""
                    }
                },
                shape = RoundedCornerShape(50)
            ) {
                Text("Add")
            }
        }

        LazyColumn {
            todoList?.let {
                items(it.size) { index ->
                    val item = it[index]
                    TodoItem(
                        item = item,
                        onDelete = { viewModel.deleteTodo(item.id) },
                        onEdit = {
                            itemBeingEdited = item
                            editText = item.title
                        }
                    )
                }
            }
        }
    }

    itemBeingEdited?.let { todo ->
        AlertDialog(
            onDismissRequest = {
                itemBeingEdited = null
            },
            confirmButton = {
                TextButton(onClick = {
                    viewModel.updateTodo(todo.id, editText)
                    itemBeingEdited = null
                }) {
                    Text("Save", color = Color(0xFF471AA0))
                }
            },
            dismissButton = {
                TextButton(onClick = {
                    itemBeingEdited = null
                }) {
                    Text("Cancel", color = Color(0xFF471AA0))
                }
            },
            title = {
                Text("Edit Task")
            },
            text = {
                OutlinedTextField(
                    value = editText,
                    onValueChange = { editText = it },
                    label = { Text("New text") }
                )
            },
            containerColor = Color(0xFFF4EDF9),
            shape = RoundedCornerShape(20.dp)
        )
    }
}

@Composable
fun TodoItem(
    item: Todo,
    onDelete: () -> Unit,
    onEdit: () -> Unit
) {
    val context = LocalContext.current

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(MaterialTheme.colorScheme.primary)
            .padding(16.dp)
            .clickable {
                val encodedAddress = Uri.encode(item.title)
                val uri = Uri.parse("https://www.google.com/maps/search/?api=1&query=$encodedAddress")
                val intent = Intent(Intent.ACTION_VIEW, uri)
                context.startActivity(intent)
            },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = SimpleDateFormat("HH:mm, dd/MM", Locale.ENGLISH).format(item.createdAt),
                fontSize = 12.sp,
                color = Color.LightGray
            )
            Text(
                text = item.title,
                fontSize = 20.sp,
                color = Color.White
            )
        }
        IconButton(onClick = onEdit) {
            Icon(
                painter = painterResource(id = R.drawable.baseline_edit_24),
                contentDescription = "Edit",
                tint = Color.White
            )
        }
        IconButton(onClick = onDelete) {
            Icon(
                painter = painterResource(id = R.drawable.baseline_delete_24),
                contentDescription = "Delete",
                tint = Color.White
            )
        }
    }
}
