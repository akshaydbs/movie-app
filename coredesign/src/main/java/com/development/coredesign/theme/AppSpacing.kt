package com.development.coredesign.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Dp

@Immutable
data class AppSpacing(
    val none: Dp,
    val xs: Dp,
    val sm: Dp,
    val md: Dp,
    val lg: Dp,
    val xl: Dp,
    val xxl: Dp,
)

val LocalAppSpacing = staticCompositionLocalOf<AppSpacing> {
    error("AppSpacing not provided. Wrap your UI in AppTheme.")
}