import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;

public class TestsSteps extends BaseClass {

    private BaseClass base;

    public TestsSteps(BaseClass base) {
        this.base = base;
    }

    @When("^Open \"([^\"]*)\"$")
    public void open(String url) {
        base.driver.get(url);
        System.out.println(url + " is opened");
    }

    @And("Testing button is pressed on the main page")
    public void testingButtonIsPressedOnTheMainPage() {
        WaitElement.ToBeClickable(base.driver,Objects.testingButton(base.driver), 800);
        Objects.testingButton(base.driver).click();
        System.out.println(base.driver.getCurrentUrl() + " is opened");
    }

    @Then("Verify date for the next Java QA Engineer course")
    public void verifyDateForTheNextJavaQAEngineerCourse() {
        WebElement selectAI2 = base.driver.findElement(By.className("lessons"));
        List<WebElement> manualAI2 = selectAI2.findElements(By.xpath("//a/div/div[contains(@class, 'lessons__new-item-title')]"));
        for (WebElement option : manualAI2) {
            String courseTitle = option.getText();
            if (courseTitle.equals("Java QA Engineer")|| courseTitle.equals("Java QA Automation Engineer"))
            {
                String date = Objects.courseStartDate(base.driver).getText();
                System.out.println("Java QA Engineer course starts " + date);
            }
            break;
        }
    }

    @And("Our Teachers section is selected from the Teachers menu")
    public void iAmOnTheTeachersPage() {
        Actions teachers = new Actions(base.driver);
        teachers.moveToElement(base.driver.findElement(By.xpath("//div[contains(@class, 'header2-menu_main')]/div[3]/div"))).perform();
        base.driver.findElement(By.xpath("//a[@href='/teacher/']")).click();
    }

    @Then("Find all teachers with Java QA Engineer on main page")
    public void findAllTeachersWithJavaQAEngineerOnMainPage() {
        List<String> allnames = new ArrayList<>();
        WebElement selectTeacher = base.driver.findElement(By.className("teachers"));
        List<WebElement> teacherInfo = selectTeacher.findElements(By.xpath("//a[@class='teacher']"));
        for (WebElement option : teacherInfo) {
            String allInfo = option.getText();
            String splitted[] = allInfo.split("\n");
            String courseTitle = splitted[splitted.length-1];
            if (courseTitle.equals("Java QA Engineer") || courseTitle.equals("Java QA Automation Engineer")) {
                String teacherName = splitted[0];
                allnames.add(teacherName);
            }
        }
        System.out.println(allnames);
    }
}
