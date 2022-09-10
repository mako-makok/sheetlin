package sheetlin

data class Workbook(
    val sheets: List<Sheet>,
)

data class Sheet(
    val name: String,
    val rows: List<Row>
)

data class Row(
    val cells: List<Cell>
)

data class Cell(
    val value: CellValue,
    val style: Style? = null,
)
