package sheetlin

import java.math.BigDecimal
import java.time.LocalDateTime

sealed interface CellValue

data class StringCellValue(
    val value: String
) : CellValue

data class NumericCellValue(
    val value: BigDecimal
): CellValue

data class DateTimeCellValue(
    val value: LocalDateTime
): CellValue

data class FormulaCellValue(
    val value: String
): CellValue
