package com.nikita.kut.android.sfera_test_project

import androidx.lifecycle.ViewModel

class UserListViewModel : ViewModel() {

    private val repository = UserRepository()

    val userList = repository.userList

    val filterUserList = repository.filteredUserList

    var textViewText: String? = null

}