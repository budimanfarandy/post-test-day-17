package com.juaracoding;

import com.juaracoding.drivers.DriverSingleton;
import com.juaracoding.pages.LoginQa;
import com.juaracoding.utils.Constants;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginQaTest {

    private WebDriver driver;
    private LoginQa loginQa;

    @BeforeClass
    public void setUp() {
        DriverSingleton.getInstance(Constants.CHROME);
        driver = DriverSingleton.getDriver();
        driver.get(Constants.URL);
        loginQa = new LoginQa();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,300)");
    }

    @AfterClass
    public void finish() {
        DriverSingleton.delay(3);
        DriverSingleton.closeObjectInstance();
    }

    @Test(priority = 1)
    public void testLogin(){
        loginQa.login();
        System.out.println("Berhasil Login");
    }

    @Test(priority = 2)
    public void addCart() {
        addProduct.click();
        colorProduct.sendKeys("Black");
        sizeProduct.sendKeys("30");
        addToChart.click();
        System.out.println("Berhasil Tambah Product");
    }


}
