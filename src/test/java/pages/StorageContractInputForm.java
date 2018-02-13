package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import java.util.List;

public class StorageContractInputForm {

    public StorageContractInputForm(WebDriver driver) {
        PageFactory.initElements(driver, this);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 50), this);
    }

    @FindBy(how = How.XPATH, using = "//form//div[@class='row ng-scope']//label")
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
