package sheetlin.excel.xssf.style

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import sheetlin.HorizontalAlignment
import org.apache.poi.ss.usermodel.HorizontalAlignment as XSSFHorizontalAlignment

internal class ExcelXSSFHorizontalAlignmentParserTest {

    @Test
    fun parse() {
        assertEquals(
            XSSFHorizontalAlignment.LEFT,
            ExcelXSSFHorizontalAlignmentParser.parse(HorizontalAlignment.LEFT)
        )
        assertEquals(
            XSSFHorizontalAlignment.CENTER,
            ExcelXSSFHorizontalAlignmentParser.parse(HorizontalAlignment.CENTER)
        )
        assertEquals(
            XSSFHorizontalAlignment.RIGHT,
            ExcelXSSFHorizontalAlignmentParser.parse(HorizontalAlignment.RIGHT)
        )
    }
}
