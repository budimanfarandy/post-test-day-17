package com.juaracoding.pages;

import com.juaracoding.drivers.DriverSingleton;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginQa {

    private WebDriver driver;

    public LoginQa(){
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver,this);
    }

    //locator use Page Factory
    // Halaman Login
    @FindBy(xpath = "//a[normalize-space()='My Account']")
    private WebElement myAccount;
    @FindBy(xpath = "//input[@id='username']")
    private WebElement username;
    @FindBy(xpath = "//input[@id='password']")
    private WebElement password;
    @FindBy(xpath = "//button[@name='login']")
    private WebElement btnLogin;

    // Back To Home Web DemoQa
    @FindBy(xpath = "//a[@class='custom-logo-link']//img[@alt='ToolsQA Demo Site']")
    private WebElement logoHome;

    // Add Product
    @FindBy(xpath = "//a[normalize-space()='black lux graphic t-shirt']")
    private WebElement addProduct;
    @FindBy(xpath = "//select[@id='pa_color']")
    private WebElement colorProduct;
    @FindBy(xpath = "//select[@id='pa_size']")
    private WebElement sizeProduct;
    @FindBy(xpath = "//button[normalize-space()='Add to cart']")
    private WebElement addToChart;
    @FindBy(xpath = "//a[@class='button wc-forward']")
    private WebElement btnChart;

    public void login() {
        myAccount.click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)");
        username.sendKeys("budi.farandy@yopmail.com");
        password.sendKeys("Farandy123_");
        btnLogin.click();
    }

    public void home() {
        logoHome.click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1100)");
    }

    public void addCart() {
        addProduct.click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,800)");
        colorProduct.sendKeys("Black");
        sizeProduct.sendKeys("30");
        addToChart.click();
    }
    public void cart(){
        btnChart.click();
    }

}
