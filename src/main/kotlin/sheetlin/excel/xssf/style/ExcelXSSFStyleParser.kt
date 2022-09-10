package sheetlin.excel.xssf.style

import org.apache.poi.ss.usermodel.FillPatternType
import org.apache.poi.xssf.usermodel.XSSFCellStyle
import org.apache.poi.xssf.usermodel.XSSFColor
import org.apache.poi.xssf.usermodel.XSSFWorkbook
import sheetlin.Style

object ExcelXSSFStyleParser {

    fun parse(xssfWorkbook: XSSFWorkbook, style: Style): XSSFCellStyle {
        val xssfCellStyle = xssfWorkbook.createCellStyle()

        style.font?.also { font ->
            val xssfFontStyle = ExcelXSSFFontParser.parse(xssfWorkbook, font)
            xssfCellStyle.setFont(xssfFontStyle)
        }

        xssfCellStyle.locked = true
        xssfCellStyle.locked = style.locked
        xssfCellStyle.hidden = style.hidden
        xssfCellStyle.wrapText = style.wrapText

        style.horizontalAlignment?.also { horizontalAlignment ->
            xssfCellStyle.alignment = ExcelXSSFHorizontalAlignmentParser.parse(horizontalAlignment)
        }

        style.verticalAlignment?.also { verticalAlignment ->
            xssfCellStyle.verticalAlignment = ExcelXSSFVerticalAlignmentParser.parse(verticalAlignment)
        }

        style.backgroundColor?.also { color ->
            val xssfColor = XSSFColor(color, null)
            xssfCellStyle.setFillForegroundColor(xssfColor)
            xssfCellStyle.fillPattern = FillPatternType.SOLID_FOREGROUND
        }

        return xssfCellStyle
    }
}
