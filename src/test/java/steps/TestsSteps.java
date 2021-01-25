package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.*;

public class TestsSteps extends BaseClass {

    private BaseClass base;
    private BaseSteps baseSteps;

    public TestsSteps(BaseClass base, BaseSteps baseSteps) {
        this.baseSteps = baseSteps;
        this.base = base;
    }

    @When("^Open \"([^\"]*)\"$")
    public void open(String url) {
        base.driver.get(url);
        System.out.println(url + " is opened");
    }

    @And("Testing button is pressed on the main page")
    public void testingButtonIsPressedOnTheMainPage() {
       baseSteps.testingButton();
    }

    @Then("Verify date for the next Java QA Engineer course")
    public void verifyDateForTheNextJavaQAEngineerCourse() {
       baseSteps.nextQACourse();
    }

    @And("Our Teachers section is selected from the Teachers menu")
    public void iAmOnTheTeachersPage() {
       baseSteps.teachersPage();
    }

    @Then("Find all teachers with Java QA Engineer on main page")
    public void findAllTeachersWithJavaQAEngineerOnMainPage() {
        baseSteps.findTeachers();
    }
}
