package org.example.drivers;

import org.example.utils.PropertyReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import java.util.Locale;

public class DriverManager {

    public static WebDriver driver;

    public static WebDriver getDriver() {
        return driver;
    }

    public static void setDriver(WebDriver driver) {
        DriverManager.driver = driver;
    }

    public static void init()
    {
       String browser = null;
       browser = PropertyReader.readKey("browser");
       browser = browser.toLowerCase();
       if (driver == null)
       {
           switch (browser)
           {
               case "edge" :
                   EdgeOptions edgeOptions = new EdgeOptions();
                   edgeOptions.addArguments("--start-maximized");
                   edgeOptions.addArguments("--guest");
                   driver = new EdgeDriver(edgeOptions);
                   break;

               case "chrome" :
                   ChromeOptions chromeOptions = new ChromeOptions();
                   chromeOptions.addArguments("--start-maximized");
                   chromeOptions.addArguments("--guest");
                   driver = new ChromeDriver(chromeOptions);
                   break;

               default:
                   System.out.println("Not browser found!!");
           }
       }

    }
    public static void down()
    {
        if(driver !=null)
        {
            driver.quit();
            driver = null;
        }
    }




}
