package tests;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.InsiderCareersPage;
import pages.InsiderHomePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class Insider_VisitWebsite {

    InsiderHomePage insiderHomePage = new InsiderHomePage();
    InsiderCareersPage insiderCareersPage = new InsiderCareersPage();


    @Test(priority = 0 )
    public void InsiderVisit(){

        // Insider anasayfa url gidildi
        Driver.getDriver().get(ConfigReader.getProperty("insiderUrl"));

        // Anasayfa cookie kapatildi
        insiderHomePage.homePageCookies.click();

        // Insider Anasayfa Url gidildigi test edildi
        String expectedUrl = ConfigReader.getProperty("insiderUrl");
        String actualUrl = Driver.getDriver()
                .getCurrentUrl();



    }

    @Test(priority = 1, dependsOnMethods = "InsiderVisit")
    public void dropDownCompanyAndCareerClick(){
        // Header Dropdown company menu click yapıldı
        insiderHomePage.menuDropdownCompanyClick
                .click();

        // Dropdown Careers click yapıldı ve erisilebilir oldugu test edildi
        insiderHomePage.careersClick
                .click();

        String expectedTitle = ConfigReader.getProperty("careersTitle");
        String actualTitle = Driver.getDriver()
                .getTitle();

        Assert.assertTrue(actualTitle.contains(expectedTitle));

    }

    @Test(priority = 2, dependsOnMethods = "dropDownCompanyAndCareerClick")
    public void seeAllTeamsClick(){

        // Actions class ile sayfayı Webelemente kadar indirildi
        ReusableMethods.waits(1);
        Actions actions = new Actions(Driver
                .getDriver());

        ReusableMethods.waits(1);
        actions.moveToElement(insiderCareersPage.seeAllTeamsEnable)
                .perform();

        Assert.assertTrue(insiderCareersPage.seeAllTeamsEnable.isEnabled());

        // See all teams click yapıldı
        ReusableMethods.waits(1);
        insiderCareersPage.seeAllTeamsEnable
                .click();


    }

    @Test(priority = 3, dependsOnMethods = "seeAllTeamsClick")
    public void ourLocationsEnable(){

        // Actions class ile sayfayı Webelemente kadar indirildi
        Actions actions = new Actions(Driver.getDriver());
        ReusableMethods.waits(1);
        actions.moveToElement(insiderCareersPage.locationSearch)
                .perform();

        ReusableMethods.waits(1);

        // Our Locations enable oldugu test edildi
        for (int i = 0; i <= 20; i++) {

            actions.doubleClick(insiderCareersPage.nextButton)
                    .perform();

        }

    }

    @Test(priority = 4, dependsOnMethods = "ourLocationsEnable")
    public void lifeInsider(){

        ReusableMethods.waits(1);

        // Actions class ile sayfayı Webelemente kadar indirildi
        Actions actions = new Actions(Driver.getDriver());
        ReusableMethods.waits(1);

        actions.moveToElement(insiderCareersPage.teamImage)
                .perform();

        ReusableMethods.waits(1);


        // Life at Insider enable oldugu test edildi
        for (int i = 1; i <= 20; i++) {

            actions.doubleClick(insiderCareersPage.teamImageSlider)
                        .perform();

            }
    }

}
