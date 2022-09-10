package sheetlin

import java.awt.Color

data class Style(
//    val format: Short? = null,
    val font: Font? = null,
    val locked: Boolean = false,
    val hidden: Boolean = false,
    val horizontalAlignment: HorizontalAlignment? = null,
    val verticalAlignment: VerticalAlignment? = null,
    val wrapText: Boolean = false,
    val backgroundColor: Color? = null,
)

enum class HorizontalAlignment {
    LEFT,
    CENTER,
    RIGHT,
}

enum class VerticalAlignment {
    TOP,
    CENTER,
    BOTTOM,
}

data class Font(
    val fontName: String? = null,
    val fontHeight: Short? = null,
    val italic: Boolean = false,
    val bold: Boolean = false,
    val strikeThrough: Boolean = false,
    val underline: Boolean = false,
    val fontColor: Color? = null,
)
