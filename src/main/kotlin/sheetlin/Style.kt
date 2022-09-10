package sheetlin

import java.awt.Color

data class Style(
//    val format: Short? = null,
    val font: Font? = null,
    val locked: Boolean = false,
    val hidden: Boolean = false,
//    val horizontalAlign
    // val verticalAlign
    val wrapText: Boolean = false,
    val backgroundColor: Color? = null,
)

data class Font(
    val fontName: String? = null,
    val fontHeight: Short? = null,
    val italic: Boolean = false,
    val bold: Boolean = false,
    val strikeThrough: Boolean = false,
    val underline: Boolean = false,
    val fontColor: Color? = null,
)
