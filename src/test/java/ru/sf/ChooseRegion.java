package ru.sf;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
public record ChooseRegion(WebDriver webDriver) {
    private static final String SEARCH_FIELD_CLASS = "css-c96isf";
    private static final String INCORRECT_CLASS = "bzr-field__text-input";
    private static final String ENTRANCE = "css-1h9spzo";
   private static final String ERROR_MESSAGE_SPAN_CLASS = " //div[contains(text(),'Поле должно быть заполнено')]";
    public void go(String url) {
        webDriver.get(url);
    }
    public void searchRegion(String region) {
        webDriver.findElement(By.className(SEARCH_FIELD_CLASS)).click();
        webDriver.findElement(By.xpath("//a[contains(text(),'Красноярский край')]")).click();
          }
    public void incorrect_entrance() {
        webDriver.findElement(By.className(ENTRANCE)).click();
        webDriver.findElement(By.className(INCORRECT_CLASS)).sendKeys(Keys.ENTER);
    }
    public String getBlankMessage() {
        return webDriver.findElement(By.xpath(ERROR_MESSAGE_SPAN_CLASS)).getText();
    }

}
