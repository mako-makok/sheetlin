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
import sheetlin.excel.xssf.ExcelXSSFFileOutputStreamWriter
import java.awt.Color
import java.io.FileOutputStream
import java.io.IOException

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
                                        fontHeight = 22,
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
                            LightGrayIntCell(4),
                        )
                    ),
                    Row(
                        listOf(
                            LightGrayIntCell(1),
                            LightGrayIntCell(2),
                            LightGrayIntCell(3),
                        )
                    )
                )
            )
        )
    )

    var out: FileOutputStream? = null
    try {
        out = FileOutputStream("workbook1.xlsx")
        ExcelXSSFFileOutputStreamWriter.write(out, workbook) { xssfWorkbook ->
            xssfWorkbook.setSheetName(0, "sideeffectedsheet")
        }
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

data class LightGrayIntCell(
    private val intValue: Int,
) : AbstractCell {
    override val value: CellValue = NumericCellValue(intValue.toBigDecimal())
    override val style: Style = Style(
        backgroundColor = Color.LIGHT_GRAY
    )
}
