package com.p20241004_amardhade_nycschools

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import com.p20241004_amardhade_nycschools.utils.Dimensions
import com.p20241004_amardhade_nycschools.utils.LocalDimensions
import retrofit2.http.GET

@Composable
fun AppTheme(
    dimensions: Dimensions,
    content: @Composable () -> Unit
) {

    val appDimens = remember { dimensions }

    CompositionLocalProvider(LocalDimensions provides appDimens) {
        content()
    }

}

// Extension function to access dimensions
val AppDimens
    @Composable
    get() = LocalDimensions.current

