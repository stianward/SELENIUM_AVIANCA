package com.avianca.mavenproject1;

import java.util.List;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;

public class Base {

    private WebDriver driver;

    public Base(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver chromeDriverConnection() {
        System.setProperty("webdriver.chrome.driver", "src/main/java/chromeDriver/chromedriver.exe");
        driver = new ChromeDriver();
        return driver;
    }

    public WebElement findElement(By locator) {

        return driver.findElement(locator);
    }

    public List<WebElement> findElements(By locator) {
        return driver.findElements(locator);
    }

    public String getText(WebElement element) {
        return element.getText();
    }

    public String getText(By locator) {
        return driver.findElement(locator).getText();
    }

    public void type(String inputText, By locator) {

        driver.findElement(locator).sendKeys(inputText);
    }

    public void click(By locator) {
        driver.findElement(locator).click();
    }

    public Boolean isDisplayed(By locator) {

        try {
            return driver.findElement(locator).isDisplayed();
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }

    public void visit(String url) {
        driver.get(url);
    }
    
    public void clear(By locator){
    driver.findElement(locator).clear();
    
    
    }

    

}
