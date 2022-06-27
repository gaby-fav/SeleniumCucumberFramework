package pages;

public class GooglePage extends BasePage{

    private String searchButton = "//html//body//div//div//form//div//div//div//div//div//center//input[@name='btnK']";
    private String searchTextField = "//input[@name='q']";
    private String firstResult = "//body[@id='gsr']/div[@id='main']/div[@id='cnt']/div[@id='rcnt']/div[@id='center_col']/div[@id='res']/div[@id='search']/div/div[@id='rso']/div[2]/div[1]/div[1]/div[1]/a[1]/h3[1]";
    
    
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
