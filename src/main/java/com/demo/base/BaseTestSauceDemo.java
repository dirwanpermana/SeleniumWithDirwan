package com.demo.base;

// import org.openqa.selenium.WebDriver;
// import org.openqa.selenium.edge.EdgeDriver;

// // Setup class utama untuk menginisialisasi WebDriver dan membuka halaman SauceDemo
// // Ini adalah kelas dasar yang dapat digunakan oleh kelas pengujian lainnya
// public class BaseTestSauceDemo {
// public WebDriver driver;

//     public void setUp(){
//         /* Setup WebDriver */        
//         driver = new EdgeDriver();
//         driver.get("https://www.saucedemo.com/");
//         driver.manage().window().maximize();
//         driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(10));
//     }

//     // Close the browser after the test
//     public void tearDown() {
//         if (driver != null) {
//             driver.quit();
//         }
//     }
// }

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.File;

public class BaseTestSauceDemo {
    public WebDriver driver;

    public void setUp() {
        WebDriverManager.edgedriver().setup();

        // 🔑 Buat folder user-data-dir yang unik (timestamp) untuk hindari konflik
        String uniqueProfile = "C:/temp/edge-profile-" + System.currentTimeMillis();
        File profileDir = new File(uniqueProfile);
        profileDir.mkdirs(); // buat foldernya dulu

        EdgeOptions options = new EdgeOptions();
        options.addArguments("--headless=new");
        options.addArguments("--disable-gpu");
        options.addArguments("--window-size=1920,1080");
        options.addArguments("--user-data-dir=" + uniqueProfile); // pakai yang unik
        options.addArguments("--remote-allow-origins=*");

        driver = new EdgeDriver(options);
        driver.get("https://www.saucedemo.com/");
        driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(10));
    }

    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

