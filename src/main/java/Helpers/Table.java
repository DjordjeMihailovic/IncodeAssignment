package Helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.*;
import java.util.stream.Collectors;

import static Helpers.BaseConstants.DRIVER;

public class Table extends BaseFunctions {

    private WebElement tableElement;

    private static List<WebElement> headers;

    private static List<WebElement> rows;



    /*public Table() {
        this.tableElement = DRIVER.findElement(By.cssSelector("table[class$='table']"));
        headers = tableElement.findElements(By.cssSelector("th[id]"));
        rows = tableElement.findElements(By.cssSelector("tr[class*='row']"));
    }*/

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

        // Find all <td> elements, filter those without the "session-link" class
        List<String> cellTexts = row.findElements(By.cssSelector("td")).stream()
                .filter(cell -> !cell.getAttribute("class").contains("session-link")) // Skip cells with "session-link"
                .map(cell -> cell.getText().trim()) // Extract and trim text
                .collect(Collectors.toList());

        return cellTexts;
    }


    // Get the size of the table (row count)
    public static int getRowCount() {
        return rows.size();
    }

    public int getColumnCount() {
        return rows.isEmpty() ? 0 : rows.get(0).findElements(By.cssSelector("td")).size();
    }

    public boolean isTableDisplayed() {
        return tableElement.isDisplayed();
    }


    public static Map<String, String> getHeaderToCellMappingForRow(int rowNumber) {

        List<String> headerNames = getHeaderNames();
        List<String> CellValuesForRow = getCellsForRow(rowNumber);

        Map<String, String> rowMapping = new HashMap<>();
        for (int i = 0; i < headerNames.size(); i++) {
            rowMapping.put(headerNames.get(i), CellValuesForRow.get(i)); // Add to the map
        }

        System.out.println(rowMapping);
        return rowMapping;
    }

    public static Map<String, String> getHeaderToCellMappingForAllRows() {
        Map<String, String> allRowsMapping = new HashMap<>();

        // Assume getRowCount() gives the total number of rows in the table
        int rowCount = getRowCount();

        // Iterate through each row and get the header-to-cell mapping
        for (int rowNumber = 0; rowNumber < rowCount; rowNumber++) {
            Map<String, String> rowMapping = getHeaderToCellMappingForRow(rowNumber);
            for (Map.Entry<String, String> entry : rowMapping.entrySet()) {
                // Combine into single map. Use row identifier as prefix or to ensure uniqueness.
                String key = "Row" + rowNumber + "_" + entry.getKey();
                allRowsMapping.put(key, entry.getValue());
            }
        }

        System.out.println(allRowsMapping); // (Optional) Print for debugging
        return allRowsMapping;
    }

    public static List<String> getColumnValues(String columnName) {
        List<String> columnValues = new ArrayList<>();

        // Get all header names
        List<String> headerNames = getHeaderNames();

        System.out.println(headerNames + " these are the headers");

        // Find the index of the target column
        int columnIndex = headerNames.indexOf(columnName);
        System.out.println(columnIndex + " this is the index");
        if (columnIndex == -1) {
            throw new IllegalArgumentException("Column with name '" + columnName + "' does not exist.");
        }

        // Get the total number of rows
        int rowCount = getRowCount();
        System.out.println(rowCount + " this is the row count");

        // Iterate through each row and extract the cell value at the target column index
        for (int rowNumber = 0; rowNumber < rowCount ; rowNumber++) {
            System.out.println(" these are the row cell values");
            List<String> rowCellValues = getCellsForRow(rowNumber);
            System.out.println(rowCellValues + " these are the row cell values");
            columnValues.add(rowCellValues.get(columnIndex).toLowerCase());
        }

        System.out.println(columnValues);
        return columnValues;
    }

    public static int findRowNumberByCellValue(String value) {
        // Iterate through all rows
        for (int rowIndex = 0; rowIndex < rows.size(); rowIndex++) {
            WebElement row = rows.get(rowIndex);

            // Get all <td> elements for the current row
            List<WebElement> cells = row.findElements(By.cssSelector("td"));

            // Search for the text in the <td> elements
            for (WebElement cell : cells) {
                if (cell.getText().toLowerCase().trim().equals(value)) {
                    return rowIndex; // Return the row index if the value matches
                }
            }
        }

        return -1; // Return -1 if the value is not found in any row
    }



    public static void ClickOnRow(int num) {
        WebElement row = rows.get(num - 1);
        // maybe wanna fix
        WebElement secondTd = row.findElement(By.cssSelector("td:nth-of-type(2)"));
        SingleClick(secondTd);
    }

}

