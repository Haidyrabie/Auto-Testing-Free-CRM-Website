package Test_cases;

import Test_base.testbase;
import atu.testrecorder.ATUTestRecorder;
import atu.testrecorder.exceptions.ATUTestRecorderException;
import freecrm.util.Testutils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;
import java.lang.reflect.Method;


public class HomePage_test extends testbase {
    public HomePage_test() throws IOException {
        super();
    }
    @Parameters({"browser"})
    @BeforeMethod
    public void Setup(String browser , Method method) throws ATUTestRecorderException {

        recorder = new ATUTestRecorder("E:\\Qc\\automation\\eclipse-workspace\\Free-CRM\\videos",method.getName(),false);
        recorder.start();
        intialization(browser);
        Driver.manage().window().maximize();
        WebElement username = Driver.findElement(By.xpath("//input[@name='username']"));
        WebElement password = Driver.findElement(By.xpath("//input[@name='password']"));
        WebElement loginbutton = Driver.findElement(By.xpath("//input[@value='Login']"));
        username.sendKeys("haidy2");
        password.sendKeys("ahmed2011");
        loginbutton.click();

    }

    //5
    @Test(priority = 5)
    public void clickoncontact(Method method) throws IOException {
        Driver.switchTo().frame("mainpanel");
        WebElement contactsbutton = Driver.findElement(By.xpath("//a[@title='Contacts']"));
        contactsbutton.click();
        WebElement status = Driver.findElement(By.xpath("//td[text()='Status']"));
        boolean Actualresult = status.isDisplayed();
        System.out.println(Actualresult);
        Assert.assertTrue(Actualresult);
    }

    //6
    @Test(priority = 6)
    public void clickondeals(Method method) throws IOException {
        Driver.switchTo().frame("mainpanel");
        WebElement dealsbutton = Driver.findElement(By.xpath("//a[@title='Deals']"));
        dealsbutton.click();
        WebElement keyword = Driver.findElement(By.xpath("//td[text()='Keyword']"));
        boolean Actualresult = keyword.isDisplayed();
        System.out.println(Actualresult);
        Assert.assertTrue(Actualresult);

    }

    @Test(priority = 7)
    public void clickontasks(Method method) throws IOException {
        Driver.switchTo().frame("mainpanel");
        WebElement tasksbutton = Driver.findElement(By.xpath("//a[@title='Tasks']"));
        tasksbutton.click();
        WebElement Company = Driver.findElement(By.xpath("//td[text()='Company']"));
        boolean Actualresult = Company.isDisplayed();
        System.out.println(Actualresult);
        Assert.assertTrue(Actualresult);

    }

    @AfterMethod
    public void teardown(Method method) throws IOException, ATUTestRecorderException {
        Testutils.takeScreenshot(method.getName());
        recorder.stop();
        Driver.quit();
    }
}