package sheetlin.excel.xssf.style

import org.apache.poi.ss.usermodel.FillPatternType
import org.apache.poi.xssf.usermodel.XSSFColor
import org.apache.poi.xssf.usermodel.XSSFWorkbook
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import sheetlin.core.style.Border
import sheetlin.core.style.BorderStyle
import sheetlin.core.style.Font
import sheetlin.core.style.HorizontalAlignment
import sheetlin.core.style.Style
import sheetlin.core.style.VerticalAlignment
import java.awt.Color
import org.apache.poi.ss.usermodel.BorderStyle as XSSFBorderStyle
import org.apache.poi.ss.usermodel.HorizontalAlignment as XSSFHorizontalAlignment
import org.apache.poi.ss.usermodel.VerticalAlignment as XSSFVerticalAlignment

internal class ExcelXSSFStyleParserTest {

    @Test
    fun parse() {
        val xssfWorkbook = XSSFWorkbook()
        val style = Style(
            font = Font(
                fontColor = Color.CYAN
            ),
            locked = true,
            hidden = true,
            wrapText = true,
            horizontalAlignment = HorizontalAlignment.RIGHT,
            verticalAlignment = VerticalAlignment.BOTTOM,
            backgroundColor = Color.RED,
            borderTop = Border(
                borderStyle = BorderStyle.THIN,
                color = Color.RED
            ),
            borderLeft = Border(
                borderStyle = BorderStyle.MEDIUM,
                color = Color.GREEN
            ),
            borderBottom = Border(
                borderStyle = BorderStyle.THICK,
                color = Color.BLUE
            ),
            borderRight = Border(
                borderStyle = BorderStyle.DOTTED,
                color = Color.GRAY
            ),
        )

        val actual = ExcelXSSFStyleParser.parse(
            xssfWorkbook,
            style
        )

        assertEquals(XSSFColor(Color.CYAN, null), actual.font?.xssfColor)
        assertEquals(true, actual.locked)
        assertEquals(true, actual.hidden)
        assertEquals(true, actual.wrapText)
        assertEquals(XSSFHorizontalAlignment.RIGHT, actual.alignment)
        assertEquals(XSSFVerticalAlignment.BOTTOM, actual.verticalAlignment)

        // background color
        assertEquals(XSSFColor(Color.RED, null), actual.fillForegroundXSSFColor)
        assertEquals(FillPatternType.SOLID_FOREGROUND, actual.fillPattern)

        // top border
        assertEquals(XSSFBorderStyle.THIN, actual.borderTop)
        assertEquals(XSSFColor(Color.RED, null), actual.topBorderXSSFColor)

        // left border
        assertEquals(XSSFBorderStyle.MEDIUM, actual.borderLeft)
        assertEquals(XSSFColor(Color.GREEN, null), actual.leftBorderXSSFColor)

        // bottom border
        assertEquals(XSSFBorderStyle.THICK, actual.borderBottom)
        assertEquals(XSSFColor(Color.BLUE, null), actual.bottomBorderXSSFColor)

        // right border
        assertEquals(XSSFBorderStyle.DOTTED, actual.borderRight)
        assertEquals(XSSFColor(Color.GRAY, null), actual.rightBorderXSSFColor)
    }
}
