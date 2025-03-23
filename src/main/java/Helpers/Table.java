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



    public Table() {
        this.tableElement = DRIVER.findElement(By.cssSelector("table"));
        headers = tableElement.findElements(By.cssSelector("th[id]"));
        rows = tableElement.findElements(By.cssSelector("tr.session-row"));
    }

    public static List<String> getHeaderNames() {
        return headers.stream()
                .map(WebElement::getText)
                .map(String::trim)
                .collect(Collectors.toList());
    }

    public static List<String> getCellsForRow(int rowNumber) {
        WebElement row = rows.get(rowNumber - 1);
        List<String> cellTexts = row.findElements(By.cssSelector("td")).stream()
                .map(cell -> cell.getText().trim())
                .collect(Collectors.toList());

        // Remove the first cell if present ! to be fixed!
        if (!cellTexts.isEmpty()) {
            cellTexts.remove(0);
        }

        return cellTexts;
    }

    // Get the size of the table (row count)
    public int getRowCount() {
        return rows.size();
    }

    public int getColumnCount() {
        return rows.isEmpty() ? 0 : rows.get(0).findElements(By.cssSelector("td")).size();
    }

    public boolean isTableDisplayed() {
        return tableElement.isDisplayed();
    }


    public static Map<String, String> getHeaderToCellMapping(int rowNumber) {

        List<String> headerNames = getHeaderNames();
        List<String> CellValuesForRow = getCellsForRow(rowNumber);

        Map<String, String> rowMapping = new HashMap<>();
        for (int i = 0; i < headerNames.size(); i++) {
            rowMapping.put(headerNames.get(i), CellValuesForRow.get(i)); // Add to the map
        }

        System.out.println(rowMapping);
        return rowMapping;
    }

    public static void ClickOnRow(int num) {
        WebElement row = rows.get(num - 1);
        // maybe wanna fix
        WebElement secondTd = row.findElement(By.cssSelector("td:nth-of-type(2)"));
        SingleClick(secondTd);
    }

}

