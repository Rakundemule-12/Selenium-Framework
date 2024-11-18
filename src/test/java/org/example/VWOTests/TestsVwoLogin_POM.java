package org.example.VWOTests;


import org.example.base.CommonToAllTest;
import org.example.drivers.DriverManager;
import org.example.pages.PageObjectModel.LoginPage_POM;
import org.example.utils.PropertyReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TestsVwoLogin_POM extends CommonToAllTest {

//    private static final Logger logger = LogManager.getLogger(TestVWOLogin_POM.class);



    @Test
    public void testLoginNegativeVWO()
    {

        LoginPage_POM loginPagePom = new LoginPage_POM(DriverManager.getDriver());
        String error_msg_txt = loginPagePom.loginVWOInvalidCreds(PropertyReader.readKey("invalid_username"),PropertyReader.readKey("invalid_password"));
        assertThat(error_msg_txt).isNotBlank().isNotNull().isNotEmpty();
        Assert.assertEquals(error_msg_txt,PropertyReader.readKey("error_message"));

    }


}
