package com.example.moja_aplikacja.view

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
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
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.moja_aplikacja.R
import com.example.moja_aplikacja.model.Todo
import com.example.moja_aplikacja.utils.AuthPreferences
import com.example.moja_aplikacja.utils.Routes
import com.example.moja_aplikacja.viewmodel.TodoViewModel
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun TodoListPage(navController: NavController, viewModel: TodoViewModel) {
    var newText by remember { mutableStateOf("") }
    val context = LocalContext.current
    val todoList by viewModel.todoList.observeAsState()
    var inputText by remember { mutableStateOf("") }
    var editingTodo by remember { mutableStateOf<Todo?>(null) }
    val coroutineScope = rememberCoroutineScope()

    Column(modifier = Modifier.fillMaxSize().padding(8.dp)) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp, vertical = 4.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(onClick = {
                FirebaseAuth.getInstance().signOut()
                AuthPreferences.setLoggedIn(context, false)
                navController.navigate(Routes.loginPage) {
                    popUpTo(0)
                }
            }) {
                Text("Wyloguj")
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            OutlinedTextField(
                modifier = Modifier.weight(1f),
                value = inputText,
                onValueChange = { inputText = it },
                label = { Text("Wpisz zadanie") }
            )
            Spacer(modifier = Modifier.width(8.dp))
            Button(onClick = {
                viewModel.addTodo(inputText)
                inputText = ""
            }) {
                Text("Add")
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        todoList?.let {
            LazyColumn(contentPadding = PaddingValues(bottom = 100.dp)) {
                items(it.size) { index ->
                    val item = it[index]
                    TodoItem(
                        item = item,
                        onDelete = {
                            viewModel.deleteTodo(item.id)
                        },
                        onEditConfirm = { newText ->
                            viewModel.updateTodo(item.id, newText)
                        }
                    )
                }
            }
        } ?: Text(
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            text = "No items yet",
            fontSize = 16.sp
        )
    }

    editingTodo?.let { todo ->
        AlertDialog(
            onDismissRequest = { editingTodo = null },
            title = { Text("Edit Todo") },
            text = {
                var newText by remember { mutableStateOf(TextFieldValue(todo.title)) }
                OutlinedTextField(
                    value = newText,
                    onValueChange = { newText = it },
                    label = { Text("New text") },
                    modifier = Modifier.fillMaxWidth()
                )
            },
            confirmButton = {
                TextButton(onClick = { viewModel.updateTodo(editingTodo!!.id, newText) } // ✅ poprawnie
                ) {
                    Text("Save")
                }
            },
            dismissButton = {
                TextButton(onClick = { editingTodo = null }) {
                    Text("Cancel")
                }
            }
        )
    }
}

@Composable
fun TodoItem(
    item: Todo,
    onDelete: () -> Unit,
    onEditConfirm: (String) -> Unit
) {
    var showDialog by remember { mutableStateOf(false) }
    var editedText by remember { mutableStateOf(item.title) }

    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .clip(RoundedCornerShape(16.dp))
                .background(MaterialTheme.colorScheme.primary)
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = SimpleDateFormat("HH:mm:ss, dd/MM", Locale.ENGLISH).format(item.createdAt),
                    fontSize = 12.sp,
                    color = Color.LightGray
                )
                Text(
                    text = item.title,
                    fontSize = 20.sp,
                    color = Color.White
                )
            }

            IconButton(onClick = { showDialog = true }) {
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

        if (showDialog) {
            AlertDialog(
                onDismissRequest = { showDialog = false },
                title = { Text("Edit Task") },
                text = {
                    OutlinedTextField(
                        value = editedText,
                        onValueChange = { editedText = it },
                        label = { Text("New text") },
                        singleLine = true
                    )
                },
                confirmButton = {
                    TextButton(onClick = {
                        onEditConfirm(editedText)
                        showDialog = false
                    }) {
                        Text("Save")
                    }
                },
                dismissButton = {
                    TextButton(onClick = { showDialog = false }) {
                        Text("Cancel")
                    }
                }
            )
        }
    }
}