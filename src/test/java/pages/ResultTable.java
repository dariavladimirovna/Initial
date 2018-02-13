package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import stepDefinition.HelpSteps;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ResultTable extends HelpSteps {

    public ResultTable(WebDriver driver) {
        PageFactory.initElements(driver, this);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 50), this);
    }

    @FindAll(@FindBy(how = How.XPATH, using = "//self::node()//ol//*"))
    public List<WebElement> tableTitle;

    public void checkTitle(String element) throws InterruptedException {
        Thread.sleep(1500);
        for (WebElement elem : tableTitle) {
            if (elem.getText().equals(element)) {

                //   isElementPresent(elem, 30);
                assertTrue(elem.getText().contains(element));
                //assertEquals(elem.
                //.getText(), element);
            }
        }
    }

    @FindBy(how = How.XPATH, using = "(//span[@class=\"ui-icon fa fa-search fa-fw\"])[1]")
    private WebElement buttonSearch;

    public void pushSearchButton() {
        isElementPresent(buttonSearch, 30);
        buttonSearch.click();
    }

    @FindBy(how = How.XPATH, using = "//td[contains(text(),'')]")
    public List<WebElement> items;

    public boolean checkItems(String el) {
        for (WebElement elem : items) {
            if (elem.getText().equals(el)) {
                if (items.size() >= 1) {
                    return true;
                }
            }
            return true;
        }
        return false;
    }
}


    /*
        @FindBy(how = How.XPATH, using = "//td[contains(text(),'')]")
        public List<WebElement> items;

        public boolean checkTableItems(String el) {
        }

    public boolean checkNewItem(String el) {
        pushSearchButton();

    }
    */