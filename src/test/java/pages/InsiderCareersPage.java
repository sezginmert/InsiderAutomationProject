package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class InsiderCareersPage {
    public InsiderCareersPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//a[text()='See all teams']")
    public WebElement seeAllTeamsEnable;

    @FindBy(xpath = "//*[@class='icon-arrow-right location-slider-next ml-4 text-xsmall text-dark']")
    public WebElement nextButton;

    @FindBy(xpath = "//p[text()='New York']")
    public WebElement locationSearch;

    @FindBy(xpath = "//h3[@class='category-title-media mt-5 mb-5 pb-5']")
    public WebElement teamImage;

    @FindBy(className = "elementor-swiper")
    public WebElement teamImageSlider;



}
