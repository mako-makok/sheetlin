package sheetlin.excel.xssf.style

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import sheetlin.core.style.HorizontalAlignment
import org.apache.poi.ss.usermodel.HorizontalAlignment as XSSFHorizontalAlignment

internal class ExcelXSSFHorizontalAlignmentParserTest {

    @ParameterizedTest
    @CsvSource(
        "LEFT, LEFT",
        "CENTER, CENTER",
        "RIGHT, RIGHT",
    )
    fun parse(xssfHorizontalAlignmentStr: String, horizontalAlignmentStr: String) {
        val xssfHorizontalAlignment = XSSFHorizontalAlignment.valueOf(xssfHorizontalAlignmentStr)
        val horizontalAlignment = HorizontalAlignment.valueOf(horizontalAlignmentStr)

        assertEquals(
            xssfHorizontalAlignment,
            ExcelXSSFHorizontalAlignmentParser.parse(horizontalAlignment)
        )
    }
}
