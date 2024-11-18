package org.example.pages.PageObjectModel;

import org.example.base.CommanToAllPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.example.utils.PropertyReader;

public class LoginPage_POM extends CommanToAllPage {

    WebDriver driver;

    public LoginPage_POM(WebDriver driver) {
        this.driver = driver;
    }



    // Page Locators
    private By username = By.id("login-username");
    private By password = By.id("login-password");
    private By Signinbutton = By.id("js-login-btn");
    private By errormessage = By.id("js-notification-box-msg");

    //Page Actions
    public String loginVWOInvalidCreds(String user, String pwd) {
        driver.get(PropertyReader.readKey("url"));
        driver.findElement(username).sendKeys(user);
        driver.findElement(password).sendKeys(pwd);
        driver.findElement(Signinbutton).click();

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebElement error_msg = driver.findElement(By.className("notification-box-description"));
        String error_msg_text  = error_msg.getText();
        String error_msg_attribute_data_qa  = error_msg.getAttribute("data-qa");
        return error_msg_text;
    }


}
