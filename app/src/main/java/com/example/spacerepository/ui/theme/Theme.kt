package com.example.spacerepository.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

private val MySpaceLightScheme = lightColorScheme(
    primary = Color(0xFF214E9C),
    background = Color(0xFFF0F2F5),
    surface = Color(0xFFFFFFFF),
    surfaceVariant = Color(0xFFE1E2EC)
)

private val MySpaceDarkScheme = darkColorScheme(
    primary = SpaceNeonBlue,         // Голубой неон (для названий)
    secondary = Color(0xFFBCC6DC),   // Светло-серый (для иконок)
    tertiary = SpaceGold,            // Золотой (для дистанции)
    background = SpaceDeepNight,     // Глубокий черный (фон приложения)
    surface = SpaceCardBg,           // Темно-синий (фон карточки)
    surfaceVariant = SpaceFactBg,    // Чуть светлее (фон фактов и описания)

    onPrimary = Color(0xFF003354),
    onBackground = Color(0xFFE2E2E6), // Светлый текст на черном фоне
    onSurface = Color(0xFFE2E2E6),    // Светлый текст в карточке
    onSurfaceVariant = Color(0xFFC5C6D0),
    outlineVariant = Color(0xFF44474F).copy(alpha = 0.4f) // Цвет границ
)

@Composable
fun SpaceRepositoryTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> MySpaceDarkScheme
        else -> MySpaceLightScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = SpaceTypography,
        content = content
    )
}