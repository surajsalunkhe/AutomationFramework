package stepdefs.Web;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class testWebdriver {
    private WebDriver driver;
    private String WebdriverPath=System.getProperty("user.dir")+"/src/test/resources/Drivers/chromedriver";
    @BeforeClass
    public void setUp() {
        //WebDriverManager.chromedriver().setup();
        System.setProperty("webdriver.chrome.driver", WebdriverPath);
        driver = new ChromeDriver();
    }

    @Test
    public void Seleniumtest1() {
        System.out.println("In test 1");
        driver.get("http://google.com");
        String expectedPageTitle = "Google";
        Assert.assertTrue(driver.getTitle().contains(expectedPageTitle), "Test Failed");
    }
    @AfterClass
    public void tearDown() {
        if(driver!=null){
            driver.quit();
        }

    }
}
