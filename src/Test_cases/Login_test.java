package Test_cases;

import Test_base.testbase;
import atu.testrecorder.ATUTestRecorder;
import atu.testrecorder.exceptions.ATUTestRecorderException;
import freecrm.util.Testutils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;


public class Login_test extends testbase {

    public Login_test() throws IOException {
        super();
    }
    @Parameters({"browser"})
    @BeforeMethod
    public void Setup( String browser , Method method) throws ATUTestRecorderException {

            recorder = new ATUTestRecorder("E:\\Qc\\automation\\eclipse-workspace\\Free-CRM\\videos",method.getName(),false);
            recorder.start();

            intialization(browser);
    }
        //1
        @Test(priority = 1)
        public void titletest(Method method) throws IOException {
            SoftAssert softassert = new SoftAssert();
            String Expectedresult = ("Free CRM  - CRM software for customer relationship management, sales, and support.");
            String Actualresult = Driver.getTitle();
            System.out.println(Actualresult);
            softassert.assertEquals(Expectedresult, Actualresult, "this testcase is true");
        }
        //2
        @Test(priority = 2)
        public void urltest (Method method) throws IOException {

            String Expectedresult = ("https://classic.freecrm.com/index.html");
            String Actualresult = Driver.getCurrentUrl();
            System.out.println(Actualresult);
            Assert.assertEquals(Expectedresult, Actualresult);
        }
        //3
        @Test(priority = 3)
        public void Logotest (Method method) throws IOException {

            WebElement logo = Driver.findElement(By.className("img-responsive"));
            Boolean Actualresult = logo.isDisplayed();
            System.out.println(Actualresult);
            Assert.assertTrue(Actualresult);
        }
        //4
        @Test(priority = 4 ,dataProvider = "mydata")
        public void Logintest(Method method,String username, String password) throws IOException {

            WebElement Username = Driver.findElement(By.xpath("//input[@name='username']"));
            WebElement Password = Driver.findElement(By.xpath("//input[@name='password']"));
            WebElement loginbutton = Driver.findElement(By.xpath("//input[@value='Login']"));
            Username.sendKeys("username");
            Password.sendKeys("password");
            Driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
            loginbutton.click();
            String Expectedresult = "CRMPRO";
            String Actualresult = Driver.getTitle();
            System.out.println(Actualresult);
            Assert.assertEquals(Expectedresult, Actualresult);
        }

    @DataProvider
    public Object[][] mydata() {

        Object[][] Data = new Object[5][2];
        Data[0][0] = "haidy2";
        Data[0][1] = "ahmed2011";
        Data[1][0] = "haidy2";
        Data[1][1] = "secret";
        Data[2][0] = "haidy";
        Data[2][1] = "ahmed2011";
        Data[3][0] = "haidy";
        Data[3][1] = "ahmed";
        Data[4][0] = "";
        Data[4][1] = "";


        return Data;
    }
        @AfterMethod
        public void teardown(Method method) throws IOException, ATUTestRecorderException {
        Testutils.takeScreenshot(method.getName());
        recorder.stop();
        Driver.quit();
    }}