package Test_cases;

import Test_base.testbase;
import atu.testrecorder.ATUTestRecorder;
import atu.testrecorder.exceptions.ATUTestRecorderException;
import freecrm.util.Testutils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;
import java.lang.reflect.Method;

public class Contactspage_test extends testbase {

        public Contactspage_test() throws IOException {
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

    @Test(priority = 8)
    public void addcontact(){
        Driver.switchTo().frame("mainpanel");
        WebElement contactsbutton = Driver.findElement(By.xpath("//a[@title='Contacts']"));
        Actions action = new Actions(Driver);
        action.moveToElement(contactsbutton).build().perform();
        WebElement NewContact = Driver.findElement(By.xpath("//a[@title='New Contact']"));
        NewContact.click();
        WebElement firstname = Driver.findElement(By.id("first_name"));
        WebElement lastname = Driver.findElement(By.id("surname"));
        WebElement campany = Driver.findElement(By.name("client_lookup"));
        WebElement department = Driver.findElement(By.id("department"));
        firstname.sendKeys("ahmed");
        lastname.sendKeys("rabie");
        campany.sendKeys("one solution");
        department.sendKeys("team leader");
        WebElement save = Driver.findElement(By.xpath("//input[@value='Save']"));
        save.click();
    }
    @AfterMethod
    public void teardown(Method method) throws IOException, ATUTestRecorderException {
        Testutils.takeScreenshot(method.getName());
        recorder.stop();
        Driver.quit();
    }}