package pages;


import java.time.Duration;
import java.util.List;
// import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;



public class BasePage {

    protected static WebDriver driver;
    private static WebDriverWait wait;
    private static Actions action;

    static{

        System.setProperty("webdriver.chrome.driver", "C:/Users/GABRIELAF/chromedriver_win32/chromedriver.exe");

        ChromeOptions chromeOptions = new ChromeOptions();
        // chromeOptions.addArguments("--headless");
        driver = new ChromeDriver(chromeOptions);
        wait= new WebDriverWait(driver, Duration.ofSeconds(10));

    }

    //CONSTRUCTOR

    public BasePage(WebDriver driver){
        BasePage.driver=driver;
        wait= new WebDriverWait(driver, Duration.ofSeconds(10));
        // ESPERA IMPLICITA deprecada
        // driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        //Thread.sleep(1000); No debe usarse, salvo para probar algo
    }

    public static void navigateTo(String url){
        driver.get(url);
    }

    public static void closeBrowser(){
        driver.quit();

    }

    //método para devolver webElement 
    private WebElement Find(String locator){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
    }
     //metodo para haccer click en un elemento
    public void clickElement(String locator){
        Find(locator).click();
    }

    //metodo para escribir
    public void write(String locator, String textToWrite){
        Find(locator).clear(); //limpia campo de texto
        Find(locator).sendKeys(textToWrite);
    }

    //para utilizar estos metodos, el webelement debe ser select. Si es un div, hay que hacer click y luego buscar por valor.
    public void selectFromDropdownByValue(String locator, String valueToSelect){
        Select dropdown = new Select (Find(locator)); //instancia de un selector
        dropdown.selectByValue(valueToSelect);

    }

    public void selectFromDropdownByIndex(String locator, int valueToSelect){
        Select dropdown = new Select (Find(locator)); //instancia de un selector
        dropdown.selectByIndex(valueToSelect);
    }

    public void selectFromDropdownByText(String locator, String valueToSelect){
        Select dropdown = new Select (Find(locator)); //instancia de un selector
        dropdown.selectByVisibleText(valueToSelect);
    }

    //funcion para hacer hoverover element

    public void hoverOverElement(String locator){
        action.moveToElement(Find(locator));
    }

    //función para clicks
    public void doubleClick(String locator){
        action.doubleClick(Find(locator));
    }

    public void rightClick(String locator){
        action.contextClick(Find(locator));

    }

    //TRAER VALOR DE UNA CELDA DE UNA GRILLA
    public String getValueFromTable(String locator, int row, int column){
        String cellINeed = locator+"/table/tbody/tr["+row+"]/td["+column+"]";

        return Find(cellINeed).getText();
    }

    //setear valor en una grilla
    public void setValueOnTable(String locator, int row, int column, String stringToSend){
        String cellToFill = locator+"/table/tbody/tr["+row+"]/td["+column+"]";

        Find(cellToFill).sendKeys(stringToSend);
    }

    //funciones que nos permita switchear a otro frame

    public void switchToiFrame(int iFrameIndex){
        driver.switchTo().frame(iFrameIndex);
    }

    public void switchToParentiFrame(){
        driver.switchTo().parentFrame();
    }

    public void dismissAlert(){
        try{
        driver.switchTo().alert().dismiss();
        }catch(NoAlertPresentException exception){
            exception.printStackTrace();
        };
        
    }

    //FUNCION PARA DEVOLVER STRING PARA ASSERTS

    public String textFromElement(String locator){
        return Find(locator).getText();
    }

    //funciones booleanas

    public boolean elementIsDisplayed(String locator){
        return Find(locator).isDisplayed();
    }

    public boolean elementIsEnable(String locator){
        return Find(locator).isEnabled();
    }

    public boolean elementIsSelected(String locator){
        return Find(locator).isSelected();
    }

    //funcion para encontrar todos los elementos de una clase
    public List<WebElement> bringMeAllElements(String locator){
        return driver.findElements(By.className(locator));
        
    }

    
}

    