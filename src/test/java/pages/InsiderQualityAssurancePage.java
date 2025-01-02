package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class InsiderQualityAssurancePage {

    public InsiderQualityAssurancePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "wt-cli-accept-all-btn")
    public WebElement QAPageCookies;

    @FindBy(xpath = "//a[text()='See all QA jobs']")
    public  WebElement seeAllQAJobs;

    @FindBy(css = "[aria-labelledby='select2-filter-by-location-container'] > .select2-selection__arrow")
    public WebElement locationAllClick;

    @FindBy(xpath = "//p[text()='Account Director']")
    public WebElement resultCounter;

    @FindBy(xpath = "//li[text()='Istanbul, Turkey']")
    public WebElement locationIstanbulClick;

    @FindBy(xpath = "//div[@class='position-list-item-wrapper bg-light']")
    public List<WebElement> jobList;

    @FindBy(xpath = "//a[text()='View Role']")
    public WebElement viewRoleClick;

    @FindBy(xpath = "//span[@class='position-department text-large font-weight-600 text-primary']")
    public List<WebElement> jobDepartment;

    @FindBy(xpath = "//div[@class='position-location text-large']")
    public List<WebElement> jobLocation;




}
