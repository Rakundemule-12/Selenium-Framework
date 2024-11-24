package org.example.VWOTests;


import org.example.base.CommonToAllTest;
import org.example.drivers.DriverManager;
import org.example.drivers.DriverManager_TL;
import org.example.pages.PageObjectModel.DashboardPage_POM;
import org.example.pages.PageObjectModel.LoginPage_POM;
import org.example.utils.PropertyReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TestsVwoLogin_POM extends CommonToAllTest {

//    private static final Logger logger = LogManager.getLogger(TestVWOLogin_POM.class);

    @BeforeMethod
    public void setup() {
        // Initialize the WebDriver instance
        DriverManager_TL.init();
    }

    @AfterMethod
    public void teardown() {
        // Quit the WebDriver and remove it from ThreadLocal
        if (DriverManager_TL.getDriver() != null) {
            DriverManager_TL.getDriver().quit();
            DriverManager_TL.unload();
        }
    }

    @Test(priority = 1)
    public void testLoginNegativeVWO()
    {

        LoginPage_POM loginPagePom = new LoginPage_POM(DriverManager_TL.getDriver());
        String error_msg_txt = loginPagePom.loginVWOInvalidCreds(PropertyReader.readKey("invalid_username"),PropertyReader.readKey("invalid_password"));
        assertThat(error_msg_txt).isNotBlank().isNotNull().isNotEmpty();
        Assert.assertEquals(error_msg_txt,PropertyReader.readKey("error_message"));

    }

    @Test(priority = 2)
    public void testPositiveVWO()
    {

        LoginPage_POM loginPagePom = new LoginPage_POM(DriverManager_TL.getDriver());
        String error_msg_txt = loginPagePom.loginVWOInvalidCreds(PropertyReader.readKey("username"),PropertyReader.readKey("password"));
        DashboardPage_POM dashboardPage_pom = new DashboardPage_POM();
        String text = dashboardPage_pom.loggedInUserName();
        assertThat(text).isNotBlank().isNotNull().isNotEmpty();
        Assert.assertEquals(text,PropertyReader.readKey("dashboard_name"));

        System.out.println("Login Successful");

    }


}
