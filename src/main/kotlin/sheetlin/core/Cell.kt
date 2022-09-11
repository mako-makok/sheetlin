package sheetlin.core

import sheetlin.core.style.Style

data class Cell(
    val value: CellValue,
    val style: Style? = null,
)
