package sheetlin.excel.xssf.style

import org.apache.poi.ss.usermodel.FillPatternType
import org.apache.poi.xssf.usermodel.XSSFCellStyle
import org.apache.poi.xssf.usermodel.XSSFColor
import org.apache.poi.xssf.usermodel.XSSFWorkbook
import sheetlin.core.style.Style

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

        style.borderTop?.also { borderTop ->
            val xssfBorderStyle = ExcelXSSFBorderStyleParser.parse(borderTop.borderStyle)
            xssfCellStyle.borderTop = xssfBorderStyle
            borderTop.color?.also { borderTopColor ->
                val xssfColor = XSSFColor(borderTopColor, null)
                xssfCellStyle.setTopBorderColor(xssfColor)
            }
        }

        style.borderLeft?.also { borderLeft ->
            val xssfBorderStyle = ExcelXSSFBorderStyleParser.parse(borderLeft.borderStyle)
            xssfCellStyle.borderLeft = xssfBorderStyle
            borderLeft.color?.also { borderLeftColor ->
                val xssfColor = XSSFColor(borderLeftColor, null)
                xssfCellStyle.setLeftBorderColor(xssfColor)
            }
        }

        style.borderBottom?.also { borderBottom ->
            val xssfBorderStyle = ExcelXSSFBorderStyleParser.parse(borderBottom.borderStyle)
            xssfCellStyle.borderBottom = xssfBorderStyle
            borderBottom.color?.also { borderBottomColor ->
                val xssfColor = XSSFColor(borderBottomColor, null)
                xssfCellStyle.setBottomBorderColor(xssfColor)
            }
        }

        style.borderRight?.also { borderRight ->
            val xssfBorderStyle = ExcelXSSFBorderStyleParser.parse(borderRight.borderStyle)
            xssfCellStyle.borderRight = xssfBorderStyle
            borderRight.color?.also { borderRightColor ->
                val xssfColor = XSSFColor(borderRightColor, null)
                xssfCellStyle.setRightBorderColor(xssfColor)
            }
        }

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
