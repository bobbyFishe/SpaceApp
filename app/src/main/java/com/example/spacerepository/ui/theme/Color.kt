package com.example.spacerepository.ui.theme

import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color

val SpaceDeepNight = Color(0xFF0B0E14) // Почти черный для фона приложения
val SpaceCardBg = Color(0xFF1B1F2A)    // Темно-синий для самих карточек
val SpaceNeonBlue = Color(0xFF4CC9F0)  // Яркий голубой для названий
val SpaceGold = Color(0xFFF7B538)      // Золотой для дистанции/акцентов
val SpaceFactBg = Color(0xFF252A38)    // Светлее для блоков с фактами

// Светлая схема (если хочешь, чтобы и она была "космической", но светлее)
val lightScheme = lightColorScheme(
    primary = Color(0xFF214E9C),
    background = Color(0xFFF0F2F5),
    surface = Color(0xFFFFFFFF),
    surfaceVariant = Color(0xFFE1E2EC)
)

// Темная схема (ГЛАВНАЯ ДЛЯ КОСМОСА)
val darkScheme = darkColorScheme(
    primary = SpaceNeonBlue,
    secondary = Color(0xFFB0B3C1),
    tertiary = SpaceGold,
    background = SpaceDeepNight,    // Весь экран будет темным
    surface = SpaceCardBg,          // Карточки будут выделяться на фоне
    surfaceVariant = SpaceFactBg,   // Блоки внутри карточек
    onBackground = Color(0xFFE2E2E6),
    onSurface = Color(0xFFE2E2E6),
    onSurfaceVariant = Color(0xFFC5C6D0),
    outlineVariant = Color(0xFF44474F)
)

