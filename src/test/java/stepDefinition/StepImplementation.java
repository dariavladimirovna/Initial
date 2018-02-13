package stepDefinition;

import cucumber.api.DataTable;
import cucumber.api.java.ru.*;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static stepDefinition.InitialSteps.*;

public class StepImplementation extends HelpSteps {
    //   WebDriver driver;


/*
    @Когда("^пользователь заполняет поле \"Имя пользователя\" значением \"([^\"]*)\"$")
    public void пользователь_заполняет_поле_Имя_пользователя(String username) throws Throwable {
        enterData("username", "Имя пользователя", username);
    }

    @Когда("^пользователь вводит в поле \"Пароль\" значение \"([^\"]*)\"$")
    public void пользователь_вводит_в_поле_Пароль(String password) throws Throwable {
        enterData("password", "Пароль", password);
    }
    */

    @Когда("^пользователь заполняет поле \"([^\"]*)\" значением \"([^\"]*)\"$")
    public void пользователь_заполняет_поле_значением(String fieldName, String value) throws Throwable {
        loginForm.enterDataLoginForm(fieldName, value);
    }

    @И("^пользователь нажимает ссылку \"([^\"]*)\" в столбце \"Краткое наименование\"")
    @Когда("^пользователь нажимает кнопку \"([^\"]*)\"$")
    //   @Тогда("^пользователь нажимает кнопку выбрать$")
    public void пользователь_нажимает_кнопку(String button) throws Throwable {
        pushButton(button);
    }


    @Тогда("^открывается модальное окно \"([^\"]*)\"$")
    public void открывается_модальное_окно_Выбор_финансовой_организации(String modal) throws Throwable {
        checkElement(modal);
    }

    @Тогда("^пользователь выбирает финансовую организацию \"([^\"]*)\" типа КО$")
    public void пользователь_выбирает_финансовую_организацию(String org) throws Throwable {

        pushButton(org);
        //   driver.findElement(By.xpath("//td[text() = '10']")).click();
        //   WebElement el = driver.findElement(By.xpath("//td[text() = '"+org+"']"));
        //   (new WebDriverWait(driver, 20)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[text() = '10']")));
        //   el.click();
    }

    /*
    @Тогда("^пользователь нажимает кнопку выбрать$")
    public void пользователь_нажимает_кнопку_выбрать(String button) throws Throwable {
        pushButton(button);
    }
    */

    @Тогда("^открывается страница с логотипом \"([^\"]*)\"$")
    public void открывается_страница_с_логотипом_Агенство_по_страхованию_вкладов(String logo) throws Throwable {
        header.checkLogo(logo);
    }

    @Тогда("^открывается страница с финансовой организацией \"([^\"]*)\"$")
    public void открывается_страница_с_финансовой_организацией(String finOrg) throws Throwable {
        checkElement(finOrg);
    }

    @Тогда("^пользователь нажимает кнопку \"([^\"]*)\" в контекстном меню$")
    @А("^пользователь нажимает кнопку Права Все$")
    public void пользователь_нажимает_кнопку_Права_Все(String button) throws Throwable {
        pushButton(button);
    }
/*
    @Тогда("^пользователь нажимает кнопку \"([^\"]*)\" в контекстном меню$")
    public void пользователь_нажимает_кнопку_Выход_в_контекстном_меню(String btnExit) throws Throwable {
        pushButton(btnExit);
    }
    */

    @Когда("^пользователь заполняет поля \"Имя пользователя\" и \"Пароль\" значениями$")
    public void пользователь_заполняjjkеzт_поля_и_значениями(DataTable arg3) throws Throwable {
        List<String> list = arg3.asList(String.class);
        enterData("username", "Имя пользователя", list.get(0));
        enterData("password", "Пароль", list.get(1));
    }

    @Тогда("^открывается страница с сообщением \"([^\"]*)\"$")
    public void открывается_страница_с_сообщением(String element) throws Throwable {
        checkElement(element);
    }

    @Тогда("^пользователь нажимает кнопку с выпадающим списком \"([^\"]*)\"$")
    public void пользователь_нажимает_кнопку_с_выпадающим_списком(String element) throws Throwable {
        header.clickOnNavigationItem(element);
    }

    @Тогда("^пользователь выбирает пункт \"([^\"]*)\"$")
    public void пользователь_выбирает_пункт(String element) throws Throwable {
        header.itemsDropDownList(element);
    }

    @Тогда("^открывается страница с таблицей \"([^\"]*)\"$")
    @И("^открывается экранная форма \"([^\"]*)\"$")
    public void открывается_страница_с_таблицей(String value) throws Throwable {
        resultTable.checkTitle(value);
    }

    @Тогда("^пользователь нажимает кнопку \"([^\"]*)\" в верхней панели таблицы$")
    public void пользователь_нажимает_кнопку_в_верхней_панели_таблицы(String arg1) throws Throwable {
        resultTable.pushSearchButton();
    }

    @А("^пользователь выбирает пункт \"([^\"]*)\" в выпадающем списке \"Тип актива функциональный\"$")
    @Когда("^пользователь выбирает пункт \"([^\"]*)\" в выпадающем списке \"ID Плана Счетов\"$")
    @И("^пользователь выбирает пункт \"([^\"]*)\" в выпадающем списке \"содержит\"$")
    @Тогда("^пользователь выбирает пункт \"([^\"]*)\" в выпадающем списке$")
    public void пользователь_выбирает_пункт_в_выпадающем_списке(String value) throws Throwable {
        chooseOptionInModalWindow(value);
    }

    @Когда("^пользователь заполняет поле значением \"([^\"]*)\"$")
    public void пользователь_заполняет_поле_значением(String value) throws Throwable {
        modalWindowSearchTable.inputDate(value, driver);
    }

    @Тогда("^отображается \"Номер счёта 2-го порядка\" содержащий \"([^\"]*)\"$")
    @И("^отображается \"Номер счёта\" содержащий \"([^\"]*)\"$")
    public void отображается_содержащий(String element) throws Throwable {
        resultTable.checkItems(element);
    }


    @Тогда("^отображается поле \"([^\"]*)\" со значением \"([^\"]*)\"$")
    public void отображается_поле_со_значением(String fieldName, String value) throws Throwable {

    }

    @Тогда("^\"([^\"]*)\" недоступно для редактирования$")
    public void недоступно_для_редактирования(String arg1) throws Throwable {

    }

    @Тогда("^открываются закладки$")
    public void открываются_закладки(DataTable arg1) throws Throwable {
        List<String> nav = arg1.asList(String.class);
        assertEquals(nav, secondStep.getNavigationElementLabels());
    }


/*
    @Когда("^пользователь выбирает пункт \"([^\"]*)\" в выпадающем списке \"Тип актива функциональный\"$")
    public void пользователь_выбирает_пункт_в_выпадающем_списке(String arg1) throws Throwable {
        chooseOptionInModalWindow(arg1);
    }
*/

    /*
    #language: ru
      Функционал: аутентификация в автоматизированную систему учета активов

        Предыстория:
          Дано открыт браузер и осуществлен переход по ссылке
          И открывается страница с формой "Вход в систему"

        @11111
      Структура сценария: аутентификация с валидными данными
          Когда пользователь заполняет поле "Имя пользователя" значением "sua_all"
          И пользователь вводит в поле "Пароль" значение "Q1w2e3r4"
          И пользователь нажимает кнопку "Войти"
          Тогда открывается модальное окно "Выбор финансовой организации"
          Тогда пользователь выбирает финансовую организацию "10" типа КО
          И пользователь нажимает кнопку "Выбрать"
          Тогда открывается страница с логотипом "Агентство по страхованию вкладов"
          Тогда открывается страница с финансовой организацией "10"
          И пользователь нажимает кнопку "Права  Все"
          И пользователь нажимает кнопку "Выход" в контекстном меню
          И браузер закрыт

          Примеры:
          |логин|пароль|
        |sua_all|Q1w2e3r4|
    #      |sua_a1545|Q535dsf|


        @11112
        Сценарий: аутентификация с невалидными данными
          Когда пользователь заполняет поля "Имя пользователя" и "Пароль" значениями
            |sua_zzall|Q1w2e3r4|
          И пользователь нажимает кнопку "Войти"
          Тогда открывается страница с сообщением "Неверное имя пользователя или пароль."
          И браузер закрыт

     */

    @Когда("^пользователь заполняет \"Номер счёта\" значением \"([^\"]*)\"$")
    public void пользователь_заполняет_НомерСчёта_значением(String value) throws Throwable {
        enterData("accountNum", value);
    }

    @И("^пользователь заполняет \"Начальная балансовая стоимость\" значением \"([^\"]*)\"$")
    public void пользователь_заполняет_НачальнаяБалансоваяСтоимость_значением(String value) throws Throwable {
        enterData("balanceInitial", value);
    }

    @И("^пользователь заполняет \"В валюте счёта\" значением \"([^\"]*)\"$")
    public void пользователь_заполняет_ВВалютеСчёта_значением(String value) throws Throwable {
        enterData("balanceInitialCur", value);
    }

    @И("^пользователь заполняет \"Наименование актива\" значением \"([^\"]*)\"$")
    public void пользователь_заполняет_НаименованиеАктива_значением(String value) throws Throwable {
        enterData("name", value);
    }

    @Тогда("^поле \"Текущая балансовая стоимость\" автоматически заполнилось значением \"([^\"]*)\"$")
    public void поле_ТекущаяБалансоваяСтоимость_автоматически_заполнилось_значением(String data) throws Throwable {
          checkAutocompleteData("balanceRur", data);
    }

    @Тогда("^поле \"Валюта счёта\" автоматически заполнилось валютой \"([^\"]*)\"$")
    public void поле_ВалютаСчёта_автоматически_заполнилось_значением(String data) throws Throwable {
         checkAutocompleteData("currency", data);

    }

    @Когда("^пользователь выбирает вкладку \"([^\"]*)\"$")
    public void пользователь_выбирает_вкладку(String el) throws Throwable {
        pushButton(el);
    }

    @Когда("^пользователь заполняет \"Дата начала действия актива\" значением \"([^\"]*)\"$")

    public void пользователь_заполняет_ДатаНачала_значением(String data) throws Throwable {
        enterData("startDate", data);
    }

    @Когда("^пользователь заполняет \"Дата окончания действия актива\" значением \"([^\"]*)\"$")
    public void пользователь_заполняет_ДатаОкончания_значением(String data) throws Throwable {
        enterData("endDate", data);
    }

    @И("^нажимает на кнопку \"Сохранить\"$")
    public void нажимает_кнопку_Сохранить() throws Throwable {
        secondStep.pushSaveButton();
    }

    @Когда("^пользователь устанавливает флаг$")
    public void пользователь_устанавливает_флаг() throws Throwable {
        checkboxClick();
    }

    @Когда("^пользователь нажимает на кнопку \"([^\"]*)\"$")
    public void пользователь_нажимает_на_кнопку(String button) throws Throwable {
        pushButtonContains(button);
    }

    @Когда("^пользователь наводит указатель на \"([^\"]*)\" в выпадающем списке$")
    public void пользователь_наводит_указатель_на_в_выпадающем_списке(String element) throws Throwable {
        navigateMouseTo(element);
    }

    @Когда("^пользователь наводит и выбирает пункт \"([^\"]*)\" в выпадающем списке$")
    public void пользователь_наводит_и_выбирает(String element) throws Throwable {
        navigateClick(element);
    }





}
