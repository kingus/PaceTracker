package com.peargrammers.pacetracker.android.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider

private val DarkColorPalette = darkColors(
    primary = DarkPrimaryColor,
    primaryVariant = DarkTextPrimary,
    secondary = DarkTextSecondary,
    background = DarkBackgroundPrimary,
    surface = PrimaryColorTransparent
    )

private val LightColorPalette = lightColors(
    primary = PrimaryColor,
    primaryVariant = TextPrimary,
    secondary = TextSecondary,
    background = BackgroundPrimary,
    surface = PrimaryColorTransparent

    /* Other default colors to override
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
)

@Composable
fun PaceTrackerTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    CompositionLocalProvider(LocalSpacing provides Spacing()) {

    }

    MaterialTheme(
        colors = colors, typography = Typography, shapes = Shapes, content = content
    )
}