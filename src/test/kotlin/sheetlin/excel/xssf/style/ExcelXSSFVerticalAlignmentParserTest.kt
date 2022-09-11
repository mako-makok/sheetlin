package sheetlin.excel.xssf.style

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import sheetlin.core.style.VerticalAlignment
import org.apache.poi.ss.usermodel.VerticalAlignment as XSSFVerticalAlignment

internal class ExcelXSSFVerticalAlignmentParserTest {

    @Test
    fun parse() {
        assertEquals(
            XSSFVerticalAlignment.TOP,
            ExcelXSSFVerticalAlignmentParser.parse(VerticalAlignment.TOP)
        )
        assertEquals(
            XSSFVerticalAlignment.CENTER,
            ExcelXSSFVerticalAlignmentParser.parse(VerticalAlignment.CENTER)
        )
        assertEquals(
            XSSFVerticalAlignment.BOTTOM,
            ExcelXSSFVerticalAlignmentParser.parse(VerticalAlignment.BOTTOM)
        )
    }
}
