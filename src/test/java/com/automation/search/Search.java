package com.automation.search;

import com.automation.TestBase;
import com.automation.page.Pages;
import com.automation.utils.ConfigurationReader;
import com.automation.utils.MyDriver;

import org.testng.annotations.Test;


public class Search extends TestBase {
    //Create page object to call search page method
    Pages page = new Pages();

    @Test
    public void SearchOnGoogle() throws InterruptedException {
        MyDriver.get().get(ConfigurationReader.getProperty("Url"));
        Thread.sleep(3000);

        page.searchPage();


    }
}
