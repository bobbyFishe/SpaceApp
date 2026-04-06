package com.example.spacerepository.data

data class SpaceObject(
    val day: Int,                       // Номер дня (1-30)
    val nameRes: Int,                   // Название
    val categoryRes: Category,          // "Планета", "Туманность" и т.д.
    val descriptionRes: Int,            // Основной текст
    val funFactRes: Int,                // Короткий "бабл" с фактом
    val imageRes: Int,                  // Картинка
    val distanceRes: Int,               // Строка: "150 млн км"
    val isCircleShape: Boolean          // Логика обрезки (планета или облако газа)
)
