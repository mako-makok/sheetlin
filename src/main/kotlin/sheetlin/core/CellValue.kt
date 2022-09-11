package sheetlin.core

import java.time.LocalDateTime

sealed interface CellValue

data class StringCellValue(
    val value: String
) : CellValue

data class NumericCellValue(
    val value: Double
) : CellValue

data class DateTimeCellValue(
    val value: LocalDateTime
) : CellValue

data class FormulaCellValue(
    val value: String
) : CellValue
