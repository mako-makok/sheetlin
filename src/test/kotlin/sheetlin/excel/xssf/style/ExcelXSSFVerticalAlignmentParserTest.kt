package sheetlin.excel.xssf.style

import org.apache.poi.ss.usermodel.VerticalAlignment
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class ExcelXSSFVerticalAlignmentParserTest {

    @Test
    fun parse() {
        assertEquals(
            VerticalAlignment.TOP,
            ExcelXSSFVerticalAlignmentParser.parse(sheetlin.VerticalAlignment.TOP)
        )
        assertEquals(
            VerticalAlignment.CENTER,
            ExcelXSSFVerticalAlignmentParser.parse(sheetlin.VerticalAlignment.CENTER)
        )
        assertEquals(
            VerticalAlignment.BOTTOM,
            ExcelXSSFVerticalAlignmentParser.parse(sheetlin.VerticalAlignment.BOTTOM)
        )
    }
}
