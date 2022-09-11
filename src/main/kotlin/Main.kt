import sheetlin.core.AbstractCell
import sheetlin.core.Cell
import sheetlin.core.CellValue
import sheetlin.core.FormulaCellValue
import sheetlin.core.NumericCellValue
import sheetlin.core.Row
import sheetlin.core.Sheet
import sheetlin.core.StringCellValue
import sheetlin.core.Workbook
import sheetlin.core.style.Border
import sheetlin.core.style.BorderStyle
import sheetlin.core.style.Font
import sheetlin.core.style.Style
import sheetlin.excel.xssf.ExcelXSSFWorkbookParser
import java.awt.Color
import java.io.FileOutputStream
import java.io.IOException
import java.math.BigDecimal

fun main(args: Array<String>) {
    val workbook = Workbook(
        sheets = listOf(
            Sheet(
                "sheet1",
                listOf(
                    Row(
                        listOf(
                            Cell(
                                StringCellValue("1A"),
                                Style(
                                    font = Font(
                                        fontName = "HGGothicE",
                                        fontColor = Color.BLUE,
                                        italic = true,
                                        bold = true,
                                        strikeThrough = true,
                                    ),
                                    locked = true,
                                    wrapText = true,
                                    hidden = true,
                                    borderBottom = Border(
                                        borderStyle = BorderStyle.THIN,
                                        color = Color.GREEN
                                    )
                                )
                            ),
                            Cell(
                                FormulaCellValue("1+1"),
                                Style(
                                    hidden = true,
                                    font = Font(
                                        fontColor = Color.RED
                                    ),
                                    backgroundColor = Color.GRAY
                                )
                            ),
                            CustomCell(
                                NumericCellValue(BigDecimal.valueOf(1))
                            ),
                        )
                    ),
                    Row(
                        listOf(
                            CustomCell(
                                StringCellValue("2A")
                            ),
                            CustomCell(
                                StringCellValue("2B")
                            ),
                            CustomCell(
                                StringCellValue("2C")
                            ),
                        )
                    )
                )
            )
        )
    )

    val excelWorkbook = ExcelXSSFWorkbookParser.parse(workbook)

    var out: FileOutputStream? = null
    try {
        out = FileOutputStream("sample2_2.xlsx")
        excelWorkbook.write(out)
    } catch (e: IOException) {
        println(e.toString())
        throw e
    } finally {
        try {
            out!!.close()
        } catch (e: IOException) {
            println(e.toString())
            throw e
        }
    }
}

data class CustomCell(
    override val value: CellValue,
) : AbstractCell {
    override val style: Style = Style(
        backgroundColor = Color.GREEN
    )
}
