package stqa.mantis.appmanager;

import org.openqa.selenium.*;

import java.io.File;
import java.util.List;

public class HelperBase {

    protected ApplicationManager app;
    protected WebDriver driver;

    public HelperBase(ApplicationManager app) {
        this.app = app;
        this.driver = app.getDriver();
    }

    protected void click(By locator) {
        find(locator).click();
    }

    protected void type(By locator, String text) {
        click(locator);
        if (text != null) {
            String existingText = find(locator).getAttribute("value");
            if (!text.equals(existingText)) {
                find(locator).clear();
                find(locator).sendKeys(text);
            }
        }
    }

    protected void attach(By locator, File file) {
        if (file != null) {
                find(locator).sendKeys(file.getAbsolutePath());
        }
    }

    protected boolean isElementPresent(By locator) {
        try {
            find(locator);
            return true;
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    public String attribute(By locator, String attName) {
        return find(locator).getAttribute(attName);
    }

    public boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    public WebElement find(By locator) {
        return driver.findElement(locator);
    }

    public List<WebElement> findAll(By locator) {
        return driver.findElements(locator);
    }

}
