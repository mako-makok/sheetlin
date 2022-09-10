import sheetlin.Workbook
import sheetlin.Sheet
import sheetlin.Row
import sheetlin.Cell
import sheetlin.StringCellValue
import sheetlin.Style
import sheetlin.Font
import sheetlin.FormulaCellValue
import sheetlin.excel.xssf.ExcelXSSFWorkbookBuilder
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
                                        strikeThrough = true,
                                    ),
                                    locked = true,
                                    wrapText = true,
                                    hidden = true,
                                )
                            ),
                            Cell(
                                FormulaCellValue("1+1"),
                                Style(
                                    hidden = true,
                                    font = Font(
                                        fontColor = Color.RED
                                    ),
                                    backgroundColor = Color.GRAY,
                                )
                            ),
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

    val excelWorkbook = ExcelXSSFWorkbookBuilder.build(workbook)

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
