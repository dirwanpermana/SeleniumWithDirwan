package com.demo.abstractcomponents;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractSauceDemo {
    WebDriver  driver;
    public AbstractSauceDemo(WebDriver driver) {
        this.driver = driver;
    }
// jika element ada, return true, jika tidak ada return false dan di skip
    public Boolean isElementPresent(By locator){
        try {
            driver.findElement(locator);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    //method untuk ngecek element visible
    public void visibilityOfElementLocated(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

}