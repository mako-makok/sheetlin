package sheetlin.core.style

import java.awt.Color

data class Style(
    val font: Font? = null,
    val format: String? = null,
    val locked: Boolean = false,
    val hidden: Boolean = false,
    val horizontalAlignment: HorizontalAlignment? = null,
    val verticalAlignment: VerticalAlignment? = null,
    val wrapText: Boolean = false,
    val backgroundColor: Color? = null,
    val borderTop: Border? = null,
    val borderLeft: Border? = null,
    val borderBottom: Border? = null,
    val borderRight: Border? = null,
)
