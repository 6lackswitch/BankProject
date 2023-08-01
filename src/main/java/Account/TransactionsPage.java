package Account;

import Base.BasePage;
import Base.Config;
import com.opencsv.CSVWriter;
import io.qameta.allure.Allure;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TransactionsPage extends BasePage {
    private final By backButton = By.xpath("//button[@ng-click='back()']");
    private final By tableHeader = By.xpath("//thead//tr/*");
    private final By tableRows = By.xpath("//tbody/*");
    private static TransactionsPage transactionsPage;
    public static TransactionsPage getInstance() {
        if(transactionsPage == null) {
            return new TransactionsPage();
        }
        return transactionsPage;
    }

    public void extractToCsv(Table table) {
        File file = new File(Config.PATH);
        try {
            FileWriter outputFile = new FileWriter(file);
            CSVWriter writer = new CSVWriter(outputFile);
            writer.writeNext(table.getHeader());
            writer.writeAll(table.getRows());
            writer.close();
        } catch(IOException e) {
            e.printStackTrace();
        }
        try {
            Allure.addAttachment("table", new FileInputStream(Config.PATH));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Table getTable() {
        String[] row;
        Table table = new Table();
        table.setHeader(elementsToArray(driver.findElements(tableHeader)));
        List<WebElement> rows = driver.findElements(tableRows);
        table.setRows(new ArrayList<>());
        for (int i = 0; i < rows.size(); i++) {
            row = elementsToArray(rows.get(i).findElements(By.xpath("./*")));
            row[0] = String.join(" ", swap(row[0].replace(",", "").split(" "), 0, 1));
            table.getRows().add(row);
        }
        return table;
    }

    private String[] elementsToArray(List<WebElement> elements) {
        return elements
                .stream()
                .map(WebElement::getText)
                .toArray(String[]::new);
    }

    private String[] swap(String[] array, int first, int second) {
        String temp = array[first];
        array[first] = array[second];
        array[second] = temp;
        return array;
    }

    public AccountPage back() {
        driver.findElement(backButton).click();
        return AccountPage.getInstance();
    }
}
