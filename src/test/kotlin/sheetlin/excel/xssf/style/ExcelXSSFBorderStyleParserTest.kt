package sheetlin.excel.xssf.style

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import sheetlin.core.style.BorderStyle
import org.apache.poi.ss.usermodel.BorderStyle as XSSFBorderStyle

internal class ExcelXSSFBorderStyleParserTest {

    @ParameterizedTest
    @CsvSource(
        "THIN, THIN",
        "MEDIUM, MEDIUM",
        "THICK, THICK",
        "DASHED, DASHED",
        "DOTTED, DOTTED",
        "DOUBLE, DOUBLE",
    )
    fun parse(borderStyleStr: String, xssfBorderStyleStr: String) {
        val borderStyle = BorderStyle.valueOf(borderStyleStr)
        val xssfBorderStyle = XSSFBorderStyle.valueOf(xssfBorderStyleStr)

        assertEquals(xssfBorderStyle, ExcelXSSFBorderStyleParser.parse(borderStyle))
    }
}
