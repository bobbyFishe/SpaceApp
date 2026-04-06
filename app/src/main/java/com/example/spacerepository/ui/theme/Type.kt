package com.example.spacerepository.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.spacerepository.R

val orbitron = FontFamily(
    Font(R.font.orbitron_bold, FontWeight.Bold)
)

val exo2 = FontFamily(
    Font(R.font.exo2_regular, FontWeight.Normal),
    Font(R.font.exo2_italic, FontWeight.Normal)
)

val shareTechMono = FontFamily(
    Font(R.font.share_tech_mono_regular, FontWeight.Light)
)

// Set of Material typography styles to start with
val SpaceTypography = Typography(
    // 1. НАЗВАНИЕ
    displayMedium = TextStyle(
        fontFamily = orbitron,
        fontWeight = FontWeight.Bold,
        fontSize = 24.sp,
        letterSpacing = 2.sp
    ),
    // 2. ОПИСАНИЕ
    bodyLarge = TextStyle(
        fontFamily = exo2,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp
    ),
    // 3. ФАКТ
    titleMedium = TextStyle(
        fontFamily = exo2,
        fontWeight = FontWeight.Medium,
        fontStyle = FontStyle.Italic,
        fontSize = 14.sp
    ),
    // 4. ДИСТАНЦИЯ
    labelSmall = TextStyle(
        fontFamily = shareTechMono,
        fontWeight = FontWeight.Light,
        fontSize = 12.sp,
    )
)