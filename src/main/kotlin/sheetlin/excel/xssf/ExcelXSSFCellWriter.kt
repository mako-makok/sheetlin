package sheetlin.excel.xssf

import org.apache.poi.xssf.usermodel.XSSFRow
import sheetlin.core.Cell
import sheetlin.core.DateTimeCellValue
import sheetlin.core.FormulaCellValue
import sheetlin.core.NumericCellValue
import sheetlin.core.StringCellValue
import sheetlin.excel.xssf.style.ExcelXSSFStyleParser

object ExcelXSSFCellWriter {

    fun write(xssfRow: XSSFRow, cell: Cell, cellIndex: Int) {
        val xssfCell = xssfRow.createCell(cellIndex)

        val xssfStyle = cell.style?.let { ExcelXSSFStyleParser.parse(xssfCell.sheet.workbook, it) }
        xssfCell.setCellStyle(xssfStyle)

        when (cell.value) {
            is StringCellValue -> xssfCell.setCellValue(cell.value.value)
            is FormulaCellValue -> xssfCell.setCellFormula(cell.value.value)
            is NumericCellValue -> xssfCell.setCellValue(cell.value.value.toDouble())
            is DateTimeCellValue -> xssfCell.setCellValue(cell.value.value)
        }
    }
}
