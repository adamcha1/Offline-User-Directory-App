package com.example.offlineuserdirectoryapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.offlineuserdirectoryapp.data.local.UserDatabase
import com.example.offlineuserdirectoryapp.data.repository.UserRepository
import com.example.offlineuserdirectoryapp.ui.screens.UserListScreen
import com.example.offlineuserdirectoryapp.ui.theme.OfflineUserDirectoryAppTheme
import com.example.offlineuserdirectoryapp.viewmodel.UserViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val dao = UserDatabase.getDatabase(applicationContext).userDao()
        val repository = UserRepository(dao)
        val factory = object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                @Suppress("UNCHECKED_CAST")
                return UserViewModel(repository) as T
            }
        }

        setContent {
            OfflineUserDirectoryAppTheme {
                UserListScreen(viewModel(factory = factory))
            }
        }
    }
}
