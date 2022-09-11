package sheetlin.core

import java.time.LocalDate
import java.time.LocalDateTime

sealed interface CellValue

data class StringCellValue(
    val value: String
) : CellValue

data class NumericCellValue(
    val value: Double
) : CellValue

data class BooleanCellValue(
    val value: Boolean
) : CellValue

data class DateTimeCellValue(
    val value: LocalDateTime
) : CellValue

data class DateCellValue(
    val value: LocalDate
) : CellValue

data class FormulaCellValue(
    val value: String
) : CellValue
