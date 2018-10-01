package tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

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
//        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        Thread.sleep(2000);
        driver.findElement(By.linkText("Cross Browser Testing")).click();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

        WebElement text = driver.findElement(By.className("site-content"));

        String textelement = text.getText();

        System.out.println(textelement);

        if (textelement.contentEquals("RunSelenium\\tests\\securely\\in\\the\\cloud")){
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
