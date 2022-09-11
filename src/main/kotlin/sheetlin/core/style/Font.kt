package sheetlin.core.style

import java.awt.Color

data class Font(
    val fontName: String? = null,
    val fontHeight: Short? = null,
    val italic: Boolean = false,
    val bold: Boolean = false,
    val strikeThrough: Boolean = false,
    val underline: Boolean = false,
    val fontColor: Color? = null,
)
