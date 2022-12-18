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

import java.util.List;
import java.util.concurrent.TimeUnit;

public class CalendarSelection {
    private WebDriver driver;
    private String baseUrl;

    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        baseUrl = "https://www.travelcenter.uk/";

        // Maximize the browser's window
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public void test1() throws Exception {
        driver.get(baseUrl);
        // Click flights tab
       // driver.findElement(By.id("tab-flight-tab-hp")).click();
        // Find departing field
        WebElement departingField = driver.findElement(By.id("//*[@id=\"departureCity\"]"));
        // Click departing field
        departingField.click();
        Thread.sleep(3000);
        // Find the date to be selected
        WebElement dateToSelect = driver.findElement(By.xpath("//*[@id=\"departureDate\"]"));
        // Click the date
        dateToSelect.click();
    }

    @Test
    public void test2() throws Exception {
        driver.get(baseUrl);
       // driver.findElement(By.xpath("")).click();
        WebElement x =  driver.findElement(By.xpath("//*[@id=\"departureCity\"]"));
        x.click();
        x.sendKeys("lhr");
        //driver.findElement(By.xpath("//*[@id=\"app-layer-destination-hotel\"]/div[2]/div/div[2]/div[1]/ul/li[1]/button")).click();
        driver.findElement(By.xpath("//*[@id=\"destinationCity\"]")).sendKeys("amd");
       // driver.findElement(By.xpath("//a[@id='aria-option-0']")).click();
       // WebElement departingField = driver.findElement(By.xpath("//input[@id='flight-departing-hp-flight']"));
      //  departingField.click();
//        WebElement calMonth = driver.findElement(By.xpath("//*[@id=\"departureDate\"]"));
//
//
//        List<WebElement> allValidDates = calMonth.findElements(By.id("departureDate"));
//        System.out.println(allValidDates);
//        Thread.sleep(3000);
//
//        for (WebElement date : allValidDates) {
//            if (date.getText().equals("31")) {
//                date.click();
//                break;
//            }
//        }
driver.findElement(By.id("departureDate")).click();
driver.findElement(By.xpath("/html/body/div[21]/div[1]/table/tbody/tr[2]/td[6]")).click();

    }
    //@After
    public void tearDown() throws Exception {
        Thread.sleep(3000);
        driver.quit();
    }

}
