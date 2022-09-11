package sheetlin.excel.xssf

import org.apache.poi.xssf.usermodel.XSSFWorkbook
import sheetlin.core.Workbook
import java.io.FileOutputStream

object ExcelXSSFFileOutputStreamWriter {

    fun write(outputStream: FileOutputStream, workbook: Workbook, sideEffect: ((XSSFWorkbook) -> Unit)? = null) {
        val xssfWorkbook = ExcelXSSFWorkbookParser.parse(workbook)
        if (sideEffect != null) sideEffect(xssfWorkbook)
        xssfWorkbook.write(outputStream)
    }
}
