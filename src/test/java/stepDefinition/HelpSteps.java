package stepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class HelpSteps {
    WebDriver driver = InitialSteps.getDriver();

    public void enterData(String id, String placeholder, String data) {
        WebElement element = driver.findElement(By.xpath("//input[@id='" + id + "'][@placeholder='" + placeholder + "']"));
        element.clear();
        element.sendKeys(data);
    }

    public void enterData(String name, String data) {
        WebElement element = driver.findElement(By.xpath("//input[@name='" + name + "']"));
        isElementPresent(element, 30);
        element.click();
        element.clear();
        element.sendKeys(data);
        element.sendKeys(Keys.TAB);
    }

    public void checkAutocompleteData(String name, String data) {
        WebElement element = driver.findElement(By.xpath("//self::node()[@name='" + name + "']"));
        System.out.println(element.getAttribute("value"));
        assertTrue(element.getAttribute("value").contains(data));

        //    assertEquals(data, element.getAttribute("value"));
    }

    public void pushButton(String button) throws Throwable {
        WebElement element = driver.findElement(By.xpath("//self::node()[text()='" + button + "']"));
        isElementPresent(element, 30);
        element.click();
    }

    public void pushButtonContains(String button) throws Throwable {
        WebElement element = driver.findElement(By.xpath("//self::node()[contains(text(),'" + button + "')]"));
        isElementPresent(element, 30);
        element.click();
    }

    public void checkElement(String element) {
        WebElement el = driver.findElement(By.xpath("//self::node()[text()='" + element + "']"));
        isElementPresent(el, 30);
//        el.isDisplayed();
//        assertEquals(el.getText(), element);
        assertTrue(el.getText().equalsIgnoreCase(element));
    }


    public boolean isElementPresent(WebElement elementName, int timeout) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            Thread.sleep(700);
            wait.until(ExpectedConditions.visibilityOf(elementName));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isElementsPresent(List<WebElement> elementName, int timeout) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            wait.until(ExpectedConditions.visibilityOfAllElements(elementName));
            return true;
        } catch (Exception e) {
            return false;
        }
    }


    public void chooseOptionInModalWindow(String element) {
        WebElement el = driver.findElement(By.xpath("//option[text()='" + element + "']"));
        isElementPresent(el, 30);
        el.click();
    }

    public void checkboxClick() throws InterruptedException {
        //  WebElement el = driver.findElement(By.xpath("//table[@id=\"dlko-docs-assets\"]//input[@name=\"checkCell\"]"));
        WebElement el = driver.findElement(By.xpath("//input[@id=\"dlko-docs-assets_checkAll\"]"));
        //WebElement el = driver.findElement(By.xpath("//td//input[@type='checkbox']"));
        // isElementPresent(el, 30);
        clickWithTimeout(el, 10);
        //  assertTrue(clickWithTimeout(el, 10));
        // Actions actions = new Actions(driver);
        //  actions.moveToElement(el).click().perform();
/*
Thread.sleep(4000);
        if (!el.isSelected()) {
            el.click();
        }
        */
    }

    public boolean clickWithTimeout(WebElement e, int timeout) {
        double passedTime = 0;
        while (passedTime < timeout) {
            try {
                e.click();
                return true;
            } catch (Exception exception) {
                passedTime += 0.01;
            }
        }
        return false;
    }

    public void navigateMouseTo(String element) {
        WebElement el = driver.findElement(By.xpath("//a[text()='" + element + "']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(el).build().perform();
    }

    public void navigateClick(String element) {
        WebElement el = driver.findElement(By.xpath("//a[text()='" + element + "']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(el).click().perform();
    }


}
