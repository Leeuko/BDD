package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class BaseSteps extends BaseClass {

    private BaseClass base;

    public BaseSteps(BaseClass base) {
        this.base = base;
    }

    public  void enterCredentials(String login, String pass){
        WaitElement.ToBeClickable(base.driver, Objects.LoginBox(base.driver), 800);
        Objects.LoginBox(base.driver).sendKeys(login);
        Objects.PassBox(base.driver).sendKeys(pass);
        Objects.SubmitButton(base.driver).submit();
        base.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public void verifyCredentials(){
        if (base.driver.findElements(By.cssSelector(".ic-blog-default-avatar")).size()!=0)
        { System.out.println("Authorization passed");}
        else
        {System.out.println("Authorization failed, login or pass is invalid");}
    }

    public void selectPrivateRoom (){
        WaitElement.ToBeClickable(base.driver, Objects.Avatar(base.driver), 800);
        WebElement icon = Objects.Avatar(base.driver);
        Actions actions = new Actions(base.driver);
        actions.moveToElement(icon).build().perform();
        Objects.PrivateRoom(base.driver).click();
    }

    public void verifyPage(String page){
        base.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        try {
            Assert.assertEquals(page, base.driver.getCurrentUrl());
            System.out.println("Navigated to correct webpage");
        } catch (Throwable pageNavigationError) {
            System.out.println("Invalid page is opened");
        }
    }

    public void selectMyProfile(){
        WaitElement.ToBeClickable(base.driver, Objects.Avatar(base.driver), 800);
        WebElement icon = Objects.Avatar(base.driver);
        Actions actions = new Actions(base.driver);
        actions.moveToElement(icon).build().perform();
        Objects.MyProfile(base.driver).click();
        System.out.println("My Profile page is opened");
    }

    public void personalData(){
        WaitElement.ToBeClickable(base.driver, Objects.Name(base.driver), 100);
        Objects.Name(base.driver).clear();
        Objects.Name(base.driver).sendKeys("Liudmila");
        Objects.LastNameLatin(base.driver).clear();
        Objects.LastNameLatin(base.driver).sendKeys("Cosetova");
        Objects.DateofBirth(base.driver).clear();
        Objects.DateofBirth(base.driver).sendKeys("24.11.1985");
    }

    public void saveButton(){
        Objects.SaveButton(base.driver).click();
        System.out.println("Data is set");
        WaitElement.PageLoaded(base.driver, "https://otus.ru/lk/biography/skills/", 60);
    }

    public void verifyPersonalData(){
        Assert.assertEquals("Liudmila", Objects.Name(base.driver).getAttribute("value"), "First Name is invalid in the field");
        Assert.assertEquals("Cosetova", Objects.LastNameLatin(base.driver).getAttribute("value"), "Last Name is invalid in the field");
        Assert.assertEquals("24.11.1985", Objects.DateofBirth(base.driver).getAttribute("value"), "Date of Birth is invalid in the field");
    }

    public void mainData(){
        Objects.Country(base.driver).click();
        Objects.SelectCountry(base.driver).click();
        Objects.City(base.driver).click();
        Objects.SelectCity(base.driver).click();
    }

    public void verifyMainData(){
        Assert.assertEquals("Молдова", Objects.Country(base.driver).getText(), "Country is invalid in the field");
        Assert.assertEquals("Кишинев", Objects.City(base.driver).getText(), "City is invalid in the field");
    }

    public  void contactInformation(){
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

    public void verifyContactInformatin(){
        Assert.assertEquals("Тelegram", Objects.SelectConnection(base.driver).getText(), "Connection is invalid in the field");
        Assert.assertEquals("+3 737 956-51-07", Objects.AddTelegramNumber(base.driver).getAttribute("value"), "Telegram Number is invalid in the field");
        Assert.assertEquals("Viber", Objects.SelectSecondConnection(base.driver).getText(), "Connection is invalid in the field");
        Assert.assertEquals("+3 737 956-51-07", Objects.AddViberNumber(base.driver).getAttribute("value"), "Viber Number is invalid in the field");
    }

    public void testingButton(){
        WaitElement.ToBeClickable(base.driver, Objects.testingButton(base.driver), 800);
        Objects.testingButton(base.driver).click();
        System.out.println(base.driver.getCurrentUrl() + " is opened");
    }

    public void nextQACourse(){
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

    public void teachersPage(){
        Actions teachers = new Actions(base.driver);
        teachers.moveToElement(base.driver.findElement(By.xpath("//div[contains(@class, 'header2-menu_main')]/div[3]/div"))).perform();
        base.driver.findElement(By.xpath("//a[@href='/teacher/']")).click();
    }

    public void findTeachers(){
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
