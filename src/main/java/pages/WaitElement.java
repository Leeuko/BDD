package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class WaitElement {
    public static void ToBeClickable (WebDriver driver, WebElement element, int timeout){
        new WebDriverWait(driver, timeout).until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void PageLoaded (WebDriver driver, String url, int timeout) {
        new WebDriverWait(driver, timeout).until(ExpectedConditions.urlToBe(url));
    }
}