package sheetlin.excel.xssf

import org.apache.poi.xssf.usermodel.XSSFWorkbook
import sheetlin.core.Workbook

object ExcelXSSFWorkbookParser {

    fun parse(workbook: Workbook): XSSFWorkbook {
        val xssfWorkbook = XSSFWorkbook()

        workbook.sheets.forEach { sheet ->
            ExcelXSSFSheetWriter.write(xssfWorkbook, sheet)
        }

        return xssfWorkbook
    }
}
