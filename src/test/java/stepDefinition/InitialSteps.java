package stepDefinition;

import cucumber.api.java.ru.Дано;
import cucumber.api.java.ru.Тогда;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import pages.*;

public class InitialSteps extends HelpSteps{
    public static WebDriver driver;
    public static Header header;
    public static LoginForm loginForm;
    public static ResultTable resultTable;
    public static ModalWindowSearchTable modalWindowSearchTable;
    public static SecondStep secondStep;
    public static StorageContractInputForm storageContractInputForm;

    public static WebDriver getDriver(){
        if (driver == null){
            System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("-incognito");
            options.addArguments("start-maximized");
            options.addArguments("dom.webnotifications.enabled");
         //   DesiredCapabilities cap = DesiredCapabilities.chrome();
         //   cap.setCapability(ChromeOptions.CAPABILITY, options);
            driver = new ChromeDriver(options);
            header = new Header(driver);
            resultTable = new ResultTable(driver);
            loginForm = new LoginForm(driver);
            secondStep = new SecondStep(driver);
            storageContractInputForm = new StorageContractInputForm(driver);
            modalWindowSearchTable = new ModalWindowSearchTable(driver);
        }
        return driver;
    }

    @Дано("^открыт браузер и осуществлен переход по ссылке$")
    public void openBrowser() throws Throwable {
        driver = getDriver();
        driver.get("http://172.26.25.86:8081/sua/login");
    }

    @Дано("^открывается страница с формой \"([^\"]*)\"$")
    public void открывается_страница_с_формой_Вход_в_ситсему(String window) throws Throwable {
        checkElement(window);
    }

    @Тогда("^браузер закрыт$")
    public void браузер_закрыт() throws Throwable {
        driver.quit();
        driver = null;
    }
}
