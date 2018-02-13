package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import java.util.List;
import java.util.stream.Collectors;

public class StorageContractInputForm {

    public StorageContractInputForm(WebDriver driver) {
        PageFactory.initElements(driver, this);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 50), this);
    }

    @FindBy(how = How.XPATH, using = "//form//div[@class='row ng-scope']//label")
    public List<WebElement> navigationElementsInput;

    public List<String> getNavigationElementLabels() {

        return navigationElementsInput
                .stream().limit(13)
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }
}
