package com.example.offlineuserdirectoryapp.data.repository

import com.example.offlineuserdirectoryapp.data.local.UserDao
import com.example.offlineuserdirectoryapp.data.remote.RetrofitInstance
import kotlinx.coroutines.flow.Flow
import com.example.offlineuserdirectoryapp.model.User

class UserRepository(private val dao: UserDao) {

    val users: Flow<List<User>> = dao.getAllUsers()

    fun searchUsers(query: String): Flow<List<User>> = dao.searchUsers(query)

    suspend fun fetchUsersFromApi() {
        try {
            val response = RetrofitInstance.api.getUsers()
            if (response.isSuccessful) {
                response.body()?.let { dao.insertUsers(it) }
            }
        } catch (e: Exception) {
            e.printStackTrace() // Keep showing cached data on API failure
        }
    }
}
