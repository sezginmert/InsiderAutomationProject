package tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.InsiderQualityAssurancePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class insiderQADepartman {

    // Testi kosarken Internet yavaslıgından veya sayfanın yüklenememesinden
    // kaynaklı oluşabilecek hatalara karsı bekleme methodları bıraktım.

    InsiderQualityAssurancePage insiderQualityAssurancePage = new InsiderQualityAssurancePage();

    @Test(priority = 0)
    public void careersQAJobVisit(){
        Driver.getDriver().get(ConfigReader.getProperty("QualityAssurancePageUrl"));

        try {

            if (insiderQualityAssurancePage.QAPageCookies.isDisplayed()){
                insiderQualityAssurancePage.QAPageCookies.click();
            }

        } catch (Exception e) {
            ReusableMethods.tumSayfaScreenshotIsimVeTarihli(Driver.getDriver() , "Cookies");
        }

    }


    @Test(priority = 1, dependsOnMethods = "careersQAJobVisit")
    public void seeAllQAFilterjobs() {

        insiderQualityAssurancePage.seeAllQAJobs.click();


        Actions actions = new Actions(Driver.getDriver());
        ReusableMethods.waits(1);

        // Sayfa istenen elemente kadar getiriliyor
        actions.moveToElement(insiderQualityAssurancePage.resultCounter).perform();

        // Burada element gorünmezse screenshot verdirecek ancak testi fail yapmayacak, test kosmaya devam edicek
        try {
            insiderQualityAssurancePage.locationAllClick.click();
            Assert.assertTrue(insiderQualityAssurancePage.locationIstanbulClick.isDisplayed());

        } catch (Exception e) {
           ReusableMethods.tumSayfaScreenshotIsimVeTarihli(Driver.getDriver() ,"AllLocations");
            for (int i = 1; i <= 2; i++) {
                insiderQualityAssurancePage.locationAllClick.click();
            }

        }


        try {
            insiderQualityAssurancePage.locationIstanbulClick.click();

        } catch (Exception e) {
            ReusableMethods.tumSayfaScreenshotIsimVeTarihli(Driver.getDriver() , "IstanbulLocation");
            System.out.println("Istanbul Location butonuna tıklanamadı");
        }


        // Sayfa istenen elemente kadar getiriliyor
        actions.moveToElement(insiderQualityAssurancePage.viewRoleClick).perform();

        ReusableMethods.waits(1);

        //Burada iş listesini yazdırıyorum

        List<WebElement> jobList = insiderQualityAssurancePage.jobList;
        Assert.assertTrue(jobList.size() >= 3);



        List<WebElement> jobDepartment = insiderQualityAssurancePage.jobDepartment;
        ReusableMethods.waits(1);
        try {
            for (WebElement element : jobDepartment) {
                if (element.getText().contains(ConfigReader.getProperty("departman"))){
                    Assert.assertEquals(element.getText(),"Quality Assurance");
                }
            }
        } catch (Exception e) {
            ReusableMethods.tumSayfaScreenshotIsimVeTarihli(Driver.getDriver(),"JobDepartman");
        }

        //Burada jobLocation listesini test ediyorum.
        List<WebElement> jobLocation = insiderQualityAssurancePage.jobLocation;

        try {
            for (WebElement element : jobLocation) {
                if (element.getText().contains(ConfigReader.getProperty("jobLocation"))) {
                   Assert.assertEquals(element.getText(), "Istanbul, Turkey");
                }
            }
        } catch (Exception e) {
            ReusableMethods.tumSayfaScreenshotIsimVeTarihli(Driver.getDriver() , "IstanbulTurkeyLokasyonYok");
            Assert.fail("Istanbul, Turkey lokasyonu bulunamadı");
        }

        String ilkWhd = Driver.driver.getWindowHandle();

        actions.moveToElement(insiderQualityAssurancePage.viewRoleClick).perform();
        insiderQualityAssurancePage.viewRoleClick.click();

        Set<String> tumWhd = Driver.getDriver().getWindowHandles();
        String ikinciWhd = "";

        for (String eacWhd : tumWhd){
            if (!eacWhd.equals(ilkWhd)){
                ikinciWhd = eacWhd;
            }
        }
        Driver.getDriver().switchTo().window(ikinciWhd);

        try {
            String expectedLeverApplicationUrl = ConfigReader.getProperty("formUrl");
            String actualLeverApplicationUrl = Driver.getDriver().getCurrentUrl();

            Assert.assertEquals(actualLeverApplicationUrl,expectedLeverApplicationUrl);
        } catch (Exception e) {
            ReusableMethods.webElementScreenshotTarihVeIsimli(insiderQualityAssurancePage.viewRoleClick, "ViewRoleClick");
        }


    }

}
