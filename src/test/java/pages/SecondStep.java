package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import stepDefinition.HelpSteps;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SecondStep extends HelpSteps{

    public SecondStep(WebDriver driver) {
        PageFactory.initElements(driver, this);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 50), this);
    }

    @FindAll({@FindBy(how = How.XPATH, using = "//ul[@class=\"nav nav-tabs full\"]/li/a")})
    public List<WebElement> navigationElements;

    public List<String> getNavigationElementLabels() {

        return navigationElements
                .stream().limit(13)
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    //div[@class='row form-group']//button[text()='Сохранить']
    @FindBy(how = How.XPATH, using = "//div[@class='row form-group']//button[text()='Сохранить']")
    public WebElement saveButton;

    public void pushSaveButton() throws Throwable {
        isElementPresent(saveButton, 30);
        saveButton.click();
    }
}
/*

 */

