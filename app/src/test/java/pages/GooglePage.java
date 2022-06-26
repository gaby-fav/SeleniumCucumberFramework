package pages;

public class GooglePage extends BasePage{

    private String searchButton = "//html//body//div//div//form//div//div//div//div//div//center//input[@name='btnK']";
    private String searchTextField = "//input[@name='q']";
    private String firstResult = "";
    
    
    public GooglePage(){
        super(driver);
    }

    public void navigateToGoogle(){
        navigateTo("https://www.google.com");
    }

    public void clickGooglesearch(){
        clickElement(searchButton);
    }

    public void enterSearchCriteria(String criteria){
        write(searchTextField,criteria);
    }

    public String firstResult(){
        return textFromElement(firstResult);
    }
    
    
}
