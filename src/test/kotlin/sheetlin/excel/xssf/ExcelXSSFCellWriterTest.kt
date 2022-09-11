package sheetlin.excel.xssf

import org.apache.poi.xssf.usermodel.XSSFColor
import org.apache.poi.xssf.usermodel.XSSFWorkbook
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import sheetlin.core.BooleanCellValue
import sheetlin.core.Cell
import sheetlin.core.DateCellValue
import sheetlin.core.DateTimeCellValue
import sheetlin.core.FormulaCellValue
import sheetlin.core.NumericCellValue
import sheetlin.core.StringCellValue
import sheetlin.core.style.Font
import sheetlin.core.style.Style
import java.awt.Color
import java.time.LocalDate
import java.time.LocalDateTime

internal class ExcelXSSFCellWriterTest {

    @Test
    fun writeStringCellWithStyle() {
        val xssfRow = XSSFWorkbook().createSheet().createRow(0)
        val cell = Cell(
            value = StringCellValue("a"),
            style = Style(
                font = Font(
                    fontColor = Color.RED
                )
            )
        )

        val cellIndex = 2
        ExcelXSSFCellWriter.write(xssfRow, cell, cellIndex)
        val xssfCell = xssfRow.getCell(cellIndex)

        assertEquals("a", xssfCell.stringCellValue)
        assertEquals(
            XSSFColor(Color.RED, null),
            xssfCell.cellStyle.font.xssfColor
        )
    }

    @Test
    fun writeNumericCell() {
        val xssfRow = XSSFWorkbook().createSheet().createRow(0)
        val cell = Cell(
            value = NumericCellValue(3.33),
        )

        val cellIndex = 0
        ExcelXSSFCellWriter.write(xssfRow, cell, cellIndex)
        val xssfCell = xssfRow.getCell(cellIndex)

        assertEquals(3.33, xssfCell.numericCellValue)
    }

    @Test
    fun writeBooleanCell() {
        val xssfRow = XSSFWorkbook().createSheet().createRow(0)
        val cell = Cell(
            value = BooleanCellValue(false),
        )

        val cellIndex = 0
        ExcelXSSFCellWriter.write(xssfRow, cell, cellIndex)
        val xssfCell = xssfRow.getCell(cellIndex)

        assertEquals(false, xssfCell.booleanCellValue)
    }

    @Test
    fun writeDateTimeCell() {
        val xssfRow = XSSFWorkbook().createSheet().createRow(0)
        val datetime = LocalDateTime.of(
            2022,
            9,
            11,
            23,
            31,
            1,
        )
        val cell = Cell(
            value = DateTimeCellValue(datetime),
        )

        val cellIndex = 0
        ExcelXSSFCellWriter.write(xssfRow, cell, cellIndex)
        val xssfCell = xssfRow.getCell(cellIndex)

        assertEquals(datetime, xssfCell.localDateTimeCellValue)
    }

    @Test
    fun writeDateCell() {
        val xssfRow = XSSFWorkbook().createSheet().createRow(0)
        val date = LocalDate.of(2022, 9, 11)

        val cell = Cell(
            value = DateCellValue(date),
        )

        val cellIndex = 0
        ExcelXSSFCellWriter.write(xssfRow, cell, cellIndex)
        val xssfCell = xssfRow.getCell(cellIndex)

        assertEquals(date, xssfCell.localDateTimeCellValue.toLocalDate())
    }

    @Test
    fun writeFormulaCell() {
        val xssfRow = XSSFWorkbook().createSheet().createRow(0)

        val cell = Cell(
            value = FormulaCellValue("1+1"),
        )

        val cellIndex = 0
        ExcelXSSFCellWriter.write(xssfRow, cell, cellIndex)
        val xssfCell = xssfRow.getCell(cellIndex)

        assertEquals("1+1", xssfCell.cellFormula)
    }
}
