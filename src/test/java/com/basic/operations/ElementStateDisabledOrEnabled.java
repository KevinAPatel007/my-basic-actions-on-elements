package com.basic.operations;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class ElementStateDisabledOrEnabled {
    WebDriver driver;
    String baseUrl;

    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        baseUrl = "https://www.google.com";
        driver.manage().timeouts().implicitlyWait(10,  TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(baseUrl);
    }

    @Test
    public void test() {
        WebElement e1 = driver.findElement(By.xpath("//*[@id=\"L2AGLb\"]/div"));
        System.out.println("E1 is Enabled? " + e1.isEnabled());
        e1.click();

        WebElement e2 = driver.findElement(By.xpath("//*[@id=\"gb\"]/div/div[1]/div/div[2]/a"));
        System.out.println("E2 is Enabled? " + e2.isEnabled());

        WebElement e3 = driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input"));
        System.out.println("E3 is Enabled? " + e3.isEnabled());

        e3.sendKeys("letskodeit");
    }

    @After
    public void tearDown() throws Exception {
        Thread.sleep(2000);
       driver.quit();
    }
}
