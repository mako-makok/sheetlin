package sheetlin.core.style

import java.awt.Color

data class Border(
    val borderStyle: BorderStyle = BorderStyle.THIN,
    val color: Color? = null,
)

enum class BorderStyle {
    THIN,
    MEDIUM,
    THICK,
    DASHED,
    DOTTED,
    DOUBLE,
}
