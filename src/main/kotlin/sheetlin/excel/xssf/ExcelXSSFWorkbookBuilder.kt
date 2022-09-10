package sheetlin.excel.xssf

import org.apache.poi.xssf.usermodel.XSSFWorkbook
import sheetlin.Workbook

object ExcelXSSFWorkbookBuilder {

    fun build(workbook: Workbook): XSSFWorkbook {
        val xssfWorkbook = XSSFWorkbook()

        workbook.sheets.forEach { sheet ->
            ExcelXSSFSheetWriter.write(xssfWorkbook, sheet)
        }

        return xssfWorkbook
    }
}
