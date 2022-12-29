package freecrm.util;

import Test_base.testbase;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;

public class Testutils extends testbase {
    public Testutils() throws IOException {
        super();
    }

    public static void takeScreenshot(String name) throws IOException {
        File srcfile = ((TakesScreenshot) Driver).getScreenshotAs(OutputType.FILE);

        FileUtils.copyFile(srcfile,new File("E:\\Qc\\automation\\eclipse-workspace\\Free-CRM\\Snapshots" +name+".png"));
    }
    /*public void recordervideo() throws ATUTestRecorderException {
        ATUTestRecorder Recorder = new ATUTestRecorder("E:\\Qc\\automation\\eclipse-workspace\\Free-CRM\\videos","",false);
        recorder.start();*/


    }





