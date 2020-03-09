package com.automation.page;


import com.automation.utils.MyDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;


public class Pages {

    public Pages() {
        //For initialize @FindBy
        PageFactory.initElements(MyDriver.get(), this);
    }
    //for search box
    @FindBy(xpath = "//input[@name='q']")
    public WebElement searchBox;
    //for third link on the search result
    @FindBy(xpath = "//a[contains(text(),'LexisNexis (@LexisNexis)')]")
    public WebElement linkClick;


    public void searchPage() throws InterruptedException {

        //Entering LexisNexis to the search box,then click Enter
        searchBox.sendKeys("LexisNexis", Keys.ENTER);

        try {

            scrollDown();
        } catch (InterruptedException e) {
            e.printStackTrace();

        }
        Thread.sleep(2000);
        linkClick.click();
        Thread.sleep(3000);


        //Compare expected and actual Title
        String actual = MyDriver.get().getTitle();
        String expected = "LexisNexis (@LexisNexis) / Twitter";

        Assert.assertEquals(actual, expected);
    }

    public void scrollDown() throws InterruptedException {


        JavascriptExecutor js = (JavascriptExecutor) MyDriver.get();
        /**
         *  this script must scroll, until link element is visible
         *  once link element visible, it will stop scrolling
         */
        js.executeScript("scroll(0, 50);");

        Thread.sleep(3000);
    }
}
