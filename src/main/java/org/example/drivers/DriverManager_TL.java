package org.example.drivers;

import org.example.utils.PropertyReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import java.util.Objects;


public class DriverManager_TL {



    public static final ThreadLocal<WebDriver> dr = new ThreadLocal<>();

    public static void setDriver(WebDriver driver)
    {
        dr.set(driver);
    }
    public static WebDriver getDriver()
    {
        return dr.get();
    }

    public static void unload()
    {
        dr.remove();
    }

    public static void init()
    {
        String browser = null;
        browser = PropertyReader.readKey("browser");
        browser = browser.toLowerCase();
        if (Objects.isNull(DriverManager_TL.getDriver()))
        {
            switch (browser)
            {
                case "edge" :
                    EdgeOptions edgeOptions = new EdgeOptions();
                    edgeOptions.addArguments("--start-maximized");
                    edgeOptions.addArguments("--guest");
                    setDriver(new EdgeDriver(edgeOptions));
                    break;

                case "chrome" :
                    ChromeOptions chromeOptions = new ChromeOptions();
                    chromeOptions.addArguments("--start-maximized");
                    setDriver(new ChromeDriver(chromeOptions));
                    break;

                default:
                    System.out.println("Not browser found!!");
            }
        }

    }

    public static void down()
    {
        if(Objects.nonNull(DriverManager_TL.getDriver()))
        {
//            getDriver().quit();
//            unload();
        }
    }

}
