package com.juaracoding;

import com.juaracoding.drivers.DriverSingleton;
import com.juaracoding.pages.LoginPage;
import com.juaracoding.utils.Constants;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginTest {
    private WebDriver driver;
    private LoginPage loginPage;

    @BeforeClass
    public void setUp(){
        DriverSingleton.getInstance("chrome");
        driver = DriverSingleton.getDriver();
        driver.get(Constants.URL);
        loginPage = new LoginPage();
    }
    @AfterClass
    public void finish(){
        DriverSingleton.delay(3);
        DriverSingleton.closeObjectInstance();
    }
    @Test(priority = 1)
    public void testValidLogin(){
        loginPage.loginform("Admin","admin123");
        Assert.assertEquals(loginPage.getTxtDashboard(),"Dashboard");
        System.out.println("Test case valid login");
    }

    @Test(priority = 2)
    public void testInvalidLogin(){
        loginPage.logout();
        loginPage.loginform("Adminn","admin123");
        Assert.assertEquals(loginPage.getTxtInvalid(),"Invalid credentials");
        System.out.println("Test case invalid loguin");
    }
}
