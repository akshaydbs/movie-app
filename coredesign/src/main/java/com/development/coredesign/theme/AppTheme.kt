package com.development.coredesign.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import com.development.coredesign.R

@Composable
public fun appSpacing(): AppSpacing = AppSpacing(
    none = dimensionResource(R.dimen.space_0),
    xs = dimensionResource(R.dimen.space_4),
    sm = dimensionResource(R.dimen.space_8),
    md = dimensionResource(R.dimen.space_12),
    lg = dimensionResource(R.dimen.space_16),
    xl = dimensionResource(R.dimen.space_24),
    xxl = dimensionResource(R.dimen.space_32),
)

@Composable
fun AppTheme(content: @Composable () -> Unit) {
    val spacing = appSpacing()

    CompositionLocalProvider(
        LocalAppSpacing provides spacing
    ) {
        // your existing MaterialTheme(...)
        // MaterialTheme(colorScheme = ..., typography = ..., content = content)

        // IMPORTANT: keep MaterialTheme inside provider (either order is fine)
        androidx.compose.material3.MaterialTheme(
            colorScheme = appColorScheme(),
            typography = AppTypography(),
            content = content
        )
    }
}

@Composable
private fun c(id: Int): Color = colorResource(id)

@Composable
private fun appColorScheme(): ColorScheme {
    // our colors are in both night and normal values we font need it but there are some defaults like default fallback values and tonal elevation behavior.
    // so we use standard and put this logic also.
    val isDark = isSystemInDarkTheme()

    return if (isDark) {
        darkColorScheme(
            primary = c(R.color.color_primary),
            onPrimary = c(R.color.color_on_primary),
            background = c(R.color.color_background),
            onBackground = c(R.color.color_on_background),
            surface = c(R.color.color_surface),
            onSurface = c(R.color.color_on_surface),
            error = c(R.color.color_error),
            onError = c(R.color.color_on_error),
        )
    } else {
        lightColorScheme(
            primary = c(R.color.color_primary),
            onPrimary = c(R.color.color_on_primary),
            background = c(R.color.color_background),
            onBackground = c(R.color.color_on_background),
            surface = c(R.color.color_surface),
            onSurface = c(R.color.color_on_surface),
            error = c(R.color.color_error),
            onError = c(R.color.color_on_error),
        )
    }
}