package me.rkzmn.note.presentation.ui

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import me.rkzmn.note.presentation.ui.colors.md_theme_dark_background
import me.rkzmn.note.presentation.ui.colors.md_theme_dark_error
import me.rkzmn.note.presentation.ui.colors.md_theme_dark_errorContainer
import me.rkzmn.note.presentation.ui.colors.md_theme_dark_inverseOnSurface
import me.rkzmn.note.presentation.ui.colors.md_theme_dark_inversePrimary
import me.rkzmn.note.presentation.ui.colors.md_theme_dark_inverseSurface
import me.rkzmn.note.presentation.ui.colors.md_theme_dark_onBackground
import me.rkzmn.note.presentation.ui.colors.md_theme_dark_onError
import me.rkzmn.note.presentation.ui.colors.md_theme_dark_onErrorContainer
import me.rkzmn.note.presentation.ui.colors.md_theme_dark_onPrimary
import me.rkzmn.note.presentation.ui.colors.md_theme_dark_onPrimaryContainer
import me.rkzmn.note.presentation.ui.colors.md_theme_dark_onSecondary
import me.rkzmn.note.presentation.ui.colors.md_theme_dark_onSecondaryContainer
import me.rkzmn.note.presentation.ui.colors.md_theme_dark_onSurface
import me.rkzmn.note.presentation.ui.colors.md_theme_dark_onSurfaceVariant
import me.rkzmn.note.presentation.ui.colors.md_theme_dark_onTertiary
import me.rkzmn.note.presentation.ui.colors.md_theme_dark_onTertiaryContainer
import me.rkzmn.note.presentation.ui.colors.md_theme_dark_outline
import me.rkzmn.note.presentation.ui.colors.md_theme_dark_outlineVariant
import me.rkzmn.note.presentation.ui.colors.md_theme_dark_primary
import me.rkzmn.note.presentation.ui.colors.md_theme_dark_primaryContainer
import me.rkzmn.note.presentation.ui.colors.md_theme_dark_scrim
import me.rkzmn.note.presentation.ui.colors.md_theme_dark_secondary
import me.rkzmn.note.presentation.ui.colors.md_theme_dark_secondaryContainer
import me.rkzmn.note.presentation.ui.colors.md_theme_dark_surface
import me.rkzmn.note.presentation.ui.colors.md_theme_dark_surfaceTint
import me.rkzmn.note.presentation.ui.colors.md_theme_dark_surfaceVariant
import me.rkzmn.note.presentation.ui.colors.md_theme_dark_tertiary
import me.rkzmn.note.presentation.ui.colors.md_theme_dark_tertiaryContainer
import me.rkzmn.note.presentation.ui.colors.md_theme_light_background
import me.rkzmn.note.presentation.ui.colors.md_theme_light_error
import me.rkzmn.note.presentation.ui.colors.md_theme_light_errorContainer
import me.rkzmn.note.presentation.ui.colors.md_theme_light_inverseOnSurface
import me.rkzmn.note.presentation.ui.colors.md_theme_light_inversePrimary
import me.rkzmn.note.presentation.ui.colors.md_theme_light_inverseSurface
import me.rkzmn.note.presentation.ui.colors.md_theme_light_onBackground
import me.rkzmn.note.presentation.ui.colors.md_theme_light_onError
import me.rkzmn.note.presentation.ui.colors.md_theme_light_onErrorContainer
import me.rkzmn.note.presentation.ui.colors.md_theme_light_onPrimary
import me.rkzmn.note.presentation.ui.colors.md_theme_light_onPrimaryContainer
import me.rkzmn.note.presentation.ui.colors.md_theme_light_onSecondary
import me.rkzmn.note.presentation.ui.colors.md_theme_light_onSecondaryContainer
import me.rkzmn.note.presentation.ui.colors.md_theme_light_onSurface
import me.rkzmn.note.presentation.ui.colors.md_theme_light_onSurfaceVariant
import me.rkzmn.note.presentation.ui.colors.md_theme_light_onTertiary
import me.rkzmn.note.presentation.ui.colors.md_theme_light_onTertiaryContainer
import me.rkzmn.note.presentation.ui.colors.md_theme_light_outline
import me.rkzmn.note.presentation.ui.colors.md_theme_light_outlineVariant
import me.rkzmn.note.presentation.ui.colors.md_theme_light_primary
import me.rkzmn.note.presentation.ui.colors.md_theme_light_primaryContainer
import me.rkzmn.note.presentation.ui.colors.md_theme_light_scrim
import me.rkzmn.note.presentation.ui.colors.md_theme_light_secondary
import me.rkzmn.note.presentation.ui.colors.md_theme_light_secondaryContainer
import me.rkzmn.note.presentation.ui.colors.md_theme_light_surface
import me.rkzmn.note.presentation.ui.colors.md_theme_light_surfaceTint
import me.rkzmn.note.presentation.ui.colors.md_theme_light_surfaceVariant
import me.rkzmn.note.presentation.ui.colors.md_theme_light_tertiary
import me.rkzmn.note.presentation.ui.colors.md_theme_light_tertiaryContainer

@Composable
fun JustNoteTheme(
    useDarkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable() () -> Unit
) {
    val colors = if (!useDarkTheme) LightColors else DarkColors

    MaterialTheme(
        colorScheme = colors,
        content = content
    )
}

@Composable
fun ThemedContent(
    useDarkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    JustNoteTheme(
        useDarkTheme = useDarkTheme,
        content = { Surface(content = content) }
    )
}

private val LightColors = lightColorScheme(
    primary = md_theme_light_primary,
    onPrimary = md_theme_light_onPrimary,
    primaryContainer = md_theme_light_primaryContainer,
    onPrimaryContainer = md_theme_light_onPrimaryContainer,
    secondary = md_theme_light_secondary,
    onSecondary = md_theme_light_onSecondary,
    secondaryContainer = md_theme_light_secondaryContainer,
    onSecondaryContainer = md_theme_light_onSecondaryContainer,
    tertiary = md_theme_light_tertiary,
    onTertiary = md_theme_light_onTertiary,
    tertiaryContainer = md_theme_light_tertiaryContainer,
    onTertiaryContainer = md_theme_light_onTertiaryContainer,
    error = md_theme_light_error,
    errorContainer = md_theme_light_errorContainer,
    onError = md_theme_light_onError,
    onErrorContainer = md_theme_light_onErrorContainer,
    background = md_theme_light_background,
    onBackground = md_theme_light_onBackground,
    surface = md_theme_light_surface,
    onSurface = md_theme_light_onSurface,
    surfaceVariant = md_theme_light_surfaceVariant,
    onSurfaceVariant = md_theme_light_onSurfaceVariant,
    outline = md_theme_light_outline,
    inverseOnSurface = md_theme_light_inverseOnSurface,
    inverseSurface = md_theme_light_inverseSurface,
    inversePrimary = md_theme_light_inversePrimary,
    surfaceTint = md_theme_light_surfaceTint,
    outlineVariant = md_theme_light_outlineVariant,
    scrim = md_theme_light_scrim
)


private val DarkColors = darkColorScheme(
    primary = md_theme_dark_primary,
    onPrimary = md_theme_dark_onPrimary,
    primaryContainer = md_theme_dark_primaryContainer,
    onPrimaryContainer = md_theme_dark_onPrimaryContainer,
    secondary = md_theme_dark_secondary,
    onSecondary = md_theme_dark_onSecondary,
    secondaryContainer = md_theme_dark_secondaryContainer,
    onSecondaryContainer = md_theme_dark_onSecondaryContainer,
    tertiary = md_theme_dark_tertiary,
    onTertiary = md_theme_dark_onTertiary,
    tertiaryContainer = md_theme_dark_tertiaryContainer,
    onTertiaryContainer = md_theme_dark_onTertiaryContainer,
    error = md_theme_dark_error,
    errorContainer = md_theme_dark_errorContainer,
    onError = md_theme_dark_onError,
    onErrorContainer = md_theme_dark_onErrorContainer,
    background = md_theme_dark_background,
    onBackground = md_theme_dark_onBackground,
    surface = md_theme_dark_surface,
    onSurface = md_theme_dark_onSurface,
    surfaceVariant = md_theme_dark_surfaceVariant,
    onSurfaceVariant = md_theme_dark_onSurfaceVariant,
    outline = md_theme_dark_outline,
    inverseOnSurface = md_theme_dark_inverseOnSurface,
    inverseSurface = md_theme_dark_inverseSurface,
    inversePrimary = md_theme_dark_inversePrimary,
    surfaceTint = md_theme_dark_surfaceTint,
    outlineVariant = md_theme_dark_outlineVariant,
    scrim = md_theme_dark_scrim
)