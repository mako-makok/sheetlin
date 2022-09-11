package sheetlin.excel.xssf.style

import org.apache.poi.xssf.usermodel.XSSFColor
import org.apache.poi.xssf.usermodel.XSSFWorkbook
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import sheetlin.core.style.HorizontalAlignment
import sheetlin.core.style.Style
import sheetlin.core.style.VerticalAlignment
import java.awt.Color
import org.apache.poi.ss.usermodel.HorizontalAlignment as XSSFHorizontalAlignment
import org.apache.poi.ss.usermodel.VerticalAlignment as XSSFVerticalAlignment

internal class ExcelXSSFStyleParserTest {

    @Test
    fun parse() {
        val xssfWorkbook = XSSFWorkbook()
        val style = Style(
            locked = true,
            hidden = true,
            wrapText = true,
            horizontalAlignment = HorizontalAlignment.RIGHT,
            verticalAlignment = VerticalAlignment.BOTTOM,
            backgroundColor = Color.RED
        )

        val actual = ExcelXSSFStyleParser.parse(
            xssfWorkbook,
            style
        )

        assertEquals(true, actual.locked)
        assertEquals(true, actual.hidden)
        assertEquals(true, actual.wrapText)
        assertEquals(XSSFHorizontalAlignment.RIGHT, actual.alignment)
        assertEquals(XSSFVerticalAlignment.BOTTOM, actual.verticalAlignment)
        assertEquals(XSSFColor(Color.RED, null), actual.fillForegroundXSSFColor)
    }
}
