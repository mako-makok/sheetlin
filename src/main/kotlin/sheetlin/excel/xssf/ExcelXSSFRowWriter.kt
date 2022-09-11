package sheetlin.excel.xssf

import org.apache.poi.xssf.usermodel.XSSFSheet
import sheetlin.core.Row

object ExcelXSSFRowWriter {

    fun write(hssfSheet: XSSFSheet, row: Row, rowIndex: Int) {
        val hssfRow = hssfSheet.createRow(rowIndex)

        row.cells.withIndex().forEach {
            val cell = it.value
            val cellIndex = it.index
            ExcelXSSFCellWriter.write(
                hssfRow, cell, cellIndex
            )
        }
    }
}
