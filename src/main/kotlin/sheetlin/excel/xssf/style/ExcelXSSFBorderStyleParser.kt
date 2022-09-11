package sheetlin.excel.xssf.style

import sheetlin.core.style.BorderStyle
import org.apache.poi.ss.usermodel.BorderStyle as XSSFBorderStyle

object ExcelXSSFBorderStyleParser {

    fun parse(borderStyle: BorderStyle): XSSFBorderStyle {
        return when (borderStyle) {
            BorderStyle.THIN -> XSSFBorderStyle.THIN
            BorderStyle.MEDIUM -> XSSFBorderStyle.MEDIUM
            BorderStyle.THICK -> XSSFBorderStyle.THICK
            BorderStyle.DASHED -> XSSFBorderStyle.DASHED
            BorderStyle.DOTTED -> XSSFBorderStyle.DOTTED
            BorderStyle.DOUBLE -> XSSFBorderStyle.DOUBLE
        }
    }
}
