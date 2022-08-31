package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class CartPage {
    WebDriver driver;
    public CartPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "item_4_title_link")
    WebElement item4Title;

    @FindBy(id = "item_0_title_link")
    WebElement item0Title;

    @FindBy(xpath = "")
    WebElement item0Price;

    @FindBy(xpath = "item_0_title_link")
    WebElement item4Price;

    @FindBy(className = "shopping_cart_link")
    WebElement cartIcon;

    @FindBy(id = "remove-sauce-labs-backpack")
    WebElement item4RemoveBtn;

    @FindBy(id = "remove-sauce-labs-bike-light")
    WebElement item0RemoveBtn;

    public boolean item4isDisplayed()
    {
        boolean item4 = item4Title.isDisplayed();
        return item4;
    }

    public boolean item0isDisplayed()
    {
        boolean item0 = item0Title.isDisplayed();
        return item0;
    }

    public boolean item4isThere()
    {
        boolean item4 = driver.findElements(By.id("item_4_title_link")).isEmpty();
        return item4;
    }

    public boolean item0isThere()
    {
        boolean item0 = driver.findElements(By.id("item_0_title_link")).isEmpty();
        return item0;
    }

    public String getCartIconText(){
        String cartText = cartIcon.getText();
        return cartText;
    }

    public void clickOnRemoveItem0Btn(){item0RemoveBtn.click();}

    public void clickOnRemoveItem4Btn(){item4RemoveBtn.click();}

    public List<WebElement> getPrices()
    {
        List<WebElement> prices = driver.findElements(By.className("inventory_item_price"));
        return prices;
    }
}
