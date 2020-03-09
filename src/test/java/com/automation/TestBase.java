package com.automation;

import com.automation.utils.MyDriver;

import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeMethod;

public class TestBase {


    @BeforeMethod
    public void setup() {

        //maximize the window
        MyDriver.get().manage().window().maximize();
    }

    @AfterMethod
    public void teardown() throws InterruptedException {
        Thread.sleep(3000);
        MyDriver.get().close();
    }
}
