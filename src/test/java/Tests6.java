import com.google.common.collect.Ordering;
import net.bytebuddy.implementation.bind.annotation.IgnoreForBinding;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import Pages.*;
import utilities.DriverManager;

import java.sql.Driver;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.concurrent.TimeUnit;

public class Tests6 extends BseTest{

    @Test@Ignore
    public void verifyOpenFacebook() throws InterruptedException {
        LoginPage loginPage = new LoginPage(DriverManager.getDriver().driver);
        loginPage.setUserNameTextBox("standard_user");
        loginPage.setPasswordTextBox("secret_sauce");
        loginPage.clickOnLoginButton();
        Homepage homepage= new Homepage(DriverManager.getDriver().driver);
        homepage.clickOnFacebookBtn();

        List<String> tabs = new ArrayList<String>(DriverManager.getDriver().driver.getWindowHandles());
        DriverManager.getDriver().driver.switchTo().window(tabs.get(1));

        FBpage fbPage = new FBpage(DriverManager.getDriver().driver);
        //DriverManager.getDriver().driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        Assert.assertTrue(fbPage.swagLabsIsDisplayed());
        //DriverManager.getDriver().driver.close();
    }

    @Test@Ignore
    public void verifyOpenTwitter() throws InterruptedException {
        LoginPage loginPage = new LoginPage(DriverManager.getDriver().driver);
        loginPage.setUserNameTextBox("standard_user");
        loginPage.setPasswordTextBox("secret_sauce");
        loginPage.clickOnLoginButton();
        Homepage homepage= new Homepage(DriverManager.getDriver().driver);
        homepage.clickOnTwitterBtn();

        List<String> tabs = new ArrayList<String>(DriverManager.getDriver().driver.getWindowHandles());
        DriverManager.getDriver().driver.switchTo().window(tabs.get(1));
        TwitterPage tweetPage = new TwitterPage(DriverManager.getDriver().driver);
        //DriverManager.getDriver().driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        Assert.assertTrue(tweetPage.swagLabsIsDisplayed());
        //DriverManager.getDriver().driver.close();
    }

    @Test@Ignore
    public void verifyOpenLinkedIn() throws InterruptedException {
        LoginPage loginPage = new LoginPage(DriverManager.getDriver().driver);
        loginPage.setUserNameTextBox("standard_user");
        loginPage.setPasswordTextBox("secret_sauce");
        loginPage.clickOnLoginButton();
        Homepage homepage= new Homepage(DriverManager.getDriver().driver);
        homepage.clickOnLinkedInBtn();

        List<String> tabs = new ArrayList<String>(DriverManager.getDriver().driver.getWindowHandles());
        DriverManager.getDriver().driver.switchTo().window(tabs.get(1));
        LinkedInPage linkedInpage = new LinkedInPage(DriverManager.getDriver().driver);
        //DriverManager.getDriver().driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        Assert.assertTrue(linkedInpage.swagLabsIsDisplayed());
        //DriverManager.getDriver().driver.close();
    }

    @Test
    public void verifyAbout()
    {
        LoginPage loginPage = new LoginPage(DriverManager.getDriver().driver);
        loginPage.setUserNameTextBox("standard_user");
        loginPage.setPasswordTextBox("secret_sauce");
        loginPage.clickOnLoginButton();
        Homepage homepage= new Homepage(DriverManager.getDriver().driver);
        homepage.clickOnHamburgerBtn();
        homepage.clickOnAbout();
        SauceLabsAbout about = new SauceLabsAbout(DriverManager.getDriver().driver);
        Assert.assertTrue(about.swagLabsIsDisplayed());
    }

    @Test
    public void verifyHighToLow()
    {
        LoginPage loginPage = new LoginPage(DriverManager.getDriver().driver);
        loginPage.setUserNameTextBox("standard_user");
        loginPage.setPasswordTextBox("secret_sauce");
        loginPage.clickOnLoginButton();
        Homepage homepage= new Homepage(DriverManager.getDriver().driver);
        homepage.selectProductFilter("Price (high to low)");
        List<Double> prices = homepage.getAllItemPrices();
        boolean sortedHtL = Ordering.natural().reverse().isOrdered(prices);
        Assert.assertTrue(sortedHtL);
    }

    @Test
    public void verifyZToA()
    {
        LoginPage loginPage = new LoginPage(DriverManager.getDriver().driver);
        loginPage.setUserNameTextBox("standard_user");
        loginPage.setPasswordTextBox("secret_sauce");
        loginPage.clickOnLoginButton();
        Homepage homepage= new Homepage(DriverManager.getDriver().driver);
        homepage.selectProductFilter("Name (Z to A)");
        List<String> prices = homepage.getAllItemNames();
        boolean sortedZtA = Ordering.natural().reverse().isOrdered(prices);
        Assert.assertTrue(sortedZtA);
    }
}
