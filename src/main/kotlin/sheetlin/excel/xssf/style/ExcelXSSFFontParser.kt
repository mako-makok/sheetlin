package sheetlin.excel.xssf.style

import org.apache.poi.ss.usermodel.FontUnderline
import org.apache.poi.xssf.usermodel.XSSFColor
import org.apache.poi.xssf.usermodel.XSSFFont
import org.apache.poi.xssf.usermodel.XSSFWorkbook
import sheetlin.core.style.Font

object ExcelXSSFFontParser {

    fun parse(xssfWorkbook: XSSFWorkbook, font: Font): XSSFFont {
        val xssfFontStyle = xssfWorkbook.createFont()

        font.fontName?.also {
            xssfFontStyle.fontName = font.fontName
        }

        font.fontHeight?.also {
            xssfFontStyle.fontHeight = it
        }

        xssfFontStyle.italic = font.italic
        xssfFontStyle.bold = font.bold
        xssfFontStyle.strikeout = font.strikeThrough
        if (font.underline) {
            xssfFontStyle.underline = FontUnderline.SINGLE.byteValue
        }

        font.fontColor?.also { color ->
            val xssfColor = XSSFColor(color, null)
            xssfFontStyle.setColor(xssfColor)
        }

        return xssfFontStyle
    }
}
