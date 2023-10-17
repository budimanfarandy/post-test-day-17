package com.juaracoding;

import com.juaracoding.drivers.DriverSingleton;
import com.juaracoding.pages.LoginPage;
import com.juaracoding.pages.RecruitmentPage;
import com.juaracoding.utils.Constants;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class RecruitmentTest {
    private WebDriver driver;
    private LoginPage loginPage;
    private RecruitmentPage recruitmentPage;

    @BeforeClass
    public void setUp(){
        DriverSingleton.getInstance(Constants.CHROME);
        driver = DriverSingleton.getDriver();
        driver.get(Constants.URL);
        loginPage = new LoginPage();
        recruitmentPage = new RecruitmentPage();
    }

    @AfterClass
    public void finish(){
        DriverSingleton.delay(3);
        DriverSingleton.closeObjectInstance();
    }

    @Test
    public void testAddVacancy(){
    loginPage.loginform("Admin","admin123");
    recruitmentPage.recruitment();
    recruitmentPage.vacancyForm();
    Assert.assertEquals(recruitmentPage.getTxtMessageSuccesful(),"Add Vacancy");
    }

}
