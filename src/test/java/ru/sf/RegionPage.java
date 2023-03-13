package ru.sf;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public record RegionPage(WebDriver webDriver) {
    private final static String ACTIVE_REGION = "css-c96isf";
    public String getCurrentActiveRegion() {
        return webDriver.findElement(By.className(ACTIVE_REGION)).getText();
    }
}
