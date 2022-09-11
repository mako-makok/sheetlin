package sheetlin.excel.xssf

import org.apache.poi.xssf.usermodel.XSSFWorkbook
import sheetlin.core.Sheet

object ExcelXSSFSheetWriter {

    fun write(xssfWorkbook: XSSFWorkbook, sheet: Sheet) {
        val xssfSheet = xssfWorkbook.createSheet(sheet.name)

        sheet.rows.withIndex().forEach {
            val row = it.value
            val rowIndex = it.index
            ExcelXSSFRowWriter.write(
                xssfSheet,
                row,
                rowIndex
            )
        }
    }
}
