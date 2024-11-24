package org.example.base;

import org.example.drivers.DriverManager;
import org.example.drivers.DriverManager_TL;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class CommonToAllTest {

    @BeforeTest
    public void setUp()
    {
        DriverManager_TL.init();
    }


    @AfterTest
    public void tearDown()
    {
        DriverManager_TL.down();
    }
}
