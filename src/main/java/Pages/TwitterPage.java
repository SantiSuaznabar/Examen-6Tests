package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TwitterPage {
    WebDriver driver;
    public TwitterPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[contains(text(), '@saucelabs')]")
    WebElement swagLabsName;

    public boolean swagLabsIsDisplayed()
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(swagLabsName));
        boolean swagLabDisplayed = swagLabsName.isDisplayed();
        return swagLabDisplayed;
    }


}
