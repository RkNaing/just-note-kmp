package me.rkzmn.note.domain.note

import kotlinx.datetime.LocalDateTime
import me.rkzmn.note.presentation.ui.colors.BabyBlueHex
import me.rkzmn.note.presentation.ui.colors.LightGreenHex
import me.rkzmn.note.presentation.ui.colors.RedOrangeHex
import me.rkzmn.note.presentation.ui.colors.RedPinkHex
import me.rkzmn.note.presentation.ui.colors.VioletHex

data class Note(
    val id: Long = 0L,
    val title: String,
    val content: String,
    val colorHex: Long,
    val created: LocalDateTime
) {
    companion object {
        private val colors = listOf(
            RedOrangeHex,
            RedPinkHex,
            BabyBlueHex,
            VioletHex,
            LightGreenHex
        )

        fun generateRandomColor() = colors.random()
    }
}