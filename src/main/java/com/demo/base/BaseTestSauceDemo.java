package com.demo.base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import java.io.File;

public class BaseTestSauceDemo {
    public WebDriver driver;

    public void setUp() {
        System.setProperty("webdriver.edge.driver", "edgedriver/msedgedriver.exe");
        String uniqueProfile = "C:/temp/edge-profile-" + System.currentTimeMillis();
        File profileDir = new File(uniqueProfile);
        profileDir.mkdirs();

        EdgeOptions options = new EdgeOptions();
        options.addArguments("--headless=new");  //headless mode
        options.addArguments("--disable-gpu");
        options.addArguments("--window-size=1920,1080");
        options.addArguments("--user-data-dir=" + uniqueProfile);
        options.addArguments("--remote-allow-origins=*");

        driver = new EdgeDriver(options);
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(10));
    }

    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

