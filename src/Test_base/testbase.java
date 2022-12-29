package Test_base;

import atu.testrecorder.ATUTestRecorder;
import freecrm.util.weblistener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class testbase {
    public static WebDriver Driver ;
   public static Properties prop ;
   public static EventFiringWebDriver e_driver;
   public static weblistener Weblistener ;
    public static ATUTestRecorder recorder ;
    public testbase() throws IOException {
        prop = new Properties();
        FileInputStream fis = new FileInputStream("E:\\Qc\\automation\\eclipse-workspace\\Free-CRM\\src\\freecrm\\config\\config.properties");
        prop.load(fis);
      /* String url = prop.getProperty("URL");
        System.out.println(url);*/
    }

    public void intialization (String browser) {
        if (browser.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "E:\\Qc\\automation\\auto\\chromedriver_win32 (1)\\chromedriver.exe");
            Driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.firefox.driver", "E:\\Qc\\automation\\auto\\chromedriver_win32 (1)\\chromedriver.exe");
            Driver = new FirefoxDriver();
        }
        e_driver=new EventFiringWebDriver(Driver);
        Weblistener =new weblistener();
        e_driver.register(Weblistener);
        Driver=e_driver;
        Driver.get("https://classic.freecrm.com/index.html");
        Driver.manage().window().maximize();

    }
}
