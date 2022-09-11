package sheetlin.excel.xssf

import org.apache.poi.xssf.usermodel.XSSFRow
import sheetlin.core.AbstractCell
import sheetlin.core.DateTimeCellValue
import sheetlin.core.FormulaCellValue
import sheetlin.core.NumericCellValue
import sheetlin.core.StringCellValue
import sheetlin.excel.xssf.style.ExcelXSSFStyleParser

object ExcelXSSFCellWriter {

    fun write(xssfRow: XSSFRow, cell: AbstractCell, cellIndex: Int) {
        val xssfCell = xssfRow.createCell(cellIndex)

        val xssfStyle = cell.style?.let { ExcelXSSFStyleParser.parse(xssfCell.sheet.workbook, it) }
        xssfCell.cellStyle = xssfStyle

        when (cell.value) {
            is StringCellValue -> xssfCell.setCellValue((cell.value as StringCellValue).value)
            is FormulaCellValue -> xssfCell.cellFormula = (cell.value as FormulaCellValue).value
            is NumericCellValue -> xssfCell.setCellValue((cell.value as NumericCellValue).value)
            is DateTimeCellValue -> xssfCell.setCellValue((cell.value as DateTimeCellValue).value)
        }
    }
}
