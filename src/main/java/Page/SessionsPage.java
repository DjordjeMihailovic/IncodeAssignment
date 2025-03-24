package Page;

import Helpers.Table;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.HashMap;
import java.util.Map;

import static Helpers.BaseConstants.DRIVER;

public class SessionsPage extends BasePage {

    @FindBy(xpath = "//button[text()='Add Filter']")
    private WebElement AddFilterButton;

    Table table = new Table();

    public SessionsPage() {
       // wait30.until(ExpectedConditions.visibilityOf(AddFilterButton));
        PageFactory.initElements(DRIVER, this);
    }

    public Map<String, String> getSessionTableDataForRowWithValue (String value) {
        int rownum = table.findRowNumberByCellValue(value);
        return table.getHeaderToCellMappingForRow(rownum);
    }

    public void iClickOnSessionRow(int row) {
        table.ClickOnRow(row);
    }

    public void iClickOnSessionRowWithValue(String value) {
        WebElement cell = DRIVER.findElement(By.xpath("//td[text()='" + value + "']"));
        SingleClick(cell);
    }

}


