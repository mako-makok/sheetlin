package sheetlin.excel.xssf.style

import sheetlin.core.style.VerticalAlignment
import org.apache.poi.ss.usermodel.VerticalAlignment as XSSFVerticalAlignment

object ExcelXSSFVerticalAlignmentParser {

    fun parse(verticalAlignment: VerticalAlignment): XSSFVerticalAlignment {
        return when (verticalAlignment) {
            VerticalAlignment.TOP -> XSSFVerticalAlignment.TOP
            VerticalAlignment.CENTER -> XSSFVerticalAlignment.CENTER
            VerticalAlignment.BOTTOM -> XSSFVerticalAlignment.BOTTOM
        }
    }
}
