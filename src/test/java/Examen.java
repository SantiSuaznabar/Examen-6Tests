import Pages.CartPage;
import Pages.Homepage;
import Pages.LoginPage;
import org.junit.Assert;
import org.junit.Test;
import utilities.DriverManager;

public class Examen extends BseTest{

    @Test
    public void verifyExamen(){
        //Login
        LoginPage loginPage = new LoginPage(DriverManager.getDriver().driver);
        loginPage.setUserNameTextBox("standard_user");
        loginPage.setPasswordTextBox("secret_sauce");
        loginPage.clickOnLoginButton();

        //Add items
        Homepage homepage= new Homepage(DriverManager.getDriver().driver);
        homepage.clickOnAddSauceLabsBackPackToCartButton();
        homepage.clickOnAddBikeLightBtn();

        //Open Cart
        homepage.clickCartBtn();
        CartPage cartPage = new CartPage(DriverManager.getDriver().driver);

        //Verify Items
        Assert.assertTrue(cartPage.item0isDisplayed());
        Assert.assertTrue(cartPage.item4isDisplayed());

        //Verify Number In Cart
        Assert.assertEquals("2", cartPage.getCartIconText());

        //Verify Prices
        Assert.assertEquals("$29.99", cartPage.getPrices().get(0).getText());
        Assert.assertEquals("$9.99", cartPage.getPrices().get(1).getText());

        //Remove Items
        cartPage.clickOnRemoveItem0Btn();
        cartPage.clickOnRemoveItem4Btn();

        //Verify Items were removed
        Assert.assertTrue(cartPage.item4isThere());
        Assert.assertTrue(cartPage.item0isThere());

        //Verify Icon Is Blank
        Assert.assertEquals("", cartPage.getCartIconText());
    }

}
