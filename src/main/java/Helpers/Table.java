package Helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.*;
import java.util.stream.Collectors;

import static Helpers.BaseConstants.DRIVER;

public class Table extends BaseFunctions {


    private WebElement tableElement;

    private static List<WebElement> headers;

    private static List<WebElement> rows;



    public Table() {
        this.tableElement = DRIVER.findElement(By.cssSelector("table[class$='table']"));
        headers = tableElement.findElements(By.cssSelector("thead th:not(:empty)"));
        rows = tableElement.findElements(By.cssSelector("tbody tr"));
    }


    public static List<String> getHeaderNames() {
        return headers.stream()
                .map(WebElement::getText)
                .map(String::trim)
                .collect(Collectors.toList());
    }

    public static List<String> getCellsForRow(int rowNumber) {

        WebElement row = rows.get(rowNumber);

        List<String> cellTexts = row.findElements(By.cssSelector("td")).stream()
                .filter(cell -> !cell.getAttribute("class").contains("session-link")) // Skip cells with "session-link"
                .map(cell -> cell.getText().trim())
                .collect(Collectors.toList());

        return cellTexts;
    }

    public static int getRowCount() {
        return rows.size();
    }

    public int getColumnCount() {
        return rows.isEmpty() ? 0 : rows.get(0).findElements(By.cssSelector("td")).size();
    }


    public static Map<String, String> getHeaderToCellMappingForRow(int rowNumber) {

        List<String> headerNames = getHeaderNames();
        List<String> CellValuesForRow = getCellsForRow(rowNumber);

        Map<String, String> rowMapping = new HashMap<>();
            for (int i = 0; i < headerNames.size(); i++) {
                rowMapping.put(headerNames.get(i), CellValuesForRow.get(i));
            }

        return rowMapping;
    }

    public static List<String> getColumnValues(String columnName) {

        List<String> columnValues = new ArrayList<>();
        List<String> headerNames = getHeaderNames();
        int columnIndex = headerNames.indexOf(columnName);

            if (columnIndex == -1) {
                throw new IllegalArgumentException("Column with name '" + columnName + "' does not exist.");
            }

        int rowCount = getRowCount();

            for (int rowNumber = 0; rowNumber < rowCount ; rowNumber++) {
                List<String> rowCellValues = getCellsForRow(rowNumber);
                columnValues.add(rowCellValues.get(columnIndex).toLowerCase());
            }

        return columnValues;
    }

    public static int findRowNumberByCellValue(String value) {

        for (int rowIndex = 0; rowIndex < rows.size(); rowIndex++) {
            WebElement row = rows.get(rowIndex);
            List<WebElement> cells = row.findElements(By.cssSelector("td"));
            for (WebElement cell : cells) {
                if (cell.getText().toLowerCase().trim().equals(value)) {
                    return rowIndex;
                }
            }
        }
        return -1; // Return -1 if the value is not found in any row
    }

    public void ClickOnRow(int num) {
        WebElement row = rows.get(num - 1);
        SingleClick(row);
    }

}

