package com.example.lab4

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class PersonViewModel : ViewModel() {
    private val _people = MutableStateFlow(listOf(
        Person(1, "Иван Иванов", 28, "Разработчик",
            "Опыт работы 5 лет", R.drawable.avatar1),
        Person(2, "Александр Лабода", 32, "Дизайнер",
            "Специалист по UI/UX", R.drawable.avatar2)
    ))

    val people: StateFlow<List<Person>> = _people.asStateFlow()

    fun addPerson() {
        val newId = (_people.value.maxOfOrNull { it.id } ?: 0) + 1
        _people.value = _people.value + Person(
            newId, "Новый человек $newId", 25,
            "Профессия", "Описание", R.drawable.avatar_default
        )
    }
}