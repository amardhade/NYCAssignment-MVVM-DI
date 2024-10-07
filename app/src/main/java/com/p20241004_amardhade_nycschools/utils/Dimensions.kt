package com.p20241004_amardhade_nycschools.utils

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class Dimensions(
    val spacingSmall: Dp = 4.dp,
    val spacingMedium: Dp = 8.dp,
    val spacingLarge: Dp = 12.dp,
)

val CompactDimensions = Dimensions()

val MediumDimensions = Dimensions(
    spacingSmall = 8.dp,
    spacingMedium = 16.dp,
    spacingLarge = 32.dp,
)

val ExpandedDimensions = Dimensions(
    spacingSmall = 16.dp,
    spacingMedium = 32.dp,
    spacingLarge = 64.dp,
)


val LocalDimensions = staticCompositionLocalOf { CompactDimensions }
