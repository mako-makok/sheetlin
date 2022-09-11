import sheetlin.core.Cell
import sheetlin.core.FormulaCellValue
import sheetlin.core.Row
import sheetlin.core.Sheet
import sheetlin.core.StringCellValue
import sheetlin.core.Workbook
import sheetlin.core.style.Font
import sheetlin.core.style.Style
import sheetlin.excel.xssf.ExcelXSSFWorkbookParser
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
                                        italic = true,
                                        bold = true,
                                        strikeThrough = true
                                    ),
                                    locked = true,
                                    wrapText = true,
                                    hidden = true
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
                            )
//                            Cell("1C"),
//                        )
//                    ),
//                    Row(
//                        listOf(
//                            Cell("2A"),
//                            Cell("2B"),
//                            Cell("2C"),
//                        )
//                    )
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
