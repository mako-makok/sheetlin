package sheetlin.excel.xssf.style

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import sheetlin.core.style.VerticalAlignment
import org.apache.poi.ss.usermodel.VerticalAlignment as XSSFVerticalAlignment

internal class ExcelXSSFVerticalAlignmentParserTest {

    @ParameterizedTest
    @CsvSource(
        "TOP, TOP",
        "CENTER, CENTER",
        "BOTTOM, BOTTOM",
    )
    fun parse(xssfVerticalAlignmentStr: String, VerticalAlignmentStr: String) {
        val xssfVerticalAlignment = XSSFVerticalAlignment.valueOf(xssfVerticalAlignmentStr)
        val verticalAlignment = VerticalAlignment.valueOf(VerticalAlignmentStr)

        assertEquals(
            xssfVerticalAlignment,
            ExcelXSSFVerticalAlignmentParser.parse(verticalAlignment)
        )
    }
}
