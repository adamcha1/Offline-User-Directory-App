package com.example.offlineuserdirectoryapp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.offlineuserdirectoryapp.model.User
import com.example.offlineuserdirectoryapp.ui.components.SearchBar
import com.example.offlineuserdirectoryapp.viewmodel.UserViewModel

@Composable
fun UserListScreen(viewModel: UserViewModel) {
    val users by viewModel.users.collectAsState()
    var searchQuery by remember { mutableStateOf("") }

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        SearchBar(query = searchQuery, onQueryChange = {
            searchQuery = it
            viewModel.setSearchQuery(it)
        })

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(users) { user ->
                UserItem(user)
            }
        }
    }
}

@Composable
fun UserItem(user: User) {
    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(vertical = 8.dp)) {
        Text(text = "${user.name} (${user.id})")
        Text(text = user.email)
        Text(text = user.phone)
        Divider(modifier = Modifier.padding(top = 8.dp))
    }
}
