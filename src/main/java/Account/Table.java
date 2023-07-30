package Account;

import Base.BasePage;
import com.opencsv.CSVWriter;
import io.qameta.allure.Allure;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.*;
import java.util.List;

public class Table extends BasePage {
    private final By tableHeader = By.xpath("//thead//tr/*");
    private final By tableRows = By.xpath("//tbody/*");

    public void extractToCsv() {
        File file = new File("src/main/resources/file.csv");
        try {
            FileWriter outputFile = new FileWriter(file);
            CSVWriter writer = new CSVWriter(outputFile);
            String[] elements = elementsToArray(driver.findElements(tableHeader));
            writer.writeNext(elements);
            List<WebElement> body = driver.findElements(tableRows);
            for (int i = 0; i < body.size(); i++) {
                elements = elementsToArray(driver.findElements(By.xpath("//tr[@id='anchor" + i + "']/*")));
                writer.writeNext(elements);
            }
            writer.close();
        } catch(IOException e) {
            e.printStackTrace();
        }
        try {
            Allure.addAttachment("table", new FileInputStream("src/main/resources/file.csv"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private String[] elementsToArray(List<WebElement> elements) {
        return elements
                .stream()
                .map(WebElement::getText)
                .toArray(String[]::new);
    }
}
