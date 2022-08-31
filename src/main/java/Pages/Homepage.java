package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Homepage {
    WebDriver driver;


    @FindBy(className = "app_logo")
    WebElement appLogo;

    @FindBy(className = "shopping_cart_link")
    WebElement cartIcon;

    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    WebElement sauceLabsBackPackAddToCartButton;

    @FindBy(id = "add-to-cart-sauce-labs-bike-light")
    WebElement sauceLabsBikeLightAddToCartBtn;

    @FindBy(id = "remove-sauce-labs-backpack")
    WebElement sauceLabsBackPackRemoveToCartButton;

    @FindBy(className = "social_facebook")
    WebElement facebookBtn;

    @FindBy(className = "social_twitter")
    WebElement twitterBtn;

    @FindBy(className = "social_linkedin")
    WebElement linkedInBtn;

    @FindBy(id= "react-burger-menu-btn")
    WebElement hamburguerButton;

    @FindBy(id="about_sidebar_link")
    WebElement aboutLink;

    @FindBy(className = "product_sort_container")
    WebElement productFilterDropDown;

    @FindBy(className = "inventory_item_price")
    List<WebElement> itemPricesLabel;

    @FindBy(className = "inventory_item_name")
    List<WebElement> itemNameLabel;


    public Homepage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    public boolean appLogoIsDisplayed() {
        boolean appLogoIsDisplayed = appLogo.isDisplayed();
        return appLogoIsDisplayed;
    }

    public String getCartIconText(){
        String cartText = cartIcon.getText();
        return cartText;
    }

    public void clickOnAddSauceLabsBackPackToCartButton(){
        sauceLabsBackPackAddToCartButton.click();
    }

    public void clickOnAddBikeLightBtn(){sauceLabsBikeLightAddToCartBtn.click();}

    public void clickCartBtn(){cartIcon.click();}

    public void clickOnRemoveSauceLabsBackPackToCartButton(){
        sauceLabsBackPackRemoveToCartButton.click();
    }

    public void clickOnFacebookBtn(){facebookBtn.click();}

    public void clickOnTwitterBtn(){twitterBtn.click();}

    public void clickOnLinkedInBtn(){linkedInBtn.click();}

    public void clickOnHamburgerBtn(){hamburguerButton.click();}

    public void clickOnAbout()
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(aboutLink));
        aboutLink.click();
    }

    public void selectProductFilter(String element){
        Select selectObject = new Select(productFilterDropDown);
        selectObject.selectByVisibleText(element);

    }

    public List<Double> getAllItemPrices(){
        List<Double> prices = new ArrayList<>();

        for (WebElement itemPrice: itemPricesLabel) {
            String itemPriceText = itemPrice.getText();
            StringBuilder sb = new StringBuilder(itemPriceText);
            sb.deleteCharAt(0);
            prices.add(Double.parseDouble(sb.toString()));
        }
        return prices;
    }

    public List<String> getAllItemNames()
    {
        List<String> names =new ArrayList<>();
        for(WebElement itemName:itemNameLabel)
        {
            names.add(itemName.getText());
        }
        return names;
    }


}
