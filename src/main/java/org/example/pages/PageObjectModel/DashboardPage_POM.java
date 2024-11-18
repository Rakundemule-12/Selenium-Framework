package org.example.pages.PageObjectModel;

import org.example.base.CommanToAllPage;
import org.openqa.selenium.By;

public class DashboardPage_POM extends CommanToAllPage {

    public DashboardPage_POM(){

    }


    // Page Locators
    By userNameOnDashboard = By.cssSelector("[data-qa=\"lufexuloga\"]");



    // Page Actions
    public String loggedInUserName() {
        presenceOfElement(userNameOnDashboard);
        return getElement(userNameOnDashboard).getText();
    }

}
