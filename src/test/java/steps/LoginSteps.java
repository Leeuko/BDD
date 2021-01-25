package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.*;


public class LoginSteps extends BaseClass {

    private BaseClass base;
    private BaseSteps baseSteps;

    public LoginSteps(BaseClass base, BaseSteps baseSteps)
        {
            this.base = base;
            this.baseSteps = baseSteps;}

    @Given("^I am on the main page using URL \"([^\"]*)\"$")
    public void iAmOnTheMainPageUsingURL(String url) {
        base.driver.get(url);
        System.out.println("otus.ru is opened");
    }

    @When("I press Sing In button")
    public void iPressSingInButton() {
        Objects.Logon(base.driver).click();
    }

    @And("I enter (.*), (.*)$")
    public void iEnter(String login, String pass){
        baseSteps.enterCredentials(login, pass);
    }

    @Then("If credentials are valid, user will see profile icon on main page")
    public void ifCredentialsAreValidUserWillSeeProfileIconOnMainPage() {
        baseSteps.verifyCredentials();
    }

    @And("Press on users icon and select Private room from the menu")
    public void pressOnUsersIconAndSelectPrivateRoomFromTheMenu() {
        baseSteps.selectPrivateRoom();
    }


    @Then("Valid {string} is opened")
    public void validIsOpened(String page) {
       baseSteps.verifyPage(page);
    }

    @And("Press on users icon and select My Profile from the menu")
    public void pressOnUsersIconAndSelectMyProfileFromTheMenu() {
       baseSteps.selectMyProfile();
    }

    @And("Enter Personal data")
    public void enterPersonalData() {
        baseSteps.personalData();
    }

    @Then("Press Save")
    public void pressSave() {
       baseSteps.saveButton();
    }

    @Then("Entered Personal data is shown in the Profile and is valid")
    public void enteredPersonalDataIsShownInTheProfileAndIsValid() {
       baseSteps.verifyPersonalData();
    }

    @And("Enter Main data")
    public void enterMainData() {
        baseSteps.mainData();
    }

    @Then("Entered Main data is shown in the Profile and is valid")
    public void enteredMainDataIsShownInTheProfileAndIsValid() {
      baseSteps.verifyMainData();
    }


    @And("Enter Contact Information")
    public void enterContactInformation() {
      baseSteps.contactInformation();
    }

    @Then("Entered Contact Information is shown in the Profile and is valid")
    public void enteredContactInformationIsShownInTheProfileAndIsValid() {
        baseSteps.verifyContactInformatin();
    }
}