package com.bridgelabz.baseclass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class BaseClass {

    public WebDriver driver;

    public void setUp() {
        ChromeOptions option = new ChromeOptions();
        option.addArguments("--remote-allow-origins=*");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(option);
        driver.manage().window().maximize();
        driver.get("http://www.deadlinkcity.com/");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    public void closeBrowser() {
        driver.quit();
    }
}

