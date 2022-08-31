package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
public class SauceLabsAbout {

    WebDriver driver;
    public SauceLabsAbout(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "/html/body/header/div/nav/div/a")
    WebElement mainLogo;

    public boolean swagLabsIsDisplayed()
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(mainLogo));
        boolean logo = mainLogo.isDisplayed();
        return logo;
    }
}
