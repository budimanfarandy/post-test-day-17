package com.juaracoding.pages;

import com.juaracoding.drivers.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RecruitmentPage {

    private WebDriver driver;

    public RecruitmentPage() {
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }

    //locator use Page Factory
    @FindBy(xpath = "//span[normalize-space()='Recruitment']")
    private WebElement menuRecruitment;
    @FindBy(xpath = "//a[normalize-space()='Vacancies']")
    private WebElement tabVacancy;
    @FindBy(xpath = "//button[normalize-space()='Add']")
    private WebElement btnAdd;
    @FindBy(xpath = "//input[@class='oxd-input oxd-input--active']")
    private WebElement name;
    @FindBy(xpath = "//div[@class='oxd-select-text-input']")
    private WebElement jobTitle;
    @FindBy(xpath = "//input[@placeholder='Type for hints...']")
    private WebElement hiringManager;
    @FindBy(xpath = "//button[@type='submit']")
    private WebElement btnSave;
    @FindBy(xpath = "//h6[@class='oxd-text oxd-text--h6 orangehrm-main-title']")
    private WebElement txtMessageSuccesful;



    public void recruitment(){
        menuRecruitment.click();
    }

    public void vacancyForm(){
        tabVacancy.click();
        btnAdd.click();
        name.sendKeys("Test");
        jobTitle.sendKeys("Chief Financial Officer");
        hiringManager.sendKeys("Sara Tencrady");
        btnSave.click();
    }

    public String getTxtMessageSuccesful(){
        return txtMessageSuccesful.getText();
    }
}
