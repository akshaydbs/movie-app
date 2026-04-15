package com.development.coredesign.theme

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.material3.Typography
import androidx.compose.ui.unit.sp
import com.development.coredesign.R

@Composable
private fun spDimen(id: Int) = dimensionResource(id).value.sp

@Composable
fun AppTypography(): Typography = Typography(
    titleLarge = TextStyle(
        fontFamily = AppFonts.primary,
        fontWeight = FontWeight.SemiBold,
        fontSize = spDimen(R.dimen.type_title_large),
        lineHeight = spDimen(R.dimen.line_title_large),
    ),
    bodyLarge = TextStyle(
        fontFamily = AppFonts.primary,
        fontWeight = FontWeight.Normal,
        fontSize = spDimen(R.dimen.type_body_large),
        lineHeight = spDimen(R.dimen.line_body_large),
    ),
    labelLarge = TextStyle(
        fontFamily = AppFonts.primary,
        fontWeight = FontWeight.Medium,
        fontSize = spDimen(R.dimen.type_label_large),
        lineHeight = spDimen(R.dimen.line_label_large),
    ),
    labelSmall = TextStyle(
        fontFamily = AppFonts.primary,
        fontWeight = FontWeight.Light,
        fontSize = spDimen(R.dimen.type_label_medium),
        lineHeight = spDimen(R.dimen.line_label_medium),
    )
)