package sheetlin.core

import sheetlin.core.style.Style

interface AbstractCell {
    val value: CellValue
    val style: Style?
}

data class Cell(
    override val value: CellValue,
    override val style: Style? = null,
) : AbstractCell
