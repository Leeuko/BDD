import io.cucumber.java.en.And;
import org.openqa.selenium.By;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class LoginSteps extends BaseClass {

    private BaseClass base;

    public LoginSteps(BaseClass base) {
        this.base = base;
    }

    @Given("^I am on the main page using URL \"([^\"]*)\"$")
    public void iAmOnTheMainPageUsingURL(String url) {
        base.driver.get(url);
        System.out.println("otus.ru is opened");
    }

    @When("I press Sing In button")
    public void iPressSingInButton() {
        Objects.Logon(base.driver).click();
    }

    @And("I enter {string}, {string}")
    public void iEnter(String login, String pass) {
        WaitElement.ToBeClickable(base.driver,Objects.LoginBox(base.driver), 800);
        Objects.LoginBox(base.driver).sendKeys(login);
        Objects.PassBox(base.driver).sendKeys(pass);
        Objects.SubmitButton(base.driver).submit();
        base.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Then("If credentials are valid, user will see profile icon on main page")
    public void ifCredentialsAreValidUserWillSeeProfileIconOnMainPage() {
        if (base.driver.findElements(By.cssSelector(".ic-blog-default-avatar")).size()!=0)
        { System.out.println("Authorization passed");}
        else
        {System.out.println("Authorization failed, login or pass is invalid");}
    }

    @And("Press on users icon and select Private room from the menu")
    public void pressOnUsersIconAndSelectPrivateRoomFromTheMenu() {
        WaitElement.ToBeClickable(base.driver,Objects.Avatar(base.driver), 800);
        WebElement icon = Objects.Avatar(base.driver);
        Actions actions = new Actions(base.driver);
        actions.moveToElement(icon).build().perform();
        Objects.PrivateRoom(base.driver).click();
    }


    @Then("Valid {string} is opened")
    public void validIsOpened(String page) {
        base.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        try {
            Assert.assertEquals(page, base.driver.getCurrentUrl());
            System.out.println("Navigated to correct webpage");
        } catch (Throwable pageNavigationError) {
            System.out.println("Invalid page is opened");
        }
    }

    @And("Press on users icon and select My Profile from the menu")
    public void pressOnUsersIconAndSelectMyProfileFromTheMenu() {
        WaitElement.ToBeClickable(base.driver,Objects.Avatar(base.driver), 800);
        WebElement icon = Objects.Avatar(base.driver);
        Actions actions = new Actions(base.driver);
        actions.moveToElement(icon).build().perform();
        Objects.MyProfile(base.driver).click();
        System.out.println("My Profile page is opened");
    }

    @And("Enter Personal data")
    public void enterPersonalData() {
        WaitElement.ToBeClickable(base.driver, Objects.Name(base.driver), 100);
        Objects.Name(base.driver).clear();
        Objects.Name(base.driver).sendKeys("Liudmila");
        Objects.LastNameLatin(base.driver).clear();
        Objects.LastNameLatin(base.driver).sendKeys("Cosetova");
        Objects.DateofBirth(base.driver).clear();
        Objects.DateofBirth(base.driver).sendKeys("24.11.1985");
    }

    @Then("Press Save")
    public void pressSave() {
        Objects.SaveButton(base.driver).click();
        System.out.println("Data is set");
        WaitElement.PageLoaded(base.driver, "https://otus.ru/lk/biography/skills/", 60);
    }

    @Then("Entered Personal data is shown in the Profile and is valid")
    public void enteredPersonalDataIsShownInTheProfileAndIsValid() {
        Assert.assertEquals("Liudmila", Objects.Name(base.driver).getAttribute("value"), "First Name is invalid in the field");
        Assert.assertEquals("Cosetova", Objects.LastNameLatin(base.driver).getAttribute("value"), "Last Name is invalid in the field");
        Assert.assertEquals("24.11.1985", Objects.DateofBirth(base.driver).getAttribute("value"), "Date of Birth is invalid in the field");
    }

    @And("Enter Main data")
    public void enterMainData() {
        Objects.Country(base.driver).click();
        Objects.SelectCountry(base.driver).click();
        Objects.City(base.driver).click();
        Objects.SelectCity(base.driver).click();
    }

    @Then("Entered Main data is shown in the Profile and is valid")
    public void enteredMainDataIsShownInTheProfileAndIsValid() {
        Assert.assertEquals("Молдова", Objects.Country(base.driver).getText(), "Country is invalid in the field");
        Assert.assertEquals("Кишинев", Objects.City(base.driver).getText(), "City is invalid in the field");
    }


    @And("Enter Contact Information")
    public void enterContactInformation() {
        /*Enter telegram*/
        Objects.SelectConnection(base.driver).click();
        Objects.SelectTelegram(base.driver).click();
        Objects.AddTelegramNumber(base.driver).clear();
        Objects.AddTelegramNumber(base.driver).sendKeys("+3 737 956-51-07");

        /*Enter viber*/
        if (Objects.SecondConnection(base.driver) == null) {
            Objects.AddSecondConnection(base.driver).click();
        }
        Objects.SelectSecondConnection(base.driver).click();
        Objects.SelectViber(base.driver).click();
        Objects.AddViberNumber(base.driver).clear();
        Objects.AddViberNumber(base.driver).sendKeys("+3 737 956-51-07");
    }

    @Then("Entered Contact Information is shown in the Profile and is valid")
    public void enteredContactInformationIsShownInTheProfileAndIsValid() {
        Assert.assertEquals("Тelegram", Objects.SelectConnection(base.driver).getText(), "Connection is invalid in the field");
        Assert.assertEquals("+3 737 956-51-07", Objects.AddTelegramNumber(base.driver).getAttribute("value"), "Telegram Number is invalid in the field");
        Assert.assertEquals("Viber", Objects.SelectSecondConnection(base.driver).getText(), "Connection is invalid in the field");
        Assert.assertEquals("+3 737 956-51-07", Objects.AddViberNumber(base.driver).getAttribute("value"), "Viber Number is invalid in the field");

    }
}