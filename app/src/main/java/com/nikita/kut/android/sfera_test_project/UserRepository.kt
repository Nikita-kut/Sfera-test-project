package com.nikita.kut.android.sfera_test_project

import kotlin.random.Random

class UserRepository {

    val userList: ArrayList<User> = generateUsers()

    val filteredUserList = userList.filter { it.age <= 18 }

    private fun generateUsers(): ArrayList<User> {
        val users = arrayListOf<User>()
        users.addAll(List(10) { User("User ${(1..10).random()}", (15..25).random()) })
        return users
    }
}