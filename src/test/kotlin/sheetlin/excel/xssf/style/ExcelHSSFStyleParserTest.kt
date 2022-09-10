package sheetlin.excel.xssf.style

import org.apache.poi.xssf.usermodel.XSSFColor
import org.apache.poi.xssf.usermodel.XSSFWorkbook
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import sheetlin.Style
import java.awt.Color

internal class ExcelXSSFStyleParserTest {

    @Test
    fun parse() {
        val xssfWorkbook = XSSFWorkbook()
        val style = Style(
            locked = true,
            wrapText = true,
            hidden = true,
            backgroundColor = Color.RED
        )

        val actual = ExcelXSSFStyleParser.parse(
            xssfWorkbook,
            style
        )

        assertEquals(true, actual.locked)
        assertEquals(true, actual.hidden)
        assertEquals(true, actual.wrapText)
        assertEquals(XSSFColor(Color.RED, null), actual.fillForegroundXSSFColor)
    }
}
