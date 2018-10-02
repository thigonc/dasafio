package tests;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class RunFeatureTest {
    private WebDriver driver;

    @Before
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Dell\\IdeaProjects\\Desafio\\Drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void testDesafio() throws InterruptedException {
        driver.get("http://saucelabs.com//");
        driver.findElement(By.className("_16Ez")).click();
        Thread.sleep(2000);
        driver.findElement(By.linkText("Cross Browser Testing")).click();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        WebElement text = driver.findElement(By.className("site-content"));
        String textelement = text.getText();
        if (textelement.contentEquals("RunSelenium\\tests\\securely\\in\\the\\cloud")){
            System.out.println("Contém");
        }else{
            System.out.println("Não contém");
        }

    }

    @Test

    public void testDesafio2() throws InterruptedException {
        driver.get("https://github.com");
        driver.findElement(By.className("header-search-input")).sendKeys("selenium");
        WebElement send = driver.switchTo().activeElement();
        send.sendKeys(Keys.ENTER);
        driver.findElement(By.linkText("SeleniumHQ/selenium")).click();
    }

    @Test

    public void testDesafio3(){
        driver.get("http://extentreports.com");
        driver.findElement(By.linkText("Java docs")).click();
        String te = driver.findElement(By.xpath("//*[@id=\"rightCol\"]/table/tbody/tr[8]/td[3]/i")).getText();
        System.out.println(te);
        if (driver.findElements(By.xpath("//*[@id=\"rightCol\"]/table/tbody/tr[8]/td[3]")).contains(driver.findElement(By.className("text-success")))) {
            System.out.println("Contém");
        }else{
            System.out.println("Não contém");
        }
    }

    @After
    public void fecharNavegador(){
        driver.quit();
    }

}
