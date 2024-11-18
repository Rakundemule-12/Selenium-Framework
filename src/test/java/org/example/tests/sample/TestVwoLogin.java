package org.example.tests.sample;

import org.example.drivers.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestVwoLogin {



    @Test
    public void vWO_Locatior()
    {

        WebDriver driver = DriverManager.getDriver();
        driver.get("https://app.vwo.com/#/login");

        System.out.println(driver.getTitle());

        Assert.assertEquals(driver.getTitle(),"Login - VWO");
        Assert.assertEquals(driver.getCurrentUrl(), "https://app.vwo.com/#/login");

        //Find the email input by ID and enter the email
        //<input type="email" class="text-input W(100%)" name="username" id="login-username" data-qa="hocewoqisi">
        //<input type="password" class="text-input W(100%)" name="password" id="login-password" data-qa="jobodapuxe">
        //<button type="submit" id="js-login-btn" class="btn btn--positive btn--inverted W(100%) H(48px) Fz(16px)" onclick="login.login(event)" data-qa="sibequkica">
        //<div class="notification-box-description" id="js-notification-box-msg" data-qa="rixawilomi">Your email, password, IP address or location did not match</div>


        WebElement emailinputbox  =driver.findElement(By.id("login-username"));
        emailinputbox.sendKeys("admin@admin.com");

        WebElement passwordbox  =driver.findElement(By.id("login-password"));
        passwordbox.sendKeys("mamemem");

        WebElement buttonclick  =driver.findElement(By.id("js-login-btn"));
        buttonclick.click();


        //      below is the code for positive testing
//        WebElement emailinputbox  =driver.findElement(By.id("login-username"));
//        emailinputbox.sendKeys("poldberg1947@gmail.com");
//
//        WebElement passwordbox  =driver.findElement(By.id("login-password"));
//        passwordbox.sendKeys("Team@123");
//
//        WebElement buttonclick  =driver.findElement(By.id("js-login-btn"));
//        buttonclick.click();

        //after 3 seconds an error message should come, please add try catch block or wait method else test case fails
        //because we have not waited

        //<h1 class="page-heading" data-qa="page-heading">Dashboard</h1>
        //h1[@class = "page-heading"]

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }



        WebElement notified = driver.findElement(By.id("js-notification-box-msg"));
        Assert.assertEquals(notified.getText(),"Your email, password, IP address or location did not match");

    }


}
