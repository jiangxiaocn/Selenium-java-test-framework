package org.selenium.pom.factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class driverManagerInitial {
    public WebDriver initializeDriver(String browser){
        WebDriverManager.chromedriver().cachePath("Drivers").setup();
        //WebDriver driver =new ChromeDriver();
        WebDriver driver =new FirefoxDriver();
        driver.manage().window().maximize();
        return driver;
    }
}
