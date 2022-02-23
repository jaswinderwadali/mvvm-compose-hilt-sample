package r.bot.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val DarkColorPalette = darkColors(
    primary = r.bot.theme.Purple200,
    primaryVariant = r.bot.theme.Purple700,
    secondary = r.bot.theme.Teal200
)

private val LightColorPalette = lightColors(
    primary = r.bot.theme.Teal200,
    primaryVariant = r.bot.theme.Purple700,
    secondary = r.bot.theme.Purple500

    /* Other default colors to override
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
)

@Composable
fun RbotTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable() () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = r.bot.theme.Typography,
        shapes = r.bot.theme.Shapes,
        content = content
    )
}