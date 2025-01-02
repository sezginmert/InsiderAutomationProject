package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utilities.Driver;

import java.util.List;

public class InsiderHomePage {

   public InsiderHomePage(){

       PageFactory.initElements(Driver.getDriver(),this);

   }

    @FindBy(id = "wt-cli-accept-all-btn")
    public WebElement homePageCookies;

   @FindBy(xpath = "(//a[@id='navbarDropdownMenuLink'])[5]")
    public WebElement menuDropdownCompanyClick;

   @FindBy(xpath = "//a[text()='Careers']")
    public WebElement careersClick;


}
