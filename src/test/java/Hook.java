import java.util.concurrent.TimeUnit;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hook extends BaseClass{

    private BaseClass base;

    public Hook(BaseClass base) {
        this.base = base;
    }

    @Before("@Smoke")
    public void testSmoke(){
        System.out.println("Run Smoke Test");

    }

    @Before("@Regression")
    public void testRegression(){
        System.out.println("Run Regression Test");

    }

    @Before
    public void initDriver() {
        System.out.println("Open browser");
        WebDriverManager.chromedriver().setup();
        base.driver = new ChromeDriver();
        base.driver.manage().window().maximize();
        base.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @After
    public void teardown() {
        System.out.println("Close browser");
        base.driver.quit();
    }
}