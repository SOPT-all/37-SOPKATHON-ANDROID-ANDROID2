package com.example.sopkathon37android2.ui.theme

import android.app.Activity
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat


val localColors = staticCompositionLocalOf { defaultColors }
val localTypography = staticCompositionLocalOf { defaultTypography }

object SopkathonTheme {
    val colors: Colors
        @Composable
        @ReadOnlyComposable
        get() = localColors.current

    val typography: Typography
        @Composable
        @ReadOnlyComposable
        get() = localTypography.current
}

@Composable
fun ProvideSopkathonColorsAndTypography(
    colors: Colors,
    typography: Typography,
    content: @Composable () -> Unit
) {
    CompositionLocalProvider(
        localColors provides colors,
        localTypography provides typography,
        content = content
    )
}

@Composable
fun SopkathonTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    ProvideSopkathonColorsAndTypography(
        colors = defaultColors,
        typography = defaultTypography
    ) {
        val view = LocalView.current
        if (!view.isInEditMode) {
            SideEffect {
                (view.context as Activity).window.run {
                    WindowCompat.getInsetsController(this, view).isAppearanceLightStatusBars =
                        !darkTheme
                }
            }
        }
        MaterialTheme(
            content = content
        )
    }
}
