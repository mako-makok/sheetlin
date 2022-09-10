package sheetlin.excel.xssf.style

import sheetlin.HorizontalAlignment
import org.apache.poi.ss.usermodel.HorizontalAlignment as XSSFHorizontalAlignment

object ExcelXSSFHorizontalAlignmentParser {

    fun parse(horizontalAlignment: HorizontalAlignment): XSSFHorizontalAlignment {
        return when (horizontalAlignment) {
            HorizontalAlignment.LEFT -> XSSFHorizontalAlignment.LEFT
            HorizontalAlignment.CENTER -> XSSFHorizontalAlignment.CENTER
            HorizontalAlignment.RIGHT -> XSSFHorizontalAlignment.RIGHT
        }
    }
}
