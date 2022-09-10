package sheetlin.excel.xssf.style

import org.apache.poi.xssf.usermodel.XSSFColor
import org.apache.poi.xssf.usermodel.XSSFWorkbook
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import sheetlin.Font
import java.awt.Color

internal class ExcelXSSFFontParserTest {

    @Test
    fun parse() {
        val xssfWorkbook = XSSFWorkbook()
        val font = Font(
            fontName = "HGGothicE",
            fontHeight = 10,
            italic = true,
            bold = true,
            strikeThrough = true,
            fontColor = Color.BLUE
        )

        val actual = ExcelXSSFFontParser.parse(
            xssfWorkbook,
            font
        )

        assertEquals("HGGothicE", actual.fontName)
        assertEquals(10, actual.fontHeight)
        assertEquals(true, actual.italic)
        assertEquals(true, actual.bold)
        assertEquals(true, actual.strikeout)
        assertEquals(XSSFColor(Color.BLUE, null), actual.xssfColor)
    }
}
