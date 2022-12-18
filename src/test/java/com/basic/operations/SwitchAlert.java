package com.basic.operations;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class SwitchAlert {
    private WebDriver driver;
    private String baseUrl;

    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        baseUrl = "https://courses.letskodeit.com/practice";

        // Maximize the browser's window
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.get(baseUrl);
    }

    @Test
    public void test1() throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(By.id("name")).sendKeys("Anil");
        driver.findElement(By.id("alertbtn")).click();
        Thread.sleep(3000);
        Alert alert = driver.switchTo().alert();//only with java script alert
        alert.accept();
    }

    @Test
    public void test2() throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(By.id("name")).sendKeys("Anil");
        driver.findElement(By.id("confirmbtn")).click();
        Thread.sleep(3000);
        Alert alert = driver.switchTo().alert();
        alert.accept();
        //alert.dismiss();
    }

    @After
    public void tearDown() throws Exception {
        Thread.sleep(2000);
        driver.quit();
    }
}
