package sheetlin.excel.xssf

import org.apache.poi.xssf.usermodel.XSSFSheet
import sheetlin.core.Row

object ExcelXSSFRowWriter {

    fun write(xssfSheet: XSSFSheet, row: Row, rowIndex: Int) {
        val xssfRow = xssfSheet.createRow(rowIndex)

        row.cells.withIndex().forEach {
            val cell = it.value
            val cellIndex = it.index
            ExcelXSSFCellWriter.write(
                xssfRow,
                cell,
                cellIndex
            )
        }
    }
}
