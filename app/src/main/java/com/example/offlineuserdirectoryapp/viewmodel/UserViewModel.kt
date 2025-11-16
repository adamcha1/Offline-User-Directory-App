package com.example.offlineuserdirectoryapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.offlineuserdirectoryapp.data.repository.UserRepository
import com.example.offlineuserdirectoryapp.model.User
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class UserViewModel(private val repository: UserRepository) : ViewModel() {

    private val _searchQuery = MutableStateFlow("")

    val users: StateFlow<List<User>> = _searchQuery
        .debounce(300)
        .flatMapLatest { query ->
            if (query.isEmpty()) repository.users
            else repository.searchUsers(query)
        }
        .stateIn(viewModelScope, SharingStarted.Lazily, emptyList())

    fun setSearchQuery(query: String) {
        _searchQuery.value = query
    }

    init {
        viewModelScope.launch {
            repository.fetchUsersFromApi()
        }
    }
}
