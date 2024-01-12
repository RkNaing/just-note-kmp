package me.rkzmn.note.utils.kotlin

import kotlinx.datetime.Clock
import kotlinx.datetime.Instant
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toInstant
import kotlinx.datetime.toLocalDateTime

fun LocalDateTime.Companion.now(
    timeZone: TimeZone = TimeZone.currentSystemDefault()
): LocalDateTime = Clock.System.now().toLocalDateTime(timeZone)

fun LocalDateTime.Companion.from(
    epochMillis: Long,
    timeZone: TimeZone = TimeZone.currentSystemDefault()
): LocalDateTime = Instant.fromEpochMilliseconds(epochMillis).toLocalDateTime(timeZone)

fun LocalDateTime.toEpochMillis(timeZone: TimeZone = TimeZone.currentSystemDefault()): Long {
    return toInstant(timeZone).toEpochMilliseconds()
}

fun LocalDateTime.format(): String {
    val formattedDay = dayOfMonth.toString().padStart(2, '0')
    val monthNameShort = month.name.lowercase().take(3).replaceFirstChar { it.uppercase() }

    val hour12 = if (hour == 0 || hour == 12) 12 else hour % 12
    val formattedHour = hour12.toString().padStart(2, '0')
    val formattedMinute = minute.toString().padStart(2, '0')
    val formattedSecond = second.toString().padStart(2, '0')
    val amPm = if (hour < 12) "AM" else "PM"

    val date = "$formattedDay $monthNameShort $year"
    val time = "$formattedHour:$formattedMinute:$formattedSecond $amPm"
    return "$date $time"
}